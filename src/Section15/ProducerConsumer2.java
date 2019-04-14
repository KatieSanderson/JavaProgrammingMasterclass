package Section15;

import java.util.Random;
import java.util.concurrent.*;

public class ProducerConsumer2 {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer2 producer = new MyProducer2(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer2 consumer1 = new MyConsumer2(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer2 consumer2 = new MyConsumer2(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws CloneNotSupportedException {
                System.out.println(ThreadColor.ANSI_RED + "I'm printed from Callable");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer2 implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private ThreadColor color;

    public MyProducer2(ArrayBlockingQueue<String> buffer, ThreadColor color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding... " + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
        }
    }
}

class MyConsumer2 implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private ThreadColor color;

    public MyConsumer2(ArrayBlockingQueue<String> buffer, ThreadColor color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        int counter = 0;
        while (true) {
                while (buffer.isEmpty()) {
                    counter++;
                }
                if (buffer.isEmpty()) {
                    continue;
            }
        }
    }
}