package Section15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int wrongCount = 0;
        for (int i = 0; i < 10000; i++) {
            BankAccount account = new BankAccount("12345", 1000);

            int threadSets = 5;
            int threadCount = 2;
            Thread[] threads = new Thread[threadSets * threadCount];
            for (int j = 0; j < threadSets; j++) {
                threads[j * threadCount] = createThread(account, 100, 50, account.lock);
                threads[j * threadCount + 1] = createThread(account, 50, 100, account.lock);

            }

            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }

            if (account.balance != 1000) {
                wrongCount++;
                System.out.println("Balance is " + account.balance);

            }
        }
        System.out.println("Balance was wrong " + wrongCount + " times");
        System.out.println("Took " + (System.currentTimeMillis() - start) + "ms");

    }

    private static Thread createThread(BankAccount account, int deposit, int withdraw, ReentrantLock bufferLock) {
        return new Thread(() -> {
            account.deposit(deposit, bufferLock);
            account.withdraw(withdraw, bufferLock);
        });
    }

    public BankAccount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount, ReentrantLock bufferLock) {
//        try {
//            bufferLock.lock();
//            balance += amount;
//        } finally {
//            bufferLock.unlock();
//        }
        boolean status = false;
        try {
            if (bufferLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                 try {
                     balance += amount;
                     status = true;
                 } finally {
                     bufferLock.unlock();
                 }
            } else {
                System.out.println("Couldn't get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Status is " + status);
    }

    public void withdraw(double amount, ReentrantLock bufferLock) {

        boolean status = false;
        try {
            if (bufferLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    bufferLock.unlock();
                }
            } else {
                System.out.println("Couldn't get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Status is " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println(accountNumber);
    }
}
