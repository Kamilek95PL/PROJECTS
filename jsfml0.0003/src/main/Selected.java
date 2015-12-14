package main;

import org.jsfml.graphics.Sprite;

import java.util.HashMap;

public class Selected {
    public static int actualSelected = 0;
    private static Sprite selected;
    private static HashMap<Integer, Boolean> selectedState = new HashMap();
    public static void initiation() {
        selected = Different.setSprite("selected.png");
    }
    public static void setSelected(int index) {
        selectedState.put(index, true);
        actualSelected++;
    }
    public static void setUnselected(int index) {
        selectedState.remove(index);
        actualSelected--;
    }
    public static void clearAll() {
        selectedState.clear();
    }
    public static boolean getSelected(int index) {
        try {
            return selectedState.get(index);
        }
        catch (NullPointerException e)  {  return false;   }
    }
    public static void draw(int X, int Y) {
        selected.setPosition(X, Y);
        Main.draw(selected);
    }
}
