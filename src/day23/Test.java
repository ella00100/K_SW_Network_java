package day23;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.net.SocketException;

public class Test {
    public static String getMACIdentifier(NetworkInterface network){
        StringBuilder identifier = new StringBuilder();
        try {
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null) {
                for (int i = 0; i < macBuffer.length; i++) {
                    identifier.append(
                            String.format("%02X%s",macBuffer[i], (i < macBuffer.length - 1) ? "-" : ""));
                }
            } else {
                return "---";
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return identifier.toString();
    }

    public static void main(String[] args) throws SocketException {
        InetAddress addr = null;
        try{
            addr = InetAddress.getLocalHost();
            System.out.println("IP address: " + addr.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(addr);
            System.out.println("MAC address:" + getMACIdentifier(network));
        }catch(UnknownHostException e) {
        }
    }
}
