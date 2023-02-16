package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {
    public static void main(String [] args) throws IOException{
        String input = "C:\\network_java\\org.txt";
        String output = "C:\\network_java\\dup.txt";

        try(FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output)){
            int c;

            while((c = fis.read()) != -1)
                fos.write(c);

        }catch (IOException e) {
        }
    }
}
