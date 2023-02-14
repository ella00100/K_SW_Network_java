package day21;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.IOException;

public class day21 {
    public static void main(String[] args){
        try {
            URL url = new URL("http://www.inha.ac.kr");     // URL 객체 생성
            URLConnection urlConnection = url.openConnection();  // URLConnection 객체 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }catch  (MalformedURLException e){
            throw new RuntimeException(e);
        }
        catch (IOException ex) {
            System.out.println("test");
        }
    }
}
