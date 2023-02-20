package day22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class MulticastServer {

    public static void main(String args[]) {
        System.out.println("Multicast Time Server");
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket();
            //현재 날짜와 시간을 유지하는 바이트 배열 생성
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.0");

                //packet에 buffer(date를 bytes로 읽어 들인 것), buffer길이, 주소, 포트번호를 담아 seversocket에 보냄
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 8888);
                serverSocket.send(packet);
                System.out.println("Time sent: " + dateText);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
            //serverSocket.close();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
