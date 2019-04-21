package Section20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); //getByName() for another host
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echoString;
            do {
                System.out.println("Enter string to echo: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);
                byte[] recieveBuffer = new byte[50];
                packet = new DatagramPacket(recieveBuffer, recieveBuffer.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is " + new String(recieveBuffer));
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e){
            System.out.println("Socket time-out");
        } catch (IOException e) {
            System.out.println("CLient error: " + e.getMessage());
        }
    }
}
