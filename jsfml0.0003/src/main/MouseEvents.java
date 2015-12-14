package main;

/**
 * 29.10.15.
 */
public class MouseEvents {
    public static boolean mouseSimpleClick = true;
    public static int manySelectedShift;
    private static void leftClick() {
        if (Selected.actualSelected == 2) {
            manySelectedShift = -44;
        }
        else {
            manySelectedShift = 0;
        }
        for (int i=0; i< State.getSize(); i++) {
            switch (State.getType(i)) {
                case 0:
                    Men.leftClick(i);
                    break;
                case 1:
                    Hut.leftClick(i);
                    break;
                default:
                    System.out.println("unknown type to click analysis: " + State.getType(i));
            }
        }
    }
    private static void rightClick() {
        for (int i=0; i<State.getSize(); i++) {
            if (Selected.getSelected(i)) {
                Selected.setUnselected(i);
            }
        }
    }
    public static void check() {
        if (Mousee.leftClick()) {
            leftClick();
            mouseSimpleClick = false;
        }
        else if (Mousee.rightClick()) {
            rightClick();
            mouseSimpleClick = false;
        }
        else {
            mouseSimpleClick = true;
        }
    }
}
