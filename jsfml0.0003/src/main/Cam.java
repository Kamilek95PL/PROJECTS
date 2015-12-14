package main;

/**
 * 29.10.15.
 */
public class Cam {
    public static short speedMoveCam = 5;
    private static int moveMapSize = 100;
    private static int xLimitLine, yLimitLine;
    public static int x = 0, y = 0;
    public static void initiation() {
        xLimitLine = Main.resolutionX - moveMapSize;
        yLimitLine = Main.resolutionY - moveMapSize;
    }
    public static void analysisMoveCam() {
// tym zakomentowanym sposobem moglibyśmy określić inną prędkość przesuwania mapy w wypadku najechania na róg mapy czyli wywołanie przesunięcia w dwóch wymiarach
//        if (mouseX <= 30 && mouseY <= 30) {
//            x-= speedMoveMapCorner;
//            main.Background.decreaseShiftX();
//            y-= speedMoveMapCorner;
//            main.Background.decreaseShiftY();
//        }
//        else if (mouseX <= 30 && mouseY >= yLimitLine) {
//            x-= speedMoveMapCorner;
//            main.Background.decreaseShiftX();
//            y += speedMoveMapCorner;
//            main.Background.increaseShiftY();
//        }
//        else if (mouseX >= xLimitLine && mouseY <= 30) {
//            y-= speedMoveMapCorner;
//            main.Background.decreaseShiftY();
//            x+= speedMoveMapCorner;
//            main.Background.increaseShiftX();
//        }
//        else if (mouseX >= xLimitLine && mouseY >= yLimitLine) {
//            x+= speedMoveMapCorner;
//            main.Background.increaseShiftX();
//            y+= speedMoveMapCorner;
//            main.Background.increaseShiftY();
//        }
//        else if (mouseX <= 30) {           //////////////////////////////////////////////////////////////////////////////////////////////////////////////// 1
//            x-= speedMoveCam;
//            main.Background.decreaseShiftX();
//        }
//        else if (mouseX >= xLimitLine) {
//            x+= speedMoveCam;
//            main.Background.increaseShiftX();
//        }
//        else if (mouseY <= 30) {
//            y-= speedMoveCam;
//            main.Background.decreaseShiftY();
//        }
//        else if (mouseY >= yLimitLine) {
//            y+= speedMoveCam;
//            main.Background.increaseShiftY();
//        }
        if (Mousee.getY() <= moveMapSize) {
            y -= speedMoveCam;
            Background.decreaseShiftY();
        }
        else if (Mousee.getY() >= yLimitLine) {
            y += speedMoveCam;
            Background.increaseShiftY();
        }
        if (Mousee.getX() <= moveMapSize) {
            x -= speedMoveCam;
            Background.decreaseShiftX();
        }
        else if (Mousee.getX() >= xLimitLine) {
            x += speedMoveCam;
            Background.increaseShiftX();
        }
    }
    public static void setCam(int camX, int camY) {
        x = camX;
        y = camY;
        Background.defaultShift();
    }
}
