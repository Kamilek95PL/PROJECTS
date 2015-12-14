package gameModel.State;

/**
 * 02.11.15.
 */
public class StateBuildings extends StateGlobal {
    private static int width=300, height=500;
    private static int[][] stateBuildings = new int[100][3];
    public static int getBuildingType(int index) {
        return stateBuildings[index][0];
    }
    public static int getLife(int index) {
        return stateBuildings[index][1];
    }
    public static int getCapacity(int index) {
        return stateBuildings[index][2];
    }
    private static void setStateBuildings(int type, int life, int capacity) {
        stateBuildings[StateGlobal.stateSize][0] = type;
        stateBuildings[StateGlobal.stateSize][1] = life;
        stateBuildings[StateGlobal.stateSize][2] = capacity;
    }
    public static void add(int x, int y, int type) {
        StateGlobal.setGlobalState(1, x, y);
        setStateBuildings(type, 100, 8);
    }
    public static void increaseLife(int index) {
        stateBuildings[index][1]++;
    }
    public static void decreaseLife(int index) {
        stateBuildings[index][1]--;
    }
    public static boolean checkMouseIn(int index, int mouseX, int mouseY) {
        if (mouseX<(getX(index)+width) && mouseX>(getX(index)-width) && mouseY<(getY(index)+height) && mouseY>(getY(index)-height)) {
            return true;
        }
        else {
            return false;
        }
    }
    protected static void setAll() {

    }
}
