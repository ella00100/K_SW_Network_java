package day24;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class dateClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("클라이언트 > 날짜 서버의 IP주소는? ");
        String add = sc.nextLine();

        try(
                Socket client = new Socket(add,9000);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                ){
                String pw = in.readLine();
                System.out.println(pw);
        }catch (Exception e){
        }
    }
}
