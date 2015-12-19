package ClientMouseShare; /**
 * 18.12.15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * 10.12.15.
 */
public class MouseShareJPanel extends JPanel implements MouseListener, MouseMotionListener {
    static JFrame frame;
    SendMouseLocalisation sendMouseLocalisation = new SendMouseLocalisation();
    public void paint(Graphics g) {
        g.fillRect(0, 0, 1366, 768);
    }
    public void windowClosing(WindowEvent e)
    {
        System.out.println("Połączenie zakończone");
        System.exit(0);
        e.getWindow().dispose();
    }
    public static void main(String[] args) {

        SendMouseLocalisation sendMouseLocalisation = new SendMouseLocalisation();
        sendMouseLocalisation.start();
        int czasNaPolaczenie = 500; //ms
        for (int i=0; i<czasNaPolaczenie; i++) {
            if (sendMouseLocalisation.polaczenieUdane == false) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {   e.printStackTrace();      }
            }
            else {
                i=czasNaPolaczenie;
            }
        }
        if (sendMouseLocalisation.polaczenieUdane == false) {
            IOException connectFail = new IOException("Połączenie nie udane - serwer nie aktywny");
            try {
                throw connectFail;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }
        frame = new JFrame("Jframe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        MouseShareJPanel rysowanie = new MouseShareJPanel();
        rysowanie.setBounds(0, 0, 1366, 768);
        rysowanie.setPreferredSize(new Dimension(1366, 768));
        frame.getContentPane().add(rysowanie);
        frame.pack();
//        frame.setUndecorated(true);
        frame.setVisible(true);
//        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
//        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
//        frame.setBounds(maximumWindowBounds);
//        frame.setResizable(false);
        rysowanie.addMouseMotionListener(rysowanie);
    }
    public void mouseClicked(MouseEvent e) {    }
    public void mousePressed(MouseEvent e) {    }
    public void mouseReleased(MouseEvent e) {   }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseDragged(MouseEvent e) {    }
    public void mouseMoved(MouseEvent e) {
        SendMouseLocalisation.x = e.getX();
        SendMouseLocalisation.y = e.getY();
//        System.out.println(e.getX() + ":" + e.getY());
    }
}

