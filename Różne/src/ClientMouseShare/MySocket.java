import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 18.12.15.
 */
public class MySocket {
    static int x=1, y=1;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.0.102", 666);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String input = in.readLine();
//            System.out.println(input);
            while (true) {
                out.println(x);
                out.println(y);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
            }
//            out.close();
//            in.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
