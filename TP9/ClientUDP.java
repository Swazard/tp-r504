import java.io.*;
import java.net.*;

public class ClientUDP
{
    public static void main(String[] args) throws IOException
    {
        String s="Hello World";

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("adresse=" +addr.getHostName() );
        byte[] data = s.getBytes();
        DatagramPacket packet = new DatagramPacket( data, data.length, addr, 1234);
        DatagramSocket sock = new DatagramSocket();
        sock.send(packet);

        DatagramPacket packet2 = new DatagramPacket (new byte [1024], 1024);
        sock.receive(packet2);
        String str = new String (packet2.getData());
        System.out.println("str=" + str);
        sock.close();
    }
}