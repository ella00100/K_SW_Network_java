package day25;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("Char Server 시작");
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open(); //ServerSocketChannel 열기
            ssc.socket().bind(new InetSocketAddress(5000));  //5000번 포트에 bind
            boolean running = true;
            while (running) {
                System.out.println("클라이언트 접속 대기 중...");
                SocketChannel sc = ssc.accept(); // 연결 전까지 blocking
                System.out.println("클라이언트 연결됨");

                String msg;
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    //메세지 보내기
                    System.out.print("> ");
                    msg = scanner.nextLine(); // 키보드 입력 받아오기

                    //만약 quit을 입력하면 서버 종료
                    if (msg.equalsIgnoreCase("quit")) { //quit을 입력하면 종료
                        //HelperMethods.sendFixedLengthMessage(sc, "서버 종료");
                        HelperMethods.sendMessage(sc, "서버 종료");
                        running = false;
                        break;
                    } else {
                        //HelperMethods.sendFixedLengthMessage(sc, msg);
                        HelperMethods.sendMessage(sc, msg);

                        /// 클라이언트에서 메세지 받아오기
                        System.out.println("클라이언트로부터의 메세지 대기 중...");
                        //System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(sc));
                        System.out.println("Message: " + HelperMethods.receiveMessage(sc));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}