import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kamil on 18.12.2015.
 */
public class MyServerSocket {
    int x=500, y=500;
    MyServerSocket() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(666);
            Socket clientSocket = serverSocket.accept();
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            out.println("polaczenie udane");
            while (true){
                x = Integer.valueOf(in.readLine());
                y = Integer.valueOf(in.readLine());
//                System.out.println(x + ":" + y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            out.close();
//            in.close();
//            clientSocket.close();
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
