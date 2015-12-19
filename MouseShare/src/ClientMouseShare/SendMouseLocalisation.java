package ClientMouseShare;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 18.12.15.
 */
public class SendMouseLocalisation extends Thread {
    public static int x=-1, y=-1;
    public boolean polaczenieUdane = false;
    public void run() {
        try {
            System.out.println("Próba połączenia z serwerem 192.168.0.102 na porcie 666");
            Socket socket = new Socket("192.168.0.102", 666);
            polaczenieUdane = true;
            System.out.println("Połączono");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//            PrintWriter outt = new PrintWriter(socket.getOutputStream(),true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String input = in.readLine();
//            System.out.println(input);
            boolean work = true;
            while (work) {
                out.writeInt(x);
                out.writeInt(y);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {    }
            }
//            out.close();
//            in.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
