package day25;

import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable{

    private final SocketChannel socketChannel;

    public ClientHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void run() {
        System.out.println("Client Handler 시작 : " + this.socketChannel);
        String partName;
        while (true) {
            partName = HelperMethods.receiveMessage(socketChannel);
            if (partName.equalsIgnoreCase("quit")) {
                break;
            } else {
                Float price = PartsServer.getPrice(partName);
                HelperMethods.sendMessage(socketChannel, "" + price);
            }
        }
        System.out.println("Client Handler 종료 : " + this.socketChannel);
    }
}
