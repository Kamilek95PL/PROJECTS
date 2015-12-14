package SwingAWT;

import java.awt.*;

public class Penell extends Panel {
    // width -4  height -26
    static Graphics2D bg;
    static boolean tylkoPaint = true;
    public void paint (Graphics g) {
        if (tylkoPaint) {
            bg = (Graphics2D) getGraphics();
            tylkoPaint = false;
            System.out.println(getSize());

        }
        bg.fillOval(50,50,100,100);
        System.out.println(getSize());

        //        repaint();
    }
    public void repaint () {
    }
}