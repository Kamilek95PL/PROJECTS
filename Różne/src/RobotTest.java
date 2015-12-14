/**
 * Created by Kamil on 12/13/2015.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
public class RobotTest {
        Robot robot;
        int img = 0;
        String[] format = {"gif", "png", "jpg"};
        int actualFormat = 0;
        public RobotTest() {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                System.err.println("Co ten robot wyprawia?!");
                e.printStackTrace();
            }
        }
        public void printText() {
            int[] text = {KeyEvent.VK_H, KeyEvent.VK_E, KeyEvent.VK_L, KeyEvent.VK_L, KeyEvent.VK_O, KeyEvent.VK_SPACE,
                    KeyEvent.VK_W, KeyEvent.VK_O, KeyEvent.VK_R, KeyEvent.VK_L, KeyEvent.VK_D};
            //p?tla - wci?ni?cie przycisku i przerwa na 200ms
            for(int i=0; i<text.length; i++) {
                robot.keyPress(text[i]);
                robot.delay(200);
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
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
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
            RobotTest test = new RobotTest();
//            test.robot.delay(3000);
//            test.printText();
            while (true) {
                test.screenCapture();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {  }
            }
        }
}
