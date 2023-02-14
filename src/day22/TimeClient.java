package day22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TimeClient {
    // MultiCast Client
    public static void main(String args[]) {
        System.out.println("멀티 캐스트 타임 클라이언트");
        MulticastSocket socket = null;
        try{
            socket = new MulticastSocket(10000);
            InetAddress group = InetAddress.getByName("224.0.0.117");
            socket.joinGroup(group);
            System.out.println("멀티캐스트 타임 서버 그룹에 조인 완료");
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            for (int i = 0; i < 10; i++) {
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println(received.trim());
            }
            socket.leaveGroup(group);  // 멀티캐스트 타임 서버 탈퇴
        }
        catch (IOException ex) {
            System.out.println("입출력 예외 발생!");
        }
        finally {
            if(socket != null) socket.close();
        }
        System.out.println("멀티 캐스트 타임 클라이언트 종료됨");
    }
}

