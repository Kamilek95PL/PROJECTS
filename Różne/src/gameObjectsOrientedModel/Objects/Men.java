package gameObjectsOrientedModel.Objects;

import gameObjectsOrientedModel.State;

/**
 * 11.11.15.
 */
public class Men extends Creature{
    private static int widthHalfSize=100, heightHalfSize=40;
    public Men(int x, int y, int owership) {
        super(x, y, owership);
    }
    @Override
    public boolean checkMouseIn(int index, int mouseX, int mouseY) {
        if (mouseX<(getX()+widthHalfSize) && mouseX>(getX()-widthHalfSize) && mouseY<(getY()+heightHalfSize) && mouseY>(getY()-heightHalfSize)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void going(int xAim, int yAim) {

    }
    public static void goingAndAtack(int xAim, int yAim, int indexAim) {
        // attack
        State.men(indexAim).decreaseLife();
    }


}
