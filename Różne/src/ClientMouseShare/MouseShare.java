/**
 * 18.12.15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 10.12.15.
 */
public class MouseShare extends JPanel implements MouseListener, MouseMotionListener {
    static JFrame frame;
    public void paint(Graphics g) {

    }
    public static void main(String[] args) {
        frame = new JFrame("Jframe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200);
        frame.setBounds(100, 100, 500, 500);
        frame.setPreferredSize(new Dimension(500, 500));
        MouseShare rysowanie = new MouseShare();
        rysowanie.setBounds(100, 100, 500, 500);
        frame.add(rysowanie);
        frame.setVisible(true);
        frame.pack();
        frame.addMouseMotionListener(rysowanie);

    }
    public void mouseClicked(MouseEvent e) {    }
    public void mousePressed(MouseEvent e) {    }
    public void mouseReleased(MouseEvent e) {   }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseDragged(MouseEvent e) {    }
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + ":" + e.getY());
    }
}

