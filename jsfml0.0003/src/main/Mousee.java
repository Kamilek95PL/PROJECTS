package main;

import org.jsfml.window.Mouse;

/**
 * 29.10.15.
 */
public class Mousee {
    private static int x=100, y=100;
    public static void updateXandY() {
        x = Mouse.getPosition(Main.window).x;
        y = Mouse.getPosition(Main.window).y;
    }
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public static boolean rightClick() {
        return Mouse.isButtonPressed(Mouse.Button.RIGHT);
    }
    public static boolean leftClick() {
        return Mouse.isButtonPressed(Mouse.Button.LEFT);
    }
}
