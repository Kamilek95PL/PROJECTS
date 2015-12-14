package gameModel.State;

/**
 * 02.11.15.
 */
public class StateCreature extends StateGlobal {
    private static int widthHalfSize=100, heightHalfSize=40;
    private static int[][] stateCreature = new int[100][4];
    public static int getCreatureType(int index) {
        return stateCreature[index][0];
    }
    public static int getLife(int index) {
        return stateCreature[index][1];
    }
    public static int getAttack(int index) {
        return stateCreature[index][2];
    }
    public static int getOwnership(int index) {
        return stateCreature[index][3];
    }
    private static void setStateCreature(int life, int ownership) {
        stateCreature[StateGlobal.stateSize][0] = 0;        // type
        stateCreature[StateGlobal.stateSize][1] = life;
        stateCreature[StateGlobal.stateSize][2] = 1;        // attack
        stateCreature[StateGlobal.stateSize][3] = ownership;
    }
    public static void add(int x, int y) {
        StateGlobal.setGlobalState(0, x, y);
        setStateCreature(100, 0);
    }
    public static void increaseLife(int index) {
        stateCreature[index][1]++;
    }
    public static void decreaseLife(int index) {
        stateCreature[index][1]--;
    }
    public static boolean checkMouseIn(int index, int mouseX, int mouseY) {
        if (mouseX<(getX(index)+widthHalfSize) && mouseX>(getX(index)-widthHalfSize) && mouseY<(getY(index)+heightHalfSize) && mouseY>(getY(index)-heightHalfSize)) {
            return true;
        }
        else {
            return false;
        }
    }
    protected static void setAll() {

    }
}
