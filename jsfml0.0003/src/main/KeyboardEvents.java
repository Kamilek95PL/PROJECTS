package main;

import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

/**
 * 29.10.15.
 */
public class KeyboardEvents {
    public static void check() {
        for (Event event : Main.window.pollEvents()) {
            if (event.type == Event.Type.KEY_PRESSED) {
                if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE)) {
                    MenuLoop.displayMenu = true;
                    MenuLoop.menuType = 0;
                }
            }
        }
    }
}
