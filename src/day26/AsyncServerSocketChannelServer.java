package day26;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncServerSocketChannelServer {

    public AsyncServerSocketChannelServer() {
        System.out.println("비동기 서버 시작됨");
        try (
                AsynchronousServerSocketChannel serverChannel
                        = AsynchronousServerSocketChannel.open()) {
            InetSocketAddress hostAddress
                    = new InetSocketAddress("localhost", 5000);
            serverChannel.bind(hostAddress); //서버 채널과 localhost 연결

            System.out.println("클라이언트 요청 대기 중... ");
            Future acceptResult = serverChannel.accept(); //Future을 사용하여 연결 대기

            //클라이언트 요청 처리
            try (
                    AsynchronousSocketChannel clientChannel //비동기 소켓 채널 생성
                         = (AsynchronousSocketChannel) acceptResult.get()) { //채널이 생성 될 때까지 get메서드 block

                System.out.println("클라이언트로 부터 온 메세지");

                // 버퍼 할당, 채널 읽기, 버퍼가 채워지면 flip
                while ((clientChannel != null) && (clientChannel.isOpen())) {
                    ByteBuffer buffer = ByteBuffer.allocate(32);
                    Future result = clientChannel.read(buffer);
                    // Technique 1
                    while (!result.isDone()) {
                        // do nothing
                    }
                    // Technique 2
//                    result.get();
                    // Technique 3
//                    result.get(10, TimeUnit.SECONDS);
                    buffer.flip();

                    String message = new String(buffer.array()).trim();
                    System.out.print("< ");
                    System.out.println(message);
                    if (message.equals("quit")) {
                        break;
                    }
                }
            }
        } catch (IOException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
//        } catch (TimeoutException ex) {
//            // Used with get method when a timeout is specified
//            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AsyncServerSocketChannelServer();
    }

}
