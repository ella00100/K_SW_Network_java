package HTTP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public WebServer() {
        System.out.println("Web Server 시작");
        try (ServerSocket sc = new ServerSocket(80)) {
            while (true) {
                System.out.println("Waiting for client request");
                Socket remote = sc.accept();
                System.out.println("Connection made");
                new Thread(new ClientHandler(remote)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new WebServer();
    }
}
