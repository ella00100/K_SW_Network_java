import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Stream {
    public static void main(String[] args) {
        try {
            //C:/Temp에 test1.db파일 생성
            OutputStream os = new FileOutputStream("C:/Temp/test2.db");

            byte[] array = {10,20,30};

            os.write(array);   //배열이 모든 바이트 출력

            os.flush();     // 내부 버퍼에 잔류하는 바이트 출력, 바이트 비움
            os.close();     // 출력스트림을 닫아 사용한 메모리 해제
        } catch (IOException e) { //파일을 생성 못하면 IOException 발생
            e.printStackTrace();
        }
    }
}
