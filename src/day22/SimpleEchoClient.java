package day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SimpleEchoClient {

    public static void main(String args[]) {
        System.out.println("Simple Echo Client");

        try {
            System.out.println("서버 연결 대기 중...");
            InetAddress localAddress = InetAddress.getLocalHost();

            try (Socket clientSocket = new Socket(localAddress, 6000);
                 PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(
                                 clientSocket.getInputStream()))) {
                System.out.println("서버 연결 완료");
                Scanner scanner = new Scanner(System.in);

                // Traditional implementation
//                while (true) {
//                    System.out.print("Enter text: ");
//                    String inputLine = scanner.nextLine();
//                    if ("quit".equalsIgnoreCase(inputLine)) {
//                        break;
//                    }
//                    out.println(inputLine);
//
//                    String response = br.readLine();
//                    System.out.println("Server response: " + response);
//                }
                // Java 8 implementation
                Supplier<String> scannerInput = () -> scanner.nextLine();
                System.out.print("메세지 입력 > ");
                Stream.generate(scannerInput)
                        .map(s -> {
                            out.println(s);
                            System.out.println("서버 반응 : " + s);
                            System.out.print("메세지 입력 > ");
                            return s;
                        })
                        .allMatch(s -> !"quit".equalsIgnoreCase(s));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
