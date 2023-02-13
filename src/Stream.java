import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Stream{
    public static void main(String[] args){
        try{
            InputStream is = new FileInputStream("C:/Temp/test2.db");

            byte[] data = new byte[100];

            while(true){
                int num = is.read(data);    // data를 읽고 반환
                if(num == 1) break;

                for(int i = 0; i < num; i++){ // 출력
                    System.out.println(data[i]);
                }
            }

            is.close(); // 입력스트림 닫고 사용 메모리 해제
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
