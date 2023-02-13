import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Stream{
    public static void main(String[] args){
        try{
            InputStream is = new FileInputStream("C:/Temp/test1.db");

            while(true){
                int data = is.read(); // 1 byte 씩 읽어오기
                if (data == -1) break; //파일 끝에 도달하면 break
                System.out.println(data);}

            is.close(); // 입력스트림 닫고 사용 메모리 해제
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
