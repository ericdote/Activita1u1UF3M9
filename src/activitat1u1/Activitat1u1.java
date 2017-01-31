package activitat1u1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Activitat1u1 {
    /**
     * Aquest metode captura totes les interficies de les quals disposem al nostre equip.
     * En cas de contenir alguna direccio les nostres interficies les mostraria, en cas contrari
     * Continua amb la seguent interficie. 
     * Quan acaba para.
     * @param args 
     */
    public static void main(String[] args) {
        try {
            //Declarem un atribut per anar capturant les interficies.
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            //Mentres tinguem interficies entrem al bucle.
            while (interfaces.hasMoreElements()) {
                //Capturem la interficie actual.
                NetworkInterface interfaz = interfaces.nextElement();
                //La mostrem.
                System.out.println(interfaz.getDisplayName());
                //Creem un atribut per capturar les diferents direccions.
                Enumeration<InetAddress> address = interfaz.getInetAddresses();
                //Mentres hi hagin mes adresses entrem al bucle.
                while (address.hasMoreElements()) {
                    //Capturem la adresa actual.
                    InetAddress ip = address.nextElement();
                    //Mostrem la direcio.
                    System.out.println(ip.getHostAddress());
                }
                System.out.println("------------------");
            }
        } catch (SocketException e) {
            System.out.println(e);
        }
    }
}
