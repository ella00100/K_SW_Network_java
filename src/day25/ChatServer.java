package day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("Char Server 시작");
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(5000));
            boolean running = true;
            while (running) {
                System.out.println("클라이언트 접속 대기 중...");
                SocketChannel socketChannel = ssc.accept();
                System.out.println("클라이언트 연결됨");

                String msg;
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("> ");
                    msg = scanner.nextLine();
                    if (msg.equalsIgnoreCase("quit")) {
                        HelperMethods.sendFixedLengthMessage(socketChannel, "서버 종료");
                        running = false;
                        break;
                    } else {
                        HelperMethods.sendFixedLengthMessage(socketChannel, msg);
                        System.out.println("클라이언트로부터의 메세지 대기 중...");
                        System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(socketChannel));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}