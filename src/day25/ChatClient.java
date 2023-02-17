package day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args){
        SocketAddress addr = new InetSocketAddress("127.0.0.1", 5000);
        try (
                SocketChannel sc = SocketChannel.open(addr)) { //Socket Channel 열기
                System.out.println("서버와 연결됨");

                String message;
                Scanner scanner = new Scanner(System.in);

            while (true) {
                // 서버에서 보낸 메세지 받아오기 (고정된 메세지 공간)
                System.out.println("서버로 부터의 메세지 대기중.. ");
                //System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(sc));
                System.out.println("Message: " + HelperMethods.receiveMessage(sc));

                // 메세지 보내기
                System.out.print("> ");
                message = scanner.nextLine();
                //만약 quit을 입력하면 클라이언트 종료
                if (message.equalsIgnoreCase("quit")) {
                    //HelperMethods.sendFixedLengthMessage(sc, "클라이언트 종료");
                    HelperMethods.sendMessage(sc, "클라이언트 종료");
                    break;
                }
                //HelperMethods.sendFixedLengthMessage(sc, message);
                HelperMethods.sendMessage(sc, message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
