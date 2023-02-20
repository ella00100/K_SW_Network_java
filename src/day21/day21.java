package day21;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class day21 {
    public static void main(String[] args){
        try {
            URL url = new URL("http://www.inha.ac.kr");     // URL 객체 생성
            URLConnection urlConnection = url.openConnection();  // URLConnection 객체 생성
            InputStream inputstream = urlConnection.getInputStream();

            //ReadableByteChannel은 read메소드를 이용해 사이트에서 읽기 작업이 가능하게 함
            ReadableByteChannel channel = Channels.newChannel(inputstream);

            //ByteBuffer는 채널에서 데이터 수신
            ByteBuffer br = ByteBuffer.allocate(64);
            String line = null;

            //read메소드는 읽은 바이트 수 반환
            while (channel.read(br) > 0) {
                System.out.println(new String(br.array()));
                br.clear();
            }
            channel.close();
        } catch (IOException ex) {
        }
    }
}
