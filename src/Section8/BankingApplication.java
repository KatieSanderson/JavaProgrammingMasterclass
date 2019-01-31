package Section8;

import java.util.Scanner;

public class BankingApplication {

    private Bank bank;

    private BankingApplication(Bank bank) {
        this.bank = bank;
    }

    public static void main(String[] args) {
        try {
            BankingApplication bankApp = new BankingApplication(new Bank());
            bankApp.run();
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private void run() {
        System.out.println("Welcome to banking application");
        printOptions();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please pick an option");
                String option = scanner.nextLine();
                pickOption(scanner, option);
                if (!playAgain(scanner)) {
                    break;
                }
            }
        }
    }

    private boolean playAgain(Scanner scanner) {
        System.out.println("Would you like to continue?" );
        String playAgain = scanner.nextLine().toLowerCase();
        return playAgain.equals("y") || playAgain.equals("yes");
    }

    private void pickOption(Scanner scanner, String option) {
        switch (option) {
            case "0" :
                System.out.println("Add new branch");
                System.out.println("Enter branch name");
                String branchName = scanner.nextLine();
                bank.addBranch(branchName);
                break;
            case "1" :
                System.out.println("Add new customer in branch");
                System.out.println("Enter branch");
                branchName = scanner.nextLine();
                System.out.println("Enter customer");
                String customerName = scanner.nextLine();
                System.out.println("Enter initial transaction");
                double initialTransaction = scanner.nextDouble();
                scanner.nextLine();
                bank.addCustomer(branchName, customerName, initialTransaction);
                break;
            case "2" :
                System.out.println("Enter transaction for customer");
                System.out.println("Enter branch");
                branchName = scanner.nextLine();
                System.out.println("Enter customer");
                customerName = scanner.nextLine();
                System.out.println("Enter transaction");
                double transaction = scanner.nextDouble();
                bank.addTransaction(branchName, customerName, transaction);
            case "3" :
                System.out.println("Show list of customers");
                System.out.println("Enter branch");
                branchName = scanner.nextLine();
                System.out.println("Would you like transactions included? Y/N");
                boolean includeTransactions = false;
                String include = scanner.nextLine().toLowerCase();
                if (include.equals("y") || include.equals("yes")) {
                    includeTransactions = true;
                }
                bank.listCustomersOfBranch(branchName, includeTransactions);
            default :
                break;
        }
    }

    private void printOptions() {
        System.out.println(
                "0 - Add new branch\n" +
                "1 - Add new customer in branch\n" +
                "2 - Add transaction for customer\n" +
                "3 - Show list of customers in branch (with or without transactions)");
    }
}
