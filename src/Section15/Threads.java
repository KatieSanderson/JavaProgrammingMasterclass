package Section15;

public class Threads {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Main Thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from anon class!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anon class implementation of run");
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated or timed out, myRunnable running again");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "myRunnable Interrupted");
                }
            }
        });
        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Main Thread again");
    }
}
