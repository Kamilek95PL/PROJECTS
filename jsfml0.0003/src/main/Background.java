package main;

import org.jsfml.graphics.Sprite;

public class Background {
    private static Sprite grass;
    private static short shiftX = 128, shiftY=128;
    private static int blockToDrawX, blockToDrawY;
    public static void defaultShift() {
        shiftX = 128;
        shiftY = 128;
    }
    public static void initiation() {
        grass = Different.setSprite("grass.png");
        blockToDrawX = Main.resolutionX/256 + 2;
        blockToDrawY = Main.resolutionY/256 + 2;
    }
    public static void increaseShiftX() {
        shiftX+= Cam.speedMoveCam;
        if (shiftX>=256) {
            shiftX -= 256;
        }
    }
    public static void decreaseShiftX() {
        shiftX-= Cam.speedMoveCam;
        if (shiftX<=0) {
            shiftX += 256;
        }
    }
    public static void increaseShiftY() {
        shiftY+= Cam.speedMoveCam;
        if (shiftY>=256) {
            shiftY -= 256;
        }
    }
    public static void decreaseShiftY() {
        shiftY-= Cam.speedMoveCam;
        if (shiftY<=0) {
            shiftY += 256;
        }
    }
    public static void draw() {
        for (int i=0; i<blockToDrawX; i++) {
            for (int j=0; j<blockToDrawY; j++) {
                grass.setPosition(i*256-shiftX, j*256-shiftY);
                Main.draw(grass);
            }
        }
    }
}
