package gameModel;

import gameModel.State.StateCreature;

/**
 * 02.11.15.
 */
public class Creature {
    public static void going(int xAim, int yAim) {

    }
    public static void going(int xAim, int yAim, int indexAim) {
        // attack
        StateCreature.decreaseLife(indexAim);
    }
}
