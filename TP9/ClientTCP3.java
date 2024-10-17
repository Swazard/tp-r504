import java.io.*;
import java.net.*;

public class ClientTCP3
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 2016);
        DataOutputStream dOut = new DataOutputStream (socket.getOutputStream());
        dOut.writeUTF(args[0]);
        socket.close();

        ServerSocket socketserver = new ServerSocket(2017);
        System.out.println("serveur en attente");
        Socket socket2 = socketserver.accept();
        System.out.println("Connection d'un client");
        DataInputStream dIn = new DataInputStream(socket2.getInputStream());
        System.out.println( "Message:" + dIn.readUTF());
        socket2.close();
        socketserver.close();
    }
}