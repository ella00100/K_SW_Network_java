package day23;

import java.io.IOException;

public class StreamTest {
    public static void main(String [] args) throws IOException{
        int b, len = 0;
        int array[] = new int[100];

        System.out.println("##    입력스트림     ##");
        while ((b =System.in.read()) != '\n'){
            System.out.printf("%c(%d)", (char)b, b);
            array[len++] = b;
        }
        System.out.println();

        System.out.println("##    출력스트림     ##");
        for (int i =0; i < len; i++)
            System.out.print((char)array[i]);

        System.out.flush();

    }

}
