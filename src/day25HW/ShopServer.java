package day25HW;

import day25.ClientHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

import static java.net.StandardSocketOptions.SO_RCVBUF;

public class ShopServer {
    private static final HashMap<String,Float> parts = new HashMap<>();

    public ShopServer() throws NullPointerException {
        System.out.println("Shop Server 시작");
        initializeParts();
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open(); //서버 채널 열기
            ssc.socket().bind(new InetSocketAddress(5000));  // 5000번 포트에 bind
            ssc.setOption(SO_RCVBUF, 64); //

            boolean running = true;
            while (running) {
                System.out.println("클라이언트 접속 대기 중...");
                SocketChannel sc = ssc.accept();
                //clientHandler의 객체가 Thread의 인수로 들어감
                new Thread(new ClientHandler(sc)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initializeParts() { //dict(key(문자), value(double))
        parts.put("Hammer", 12.55f);
        parts.put("Nail", 1.35f);
        parts.put("Pliers", 4.65f);
        parts.put("Saw", 8.45f);
    }

    public static Float getPrice(String partName) {
        return parts.get(partName);
    }

    public static void main(String[] args) {
        new ShopServer();
    }
}
