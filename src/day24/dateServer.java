package day24;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.IOException;

public class dateServer {
    public static void main(String[] args) throws IOException {
        try(
                ServerSocket server = new ServerSocket(9000);
                Socket client = server.accept();
                PrintWriter pw = new PrintWriter(client.getOutputStream(),true)){
                pw.println("서버 > " + new Date().toString());
        }catch (IOException e){
        }

    }
}
