package main;

import org.jsfml.graphics.Sprite;

public class Hut {
    public static Sprite hut;
    public static void initiation() {
        hut = Different.setSprite("hut.png");
    }
    public static void add(int x, int y, int ownership) {
        State.add(1, x, y, ownership, 100);
    }
    public static void draw(int ownership, int x, int y, boolean selected) {
//        if (ownership==0) {
            hut.setPosition(x - 150 - Cam.x, y - 107 - Cam.y);
            Main.draw(hut);
//        }
    }
    public static void leftClick(int i) {    }
}
