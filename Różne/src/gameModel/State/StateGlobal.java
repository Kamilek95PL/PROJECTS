package gameModel.State;

/**
 * 02.11.15.
 */
public class StateGlobal {
    private static int[][] stateGlobal = new int[100][3];
    protected static int stateSize = 0;
    public static void initiation() {
        for (int[] i : stateGlobal) {
            i[0] = -1;
        }
    }
    public static int getStateSize() {
        return stateSize;
    }
    public static int getType(int index) {
        return stateGlobal[index][0];
    }
    public static int getX(int index) {
        return stateGlobal[index][1];
    }
    public static int getY(int index) {
        return stateGlobal[index][2];
    }
    public static void increaseX(int index) {
        stateGlobal[index][1]++;
    }
    public static void decreaseX(int index) {
        stateGlobal[index][1]--;
    }
    public static void increaseY(int index) {
        stateGlobal[index][2]++;
    }
    public static void decreaseY(int index) {
        stateGlobal[index][2]--;
    }
    protected static void setGlobalState(int type, int x, int y) {
        int[] temp = {type, x, y};
        stateGlobal[stateSize] = temp;
    }
}
