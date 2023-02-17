package day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PartsClient {

    public PartsClient() throws NullPointerException {
        System.out.println("Part Client 시작");
        SocketAddress addr = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel sc = SocketChannel.open(addr)) {
            System.out.println("Part Server와 연결됨");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Get part name
                System.out.print("상품명 입력 > ");
                String partName = scanner.nextLine();
                if (partName.equalsIgnoreCase("quit")) {
                    HelperMethods.sendMessage(sc, "quit");
                    break;
                } else {
                    HelperMethods.sendMessage(sc, partName);
                    System.out.println("가격 : " + HelperMethods.receiveMessage(sc));
                }
            }
            System.out.println("Part Client 종료");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PartsClient();
    }
}


