import java.io.*;
import java.net.*;

public class ServeurTCP3
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket socketserver = new ServerSocket(2016);
        while(true)
        {
            System.out.println("serveur en attente");
            Socket socket = socketserver.accept();
            System.out.println("Connection d'un client");
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String msg = dIn.readUTF();
            System.out.println( "Message:" + msg);
            socket.close();

            String rev = new StringBuilder(msg).reverse().toString();
            System.out.println(rev);
            Socket socket2 = new Socket("localhost", 2017);
            DataOutputStream dOut = new DataOutputStream(socket2.getOutputStream());
            dOut.writeUTF(rev);
            socket2.close();
        }
//        socketserver.close();
    }
}