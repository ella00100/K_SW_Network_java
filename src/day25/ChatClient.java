package day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args){
        SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            System.out.println("서버와 연결됨");
                    String message;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("서버로 부터의 메세지 대기중.. ");
                System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(socketChannel));
                System.out.print("> ");
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("quit")) {
                    HelperMethods.sendFixedLengthMessage(socketChannel, "클라이언트 종료");
                    break;
                }
                HelperMethods.sendFixedLengthMessage(socketChannel, message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
