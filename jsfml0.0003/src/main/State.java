package main;

import menActions.MenActionsControl;

import java.util.ArrayList;

/**
 * 14.10.15.
 */
public class State {
    public static ArrayList<int[]> state = new ArrayList();
    public static boolean positionUpdate = false;
    public static int getType (int index) {
        return state.get(index)[0];
    }
    public static int getX (int index) {
        return state.get(index)[1];
    }
    public static int getY (int index) {
        return state.get(index)[2];
    }
    public static int getOwnership (int index) {
        return state.get(index)[3];
    }
    public static int getLife (int index) {
        return state.get(index)[4];
    }
    public static int getSize() {
        return state.size();
    }
    public static void add(int type, int x, int y, int ownership, int life)
    {
        int tab[] = {type, x, y, ownership , life};
        boolean changeOrder = false;
        int size = state.size();
        for (int i=0; i<size; i++) {
            if (tab[2]<getY(i)) {
                state.add(i, tab);
                changeOrder = true;
                break;
            }
        }
        if (changeOrder == false) {
            state.add(tab);
        }
    }
    public static void remove(int index) {
        state.remove(index);
    }
    public static void clearAll() {
        while (state.size()>0) {
            state.remove(0);
        }
    }
    public static void changePositionUpdate() {
        if (positionUpdate) {
            positionUpdate = false;
        }
        else {
            positionUpdate = true;
        }
    }
    public static boolean getPositionUpdate() {
        return positionUpdate;
    }
    public static void generateStart(int saveID) {
        if (saveID == -1) {       // new Game
            Men.add(300, 300, 1);
            Men.add(500, 500, 0);
            Men.add(900, 830, 0);
            Men.add(100, 400, 0);
        }
        else {
//            int size = main.Save.getSizeSaves();
//            for (int i=0; i<size; i++) {
//                state.add(main.Save.save.get(saveID).get(i).clone());
//            }
            state = Save.load(saveID);
        }
    }
    public static void increaseX(int index) {
        state.get(index)[1]++;
    }
    public static void increaseY(int index) {
        state.get(index)[2]++;
        if (positionUpdate) {
            checkChangePositionIncrease(index);
        }
    }
    public static void decreaseX(int index) {
        state.get(index)[1]--;
    }
    public static void decreaseY(int index) {
        state.get(index)[2]--;
        if (positionUpdate) {
            checkChangePositionDecrease(index);
        }
    }
    private static void checkChangePositionIncrease(int index) {
        if (index < state.size()-1) {
            if (state.get(index)[2] > state.get(index + 1)[2]) {
                int[] temporary = state.get(index);
                state.set(index, state.get(index + 1));
                state.set(index + 1, temporary);
                MenActionsControl.changeMenIndexInThread(index, true);
//                Main.menActionsRunnable[index+1] = Main.menActionsRunnable[index];
//                Main.menActionsRunnable[index] = new MenActions();
//                Main.menActionsThread[index+1] = Main.menActionsThread[index];
//                Main.menActionsThread[index] = new Thread(Main.menActionsRunnable[index]);
                if (Selected.getSelected(index)) {
                    Selected.setUnselected(index);
                    index++;
                    Selected.setSelected(index);
                }
                else {
                    index++;
                }
//                for (int i=0; i<4; i++) {
//                    Main.menActionsRunnable[i].index++;
//                }
                checkChangePositionIncrease(index);
            }
        }
    }
    private static void checkChangePositionDecrease(int index) {
        if (index >= 1) {
            if (state.get(index)[2] < state.get(index - 1)[2]) {
                int[] temporary = state.get(index);
                state.set(index, state.get(index - 1));
                state.set(index - 1, temporary);
                MenActionsControl.changeMenIndexInThread(index, false);
//                Main.menActionsRunnable[index-1] = Main.menActionsRunnable[index];
//                Main.menActionsRunnable[index] = new MenActions();
//                Main.menActionsThread[index-1] = Main.menActionsThread[index];
//                Main.menActionsThread[index] = new Thread(Main.menActionsRunnable[index]);
                if (Selected.getSelected(index)) {
                    Selected.setUnselected(index);
                    index--;
                    Selected.setSelected(index);
                }
                else {
                    index--;
                }
//                Main.menActionsRunnable[0].index--;
//                Main.menActionsRunnable[1].index--;
                checkChangePositionDecrease(index);
            }
        }
    }
    public static void increaseLife(int index) {
        state.get(index)[4]++;
    }
    public static void decreaseLife(int index) {
        state.get(index)[4]--;
    }
//    public static void checkChangePositionIncrease(int index, int type, int x, int y)
//    {
//        state.set(index, new int[]{type, x, y});
//    }
//    public static void remove(int i, int j, int k) {
//        System.out.println("usuwam: " + i + " " + j);
//        try {   state.get(i).get(j).remove(k);   }
//        catch (NullPointerException e) 		{   System.out.println("BŁĄD");     }
//    }
//    public static void main(String[] args) {
//        GlobalState.add(0, 100, 101);
//        System.out.println(GlobalState.getType(0));
//        System.out.println(GlobalState.getX(0));
//        System.out.println(GlobalState.getTab(0));
//    }
}
