package activitat1u1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Activitat1u1 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            System.out.println("------------------");
            while (interfaces.hasMoreElements()) {
                NetworkInterface interfaz = interfaces.nextElement();
                System.out.println("Interfaz: " + interfaz.getDisplayName());
                Enumeration<InetAddress> direccion = interfaz.getInetAddresses();
                while (direccion.hasMoreElements()) {
                    InetAddress ip = direccion.nextElement();
                    System.out.println(ip.getHostAddress());
                }
                System.out.println("------------------");
            }
        } catch (SocketException e) {
            System.out.println(e);
        }
    }
}
