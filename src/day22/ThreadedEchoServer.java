package day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ThreadedEchoServer implements Runnable {

    private static Socket clientSocket;

    public ThreadedEchoServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        System.out.println("Threaded Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기 중...");

                clientSocket = serverSocket.accept();
                ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
                new Thread(tes).start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Threaded Echo Server 종료");
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread() + "] 클라이언트와 연결");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     clientSocket.getOutputStream(), true)) {
            // Traditional implementation
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("[" + Thread.currentThread() + "] 클라이언트 요청 : " + inputLine);
                out.println(inputLine);
            }
            System.out.println("클라이언트 [" + Thread.currentThread() + " 연결 종료");
            // Functional implementation
//                Supplier<String> socketInput = () -> {
//                    try {
//                        return br.readLine();
//                    } catch (IOException ex) {
//                        return null;
//                    }
//                };
//                Stream<String> stream = Stream.generate(socketInput);
//                stream
//                        .map(s -> {
//                            System.out.println("Client request: " + s);
//                            out.println(s);
//                            return s;
//                        })
//                        .allMatch(s -> s != null);
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }
}
