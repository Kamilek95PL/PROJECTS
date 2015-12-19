import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 19.12.15.
 */
public class JavaSoccet {
    public static void main(String[] args) {
        try {
            // server
            ServerSocket serverSocket = new ServerSocket(666);
            Socket socket = serverSocket.accept();
            // client
            Socket socket2 = new Socket("192.168.0.102", 666);
            // input BufferedReader
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input.readLine();
            // output PrintWriter
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("123");
            // input DataInputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            // output DataOuputStream
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
