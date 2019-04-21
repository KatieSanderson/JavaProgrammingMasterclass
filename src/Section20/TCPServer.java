package Section20;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
//                Socket socket = serverSocket.accept();
//                TCPEchoer echoer = new TCPEchoer(socket);
//                echoer.start();
                new TCPEchoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
