package Section15;

import java.util.Random;

public class Messages {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean isEmpty = true;

    public synchronized String read() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isEmpty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isEmpty = false;
        notifyAll();
        this.message = message;
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer (Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "Humpty Dump sat on a wall",
                "Humpty Dumpy had a great fall",
                "All the kings horses and all the kings mens",
                "Couldn't put Humpy together again"
        };

        Random random = new Random();

        for (String message1 : messages) {
            message.write(message1);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader (Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}