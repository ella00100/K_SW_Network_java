package day23;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.net.SocketException;

public class NetworkInterfaceTest {
    public static void main(String[] args){
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.printf("이름        디스플레이 이름\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-10s %-50s\n", element.getName(), element.getDisplayName());
            }
        } catch(SocketException ex){
            System.out.println();
        }
    }
}
