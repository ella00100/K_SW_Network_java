package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SimpleEchoServer {

    public static void main(String[] args) {
        System.out.println("Simple Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(6000)){
            System.out.println("클라이언트 접속 대기...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결 완료");

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {
                // Traditional implementation
//                String inputLine;
//                while ((inputLine = br.readLine()) != null) {
//                    System.out.println("Client request: " + inputLine);
//                    out.println(inputLine);
//                }

                 //Functional implementation
                Supplier<String> socketInput = () -> {
                    try {
                        return br.readLine();
                    } catch (IOException ex) {
                        return null;
                    }
                };
                Stream<String> stream = Stream.generate(socketInput);
                stream
                        .map(s -> {
                            System.out.println("클라이언트 요청 : " + s);
                            out.println(s);
                            return s;
                        })
                        .allMatch(s -> s != null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Simple Echo Server 종료");
    }
}


