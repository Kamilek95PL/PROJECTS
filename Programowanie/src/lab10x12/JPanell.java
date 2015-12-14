package lab10x12;

import javax.swing.*;
import java.awt.BorderLayout;

/**
 * 10.12.15.
 */
public class JPanell {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(100, 100, 320, 240);
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton northButton = new JButton("Północ");
        JButton southButton = new JButton("Południe");
        JButton eastButton = new JButton("Wschód");
        JButton westButton = new JButton("Zachód");
        buttonPanel.add(northButton, BorderLayout.NORTH);
        buttonPanel.add(southButton, BorderLayout.SOUTH);
        buttonPanel.add(eastButton, BorderLayout.EAST);
        buttonPanel.add(westButton, BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
