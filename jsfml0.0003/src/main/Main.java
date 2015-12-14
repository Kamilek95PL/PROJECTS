package main;

import menActions.MenActionsControl;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;

/**
 * 29.10.15.
 */
public class Main {
    public static RenderWindow window = new RenderWindow();
    public static int resolutionX, resolutionY;
    public static void initiation() {
        resolutionX = VideoMode.getDesktopMode().width;
        resolutionY = VideoMode.getDesktopMode().height;
        window.create(new VideoMode(resolutionX, resolutionY), "Hello JSFML!", WindowStyle.FULLSCREEN);
        /*resolutionX = 1500;
        resolutionY = 800;
        window.create(new VideoMode(resolutionX, resolutionY), "Hello JSFML!");*/
        window.setFramerateLimit(60);
        window.setVerticalSyncEnabled(true);
    }
//    public static int getResolutionX() {
//        return resolutionX;
//    }
//    public static int getResolutionY() {
//        return resolutionY;
//    }
    public static void main(String[] args) {
        initiation();
        Different.initiation();
        Cam.initiation();
        Selected.initiation();
        Background.initiation();
        Men.initiation();
        Hut.initiation();
        Save.initLoad();
        MenActionsControl.initiation();
        MenuLoop.initiation();
        while (true) {
            MenuLoop.menuLoop();
            GameLoop.mainLoop();
        }
    }
    public static void draw(Drawable drawable) {
        window.draw(drawable);
    }
}
