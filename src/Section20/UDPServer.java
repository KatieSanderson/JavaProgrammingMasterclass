package Section20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            while (true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Text received is: " + new String(buffer));
                String returnString = "Echo: " + new String(buffer);
                byte[] returnBuffer = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(returnBuffer, returnBuffer.length, address, port);
                socket.send(packet);
            }

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage()) ;
        } catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
        }
    }
}
