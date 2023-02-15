package day23;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.net.SocketException;

class One{
    private One(){
    }
    public static One produceOneInstance(){
        return new One();
    }
}

public class Test {
    public static void main(String [] args){
        One o = One.produceOneInstance();
        One o2 = One.produceOneInstance();
    }
}
