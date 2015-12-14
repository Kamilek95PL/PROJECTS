package gameModel;

import gameModel.State.StateBuildings;
import gameModel.State.StateCreature;
import gameModel.State.StateGlobal;

/**
 * 02.11.15.
 */
public class Mouse {
    private static int mouseX, mouseY;
    private static int indexSelectedObject = -1;
    public static int x() {
        return mouseX;
    }
    public static int y() {
        return mouseY;
    }
    private static int checkMouseInObject() {
        int mouseInObject = -1;
        for (int i = 0; i < StateGlobal.getStateSize(); i++) {
            switch (StateGlobal.getType(i)) {
                case 0:
                    if (StateCreature.checkMouseIn(i, Mouse.x(), Mouse.y())) {
                        mouseInObject = i;
                    }
                    break;
                case 1:
                    if (StateBuildings.checkMouseIn(i, Mouse.x(), Mouse.y())) {
                        mouseInObject = i;
                    }
                    break;
            }
            if (mouseInObject != -1) {
                break;
            }
        }
        return mouseInObject;
    }
    private static void mouseLeftSelectedClick() {
        int indexMouseObject = checkMouseInObject();
        if (indexMouseObject != -1) {              // click in object
            if (StateGlobal.getType(indexSelectedObject) == 0 && StateGlobal.getType(indexMouseObject) == 0 && StateCreature.getOwnership(indexMouseObject)!=0) {
                Creature.going(Mouse.x(), Mouse.y(), indexMouseObject);
            }
            else {
                indexSelectedObject = indexMouseObject;
            }
        }
        else {                                  // click in empty area
            switch (StateGlobal.getType(indexSelectedObject)) {
                case 0:
                    Creature.going(Mouse.x(), Mouse.y());
            }
        }
    }
    private static void mouseLeftUnselectedClick() {
        int indexMouseObject = checkMouseInObject();
        if (indexMouseObject != -1) {              // click in object
             indexSelectedObject = indexMouseObject;
        }
        else {                                  // click in empty area

        }
    }
    public static void update() {

    }
    public static void mouseClickCheck() {
        boolean mouseLeftClick = true;
        if (mouseLeftClick) {
            if (indexSelectedObject == -1) {
                mouseLeftSelectedClick();
            }
            else {
                mouseLeftUnselectedClick();
            }
        }
    }
}
