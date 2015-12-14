package gameModel;

import gameModel.State.Save;

/**
 * 02.11.15.
 */
public class MainLoop {
    public static void main(String[] args) {
        boolean menu = true;
        while (true) {
            while (menu) {
                // click load button
                Save.loadSave();
            }
            while (menu == false) {
                Mouse.update();
                Mouse.mouseClickCheck();
            }
        }
    }
}
