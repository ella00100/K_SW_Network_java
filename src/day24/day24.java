package day24;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class day24 {
    public static void main(String [] args) throws UnknownHostException{

        InetAddress names[] = InetAddress.getAllByName("www.naver.com");
        for (InetAddress element : names){
            System.out.println(element);
        }

        InetAddress address= null;
        try{
            address = InetAddress.getByName("www.packpub.com");
            System.out.println(address);
        }catch(UnknownHostException e) {
        }
    }
}
