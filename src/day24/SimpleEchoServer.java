package day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// IP 165.246.115.165 포트 20000

public class SimpleEchoServer implements Runnable {
    // 다중 접속 에코 서버
    private static Socket clientSocket;
    public SimpleEchoServer(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }
    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(50);  // 5 threads
        System.out.println("다중 접속 에코 서버");

        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기 중.....");
                clientSocket = serverSocket.accept();
                SimpleEchoServer tes = new SimpleEchoServer(clientSocket);
                eService.submit(tes);
            }
        } catch (IOException ex) {
            System.out.println("입출력 예외 발생!");
        }
        System.out.println("다중 접속 에코 서버 종료");
        eService.shutdown();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " 스레드 접속");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(clientSocket.getRemoteSocketAddress().toString() + " " + Thread.currentThread() +" 클라이언트가 보낸 메세지 : " + line);
                try{
                    StringTokenizer st = new StringTokenizer(line,"+-*/", true);
                    int result = 0, operand = 0;
                    char operator = '+';

                    while(st.hasMoreTokens()){
                        String token = st.nextToken().trim();

                        if("+-*/".indexOf(token) >= 0){
                            operator = token.charAt(0);
                        }else{
                            operand = Integer.parseInt(token);

                            switch (operator){
                                case '+':
                                    result = result + operand;
                                    break;
                                case '-':
                                    result = result - operand;
                                    break;
                                case '*':
                                    result = result * operand;
                                    break;
                                case '/':
                                    result = result / operand;
                                    break;
                            }
                        }
                    }
                    pw.println(line+"="+result);
                }catch (NumberFormatException err){
                    pw.println("유효하지 않은 입력 값 입니다. 숫자를 입력해주세요.");
                }
            }
            System.out.println(Thread.currentThread() +" 클라이언트가 종료됨"); }
        catch (IOException ex)
        {
            System.out.println("입출력 예외 발생!");
        }
    }
}


