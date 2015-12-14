package main;

import org.jsfml.graphics.*;

import java.io.IOException;

/**
 * 22.10.15.
 */
public class Different {
    public static Font arialFont = new Font();
    private static Text infoText = new Text();
    private static Text infoText2 = new Text();
    public static int safeDivision(int x, int y) {
        try {
            return x / y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie przez 0");
            return -1;
        }
    }
    public static double safeDivisionDouble(int x, int y) {
        try {
            return (double)x / (double)y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie przez 0 Double");
            return -1;
        }
    }
    public static int safeDivisionWithRest(int x, int y) {
        try {
            return x % y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie z resztą przez 0");
            return -1;
        }
    }
    private static int info1 = 0, info2 = 0;
//    public static String localisation(String nameFile) {
//        String result = main.Selected.class.getResource(nameFile).toString().replace("file:", "").replace("jar:", "").replace("/jsfml.jar!", "").replace("%20", "");
//        if (result.substring(2, 3).equals(":")) {
//            result = result.substring(3);
//        }
//        return result;
//    }
    public static Sprite setSprite(String nameFile) {
        Texture texture = new Texture();
        try {
//            texture.loadFromFile(Paths.get(localisation(nameFile)));
            texture.loadFromStream(Different.class.getResourceAsStream("picture/" + nameFile));
        } catch (IOException e) {
            System.out.println("1");
        }
        return new Sprite(texture);
    }
    public static void initiation() {
        try {
            arialFont.loadFromStream(Different.class.getResourceAsStream("picture/arial.ttf"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        infoText.setFont(arialFont);
        infoText.setPosition(Main.resolutionX-400, Main.resolutionY-50);
        infoText.setColor(Color.RED);
        infoText2.setFont(arialFont);
        infoText2.setPosition(Main.resolutionX-400, Main.resolutionY-100);
        infoText2.setColor(Color.RED);
    }
    public static void setInfo(String string) {
        if (info1 == 0) {
            infoText.setString(string);
            info1 = 100;
        }
        else {
            infoText2.setString(string);
            info2 = 100;
        }
    }
    public static void setInfo(String string, int info) {
        if (info1 == 0) {
            infoText.setString(string);
            info1 = info;
        }
        else {
            infoText2.setString(string);
            info2 = info;
        }
    }
    public static void drawInfo() {
        if (info1 >0) {
            Main.window.draw(infoText);
            info1--;
        }
        if (info2>0) {
            Main.window.draw(infoText2);
            info2--;
        }
    }
}
