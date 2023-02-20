package day21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetaddress {
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.naver.com");
            System.out.println(address);
            System.out.println(address.getCanonicalHostName());
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
        }catch(UnknownHostException e){
        }
    }
}
