package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.stream.Stream;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("에코 서버 시작됨");
        try (ServerSocket serverSocket = new ServerSocket(9900)) { //서버 소켓 생성
            System.out.println("클라이언트 접속 대기 중.....");
            Socket clientSocket = serverSocket.accept();  // 클라이언트의 요청을 받아 Socket 객체 생성
            System.out.println("클라이언트 접속됨.");

            try (
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter pw =
                            new PrintWriter(clientSocket.getOutputStream(), true))
            {
                Stream
                        .generate(() -> {
                            try {
                                return br.readLine();
                            } catch (IOException ex) {
                                return null;
                            }
                        })
                        .peek(text -> {
                            System.out.println("클라이언트로 부터 받은 메세지 : " + text);
                            pw.println(text);
                        })
                        .allMatch(Objects::nonNull);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException ex) {
            System.out.println("접속 실패!");
        }
    }
}
