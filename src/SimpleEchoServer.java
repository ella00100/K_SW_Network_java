import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("에코 서버 시작됨");
        try (ServerSocket serverSocket = new ServerSocket(6000)) { // ServerSocket 객체 생성 (포트 바인딩 : 6000번)
            System.out.println("클라이언트 접속 대기 중.....");
            Socket clientSocket = serverSocket.accept();  // 접속 대기
            System.out.println("클라이언트 접속됨.");

            BufferedReader br = null;
            PrintWriter pw = null;
            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                pw = new PrintWriter(clientSocket.getOutputStream(), true);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("클라이언트로 부터 받은 메세지 : " + line);
                    pw.println(line);  // 클라이언트로 송신
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                br.close();
                pw.close();
            }
        }
        catch (IOException ex) {
            System.out.println("접속 실패!");
        }
    }
}
