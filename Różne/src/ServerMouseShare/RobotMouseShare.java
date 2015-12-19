package ServerMouseShare; /**
 * Created by kamil on 18.12.2015.
 */
/**
 * Created by Kamil on 12/13/2015.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
public class RobotMouseShare {
    MyServerSocket myServerSocket = new MyServerSocket();
    Robot robot;
    int img = 0;
    String[] format = {"gif", "png", "jpg"};
    int actualFormat = 0;
    int sWidth, sHeight;
    boolean dupa = false;
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    void mouseMovee(double x, double y) {
        robot.mouseMove((int) (dimension.width * x), (int) (dimension.height * y));
    }
    void mouseLeftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    void mouseRightClick() {
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
    RobotMouseShare() {
        System.out.println("-1");
        System.exit(0);
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            System.err.println("Co ten robot wyprawia?!");
//            e.printStackTrace();
//        }
//        sWidth = dimension.width;
//        sHeight = dimension.height;
        System.out.println("0");
//        while (true) {
//            System.out.println("1");
////            System.out.println(myServerSocket.x);
////            if (myServerSocket.x != 500) {
////                robot.mouseMove(myServerSocket.x, myServerSocket.y);
////            }
////            robot.delay(100);
//        }

    }
    public void printText(String toWrite) {
        for(int i=0; i<toWrite.length(); i++) {
            if(toWrite.charAt(i) == ' ') {
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
            }
            else {
                String toWriteUpper = toWrite.toUpperCase();
                if (toWriteUpper.charAt(i) == toWrite.charAt(i) && !Character.isDigit(toWrite.charAt(i))) {
                    robot.delay(10);
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.delay(10);
                }
                String code = "VK_" + toWriteUpper.charAt(i);
                Field f;
                try {
                    f = KeyEvent.class.getField(code);
                    int keyEvent = f.getInt(null);
                    robot.delay(10);
                    robot.keyPress(keyEvent);
                    robot.keyRelease(keyEvent);
                    robot.delay(10);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (toWriteUpper.charAt(i) == toWrite.charAt(i) && !Character.isDigit(toWrite.charAt(i))) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
            }
        }
    }
    BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
    public void screenCapture() {
//            long start = System.currentTimeMillis();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage screen = robot.createScreenCapture(rectangle);
//            screen = createResizedCopy(screen, 889, 500, true);
//            System.out.print(System.currentTimeMillis() - start + " ");
        try {
            Date date = new Date();
            ImageIO.write(screen, format[actualFormat], new File("screen/12x13/" + date.getHours() + "x" + date.getMinutes() + "x" + date.getSeconds() + "." + format[actualFormat]));
            if (actualFormat == 2)  actualFormat=0;
            else                    actualFormat++;
            img++;
        } catch (IOException e) {
            System.err.println("B??d zapisu obrazu");
            e.printStackTrace();
        }
//            System.out.println(System.currentTimeMillis() - start);
    }
    public static void main(String[] args) {
        System.out.println("a");
        new RobotMouseShare();
        System.out.println("b");
    }
}

