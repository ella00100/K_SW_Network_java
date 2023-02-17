package day25HW;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ShopClient {
    public ShopClient() throws NullPointerException {
        SocketAddress addr = new InetSocketAddress("127.0.0.1", 3000);
        try (SocketChannel sc = SocketChannel.open(addr)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[상품 목록]");
            System.out.println("--------------------------------------------------------");
            System.out.println("no      name                     price         stock");
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            while (true) {
                // Get part name
                System.out.print("메뉴 : 1.Create  | 2.Update  | 3.Delete  | 4.Exit\n");
                System.out.print("선택 : ");
                String menu = scanner.nextLine();
                if (menu.equalsIgnoreCase("4")) {
                    HelperMethods.sendMessage(sc, "quit");
                    break;
                } else if (menu == "2"){
                    HelperMethods.sendMessage(sc, menu);
                    System.out.println("가격 : " + HelperMethods.receiveMessage(sc));
                }
            }
            System.out.println("Shop Client 종료");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ShopClient();
    }
}