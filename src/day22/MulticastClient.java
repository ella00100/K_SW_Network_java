package day22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

    public static void main(String args[]) {
        System.out.println("Multicast Time Client");
        //서버와 동일한 주소와 포트번호 할당
        try (MulticastSocket socket = new MulticastSocket(8888)) {
            InetAddress group = InetAddress.getByName("224.0.0.0");
            //joinGroup을 통해 그룹에 가입
            socket.joinGroup(group);
            System.out.println("Multicast Group Joined");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            //server의 메세지를 5번 수신하여 출력
            for (int i = 0; i < 5; i++) {
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println(received.trim());
            }

            socket.leaveGroup(group);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Multicast Time Client Terminated");
    }
}
