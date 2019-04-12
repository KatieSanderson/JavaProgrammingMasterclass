package Section14;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class ReadingWritingNIO {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkCHannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "Time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkCHannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
