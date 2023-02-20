package day26;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class AsyncSocketChannelClient {

    public static void main(String[] args) {
        System.out.println("비동기 클라이언트 시작");
        try (AsynchronousSocketChannel client = AsynchronousSocketChannel.open()) {
            InetSocketAddress hostAddress = new InetSocketAddress("localhost", 5000);
            Future future = client.connect(hostAddress);
            future.get(); // Blocks until connection made

            System.out.println("클라이언트 시작됨 : " + client.isOpen());
            System.out.println("서버에게 보낼 메세지 ");

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true) {
                System.out.print("> ");
                message = scanner.nextLine();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                Future result = client.write(buffer);
                while (!result.isDone()) {
                    // Wait
                }
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
            }
        } catch (IOException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

}
