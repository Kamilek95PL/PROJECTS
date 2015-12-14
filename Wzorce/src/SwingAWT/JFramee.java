package SwingAWT;

import javax.swing.*;
import java.awt.*;
public class JFramee extends JFrame
{
    public JFramee () {
        super("Rysowanie");
        setSize(new Dimension(400, 400));
        add(new Penell());
        setDefaultCloseOperation(JFramee.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)  {
        new JFramee();
    }
}