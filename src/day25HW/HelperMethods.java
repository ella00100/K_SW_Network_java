package day25HW;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {
    public static void sendFixedLengthMessage(SocketChannel sc, String msg) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(64); //Byte buffer 생성, 크기 고정
            buffer.put(msg.getBytes()); //buffer에 msg 내용 쓰기
            buffer.flip();

            while (buffer.hasRemaining()) { //저장된 모든 내용을
                sc.write(buffer); // socket channel에 쓰기
            }
            System.out.println("Sent: " + msg);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String receiveFixedLengthMessage(SocketChannel sc) {
        String msg = "";
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(64); //byte buffer 생성, 크기 고정
            sc.read(byteBuffer); //socket channel 내용 읽어오기
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) { //buffer에 저장된 모든 내용을
                msg += (char) byteBuffer.get(); //msg에 버퍼 내용 쓰기
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    public static void sendMessage(SocketChannel sc, String msg) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(msg.length() + 1);
            buffer.put(msg.getBytes()); //버퍼에 메세지 내용 쓰기
            buffer.put((byte) 0x00);
            buffer.flip();
            while (buffer.hasRemaining()) {
                sc.write(buffer); //socketchannel에 버퍼 내용 입력
            }
            System.out.println("Sent: " + msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String receiveMessage(SocketChannel sc) {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            String msg = "";
            while (sc.read(byteBuffer) > 0) {
                char byteRead = 0x00;
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byteRead = (char) byteBuffer.get();
                    if (byteRead == 0x00) {
                        break;
                    }
                    msg += byteRead;
                }
                if (byteRead == 0x00) {
                    break;
                }
                byteBuffer.clear();
            }
            return msg;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
