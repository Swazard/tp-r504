import java.io.*;
import java.net.*;

public class Clienthttp
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket(args[0], 80);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        InputStreamReader isw = new InputStreamReader(socket.getInputStream());

        BufferedWriter bufout = new BufferedWriter(osw);
        BufferedReader bufIn = new BufferedReader(isw);

        String request = "GET / HTTP/1.0\r\n\r\n"; // requete HTTP
        bufout.write(request, 0, request.length());
        bufout.flush();

        String line = bufIn.readLine(); // lecture ligne par ligne
        while (line != null) { // tant qu'il y a des donnees recues,
            System.out.println(line); // les afficher
            line = bufIn.readLine();
        }
        bufIn.close();
        bufout.close();
        socket.close();

    }
}

/* 
4.2 Le contenu du fichier n'est pas conforme à ce qu'on lui à demandé. En effet on a envoyé vers univ-rouen.fr, 
le code 403 indique que le serveur à compris la requête mais que elle ne l'éxécute pas.

4.3 Le fichier est aussi constitué de la requête que l'on à reçu.

4.4 www.javaworld.com : 404
www.github.com : 301
www.amazon.fr : 400
www.temu.com : 403
*/