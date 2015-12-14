package menActions;

import main.State;

import static main.Different.*;

class MenActions implements Runnable  {
    private int xAim, yAim;
    private double waitRatio;
    private int startX, startY;
    private int indexThread;
    private boolean going = false, attack = false;
    private int xDiff, yDiff;
    private int realLength;
    private int indexMen, indexAimMen;
    private void waitt() {
        int nano = (int)(waitRatio * 3000000);
        int miliPart = nano/1000000;
        int nanoPart = nano%1000000;
        try {
            Thread.sleep(miliPart, nanoPart); // mili 10-3, nano 10-9
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected void activateGoing(int xAim, int yAim, int indexMenToActions, int indexThread) {
        this.xAim = xAim;
        this.yAim = yAim;
        this.indexThread = indexThread;
        startX = State.getX(indexMenToActions);
        startY = State.getY(indexMenToActions);
        indexMen = indexMenToActions;
        going = true;
    }
    protected void activateSpecialGoing(int indexAim, int xAim, int yAim, int indexMenToActions, int indexThread) {
        // goingType = 1 - poruszanie się w wypadku kliknięcia na obiekt (nasz postać podchodzi do obiektu)
        this.xAim = xAim;
        this.yAim = yAim;
        indexThread = indexThread;
        indexAimMen = indexAim;
        startX = State.getX(indexMenToActions);
        startY = State.getY(indexMenToActions);
        indexMen = indexMenToActions;
        going = true;
//        if (goingType==1){
            attack = true;
//        }
    }
    protected void unactivate() {
        going = false;
        attack = false;
        MenActionsControl.clearImputationThreadToMen(indexThread);
    }
    public void changeMenIndexInThread(int newIndexMen) {
        indexMen = newIndexMen;
    }
    private void lewoDol() {
        xDiff = State.getX(indexMen) - xAim;
        yDiff = yAim - State.getY(indexMen);
        int virtualLength = xDiff + yDiff;
        waitRatio = realLength/(double)virtualLength;
        if (xDiff > yDiff) {
            int xJump = safeDivision(xDiff, yDiff);
            double przedział = safeDivisionDouble(xDiff, safeDivisionWithRest(xDiff, yDiff));
            double licznik = 0;
            while (State.getY(indexMen) < yAim) {
                if (przedział*licznik+startX>=(double) State.getX(indexMen)) {
                    for (int i = 0; i <= xJump; i++) {
                        if (going == false) {
                            i = xJump + 1;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.decreaseX(indexMen);
                            waitt();
                        }
                    }
                    licznik--;
                }
                else {
                    for (int i = 0; i < xJump; i++) {
                        if (going == false) {
                            i = xJump;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.decreaseX(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.increaseY(indexMen);
                    waitt();
                }
            }
        }
        else if (xDiff < yDiff) {
            int yJump = safeDivision(yDiff, xDiff);
            double przedział = safeDivisionDouble(yDiff, safeDivisionWithRest(yDiff, xDiff));
            double licznik = 0;
            while (State.getX(indexMen) > xAim) {
                if (przedział*licznik+startY<=(double) State.getY(indexMen)) {
                    for (int i = 0; i <= yJump; i++) {
                        if (going == false) {
                            i = yJump + 1;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.increaseY(indexMen);
                            waitt();
                        }
                    }
                    licznik++;
                }
                else {
                    for (int i = 0; i < yJump; i++) {
                        if (going == false) {
                            i = yJump;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.increaseY(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.decreaseX(indexMen);
                    waitt();
                }
            }
        }
        else {
//            // System.out.println("do doły (y++)");
        }
    }
    private void prawoDol() {
        xDiff = xAim - State.getX(indexMen);
        yDiff = yAim - State.getY(indexMen);
        int virtualLength = xDiff + yDiff;
        waitRatio = realLength/(double)virtualLength;
        if (xDiff > yDiff) {
            int xJump = safeDivision(xDiff, yDiff);
            double przedział = safeDivisionDouble(xDiff, safeDivisionWithRest(xDiff, yDiff));
            double licznik = 0;
            while (State.getY(indexMen) < yAim) {
                if (przedział*licznik+startX<=(double) State.getX(indexMen)) {
                    for (int i = 0; i <= xJump; i++) {
                        if (going == false) {
                            i = xJump + 1;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.increaseX(indexMen);
                            waitt();
                        }
                    }
                    licznik++;
                }
                else {
                    for (int i = 0; i < xJump; i++) {
                        if (going == false) {
                            i = xJump;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.increaseX(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.increaseY(indexMen);
                    waitt();
                }
            }
        }
        else if (xDiff < yDiff) {
            int yJump = safeDivision(yDiff, xDiff);
            double przedział = safeDivisionDouble(yDiff, safeDivisionWithRest(yDiff, xDiff));
            double licznik = 0;
            while (State.getX(indexMen) < xAim) {
                if (przedział*licznik+startY<=(double) State.getY(indexMen)) {
                    for (int i = 0; i <= yJump; i++) {
                        if (going == false) {
                            i = yJump + 1;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.increaseY(indexMen);
                            waitt();
                        }
                    }
                    licznik++;
                }
                else {
                    for (int i = 0; i < yJump; i++) {
                        if (going == false) {
                            i = yJump;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.increaseY(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.increaseX(indexMen);
                    waitt();
                }
            }
        }
    }
    private void lewoGora() {
        xDiff = State.getX(indexMen) - xAim;
        yDiff = State.getY(indexMen) - yAim;
        int virtualLength = xDiff + yDiff;
        waitRatio = realLength/(double)virtualLength;
        if (xDiff > yDiff) {
            int xJump = safeDivision(xDiff, yDiff);
            double przedział = safeDivisionDouble(xDiff, safeDivisionWithRest(xDiff, yDiff));
            double licznik = 0;
            while (State.getY(indexMen) > yAim) {
                if (przedział*licznik+startX>=(double) State.getX(indexMen)) {
                    for (int i = 0; i <= xJump; i++) {
                        if (going == false) {
                            i = xJump + 1;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.decreaseX(indexMen);
                            waitt();
                        }
                    }
                    licznik--;
                }
                else {
                    for (int i = 0; i < xJump; i++) {
                        if (going == false) {
                            i = xJump;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.decreaseX(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.decreaseY(indexMen);
                    waitt();
                }
            }
        }
        else if (xDiff < yDiff) {
            int yJump = safeDivision(yDiff, xDiff);
            double przedział = safeDivisionDouble(yDiff, safeDivisionWithRest(yDiff, xDiff));
            double licznik = 0;
            while (State.getX(indexMen) > xAim) {
                if (przedział*licznik+startY>=(double) State.getY(indexMen)) {
                    for (int i = 0; i <= yJump; i++) {
                        if (going == false) {
                            i = yJump + 1;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.decreaseY(indexMen);
                            waitt();
                        }
                    }
                    licznik--;
                }
                else {
                    for (int i = 0; i < yJump; i++) {
                        if (going == false) {
                            i = yJump;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.decreaseY(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.decreaseX(indexMen);
                    waitt();
                }
            }
        }
        else {
//            // System.out.println("do doły (y++)");
        }
    }
    private void prawoGora() {
        xDiff = xAim - State.getX(indexMen);
        yDiff = State.getY(indexMen) - yAim;
        int virtualLength = xDiff + yDiff;
        waitRatio = realLength/(double)virtualLength;
        if (xDiff > yDiff) {
            int xJump = safeDivision(xDiff, yDiff);
            double przedział = safeDivisionDouble(xDiff, safeDivisionWithRest(xDiff, yDiff));
            double licznik = 0;
            while (State.getY(indexMen) > yAim) {
                if (przedział*licznik+startX<=(double) State.getX(indexMen)) {
                    for (int i = 0; i <= xJump; i++) {
                        if (going == false) {
                            i = xJump + 1;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.increaseX(indexMen);
                            waitt();
                        }
                    }
                    licznik++;
                }
                else {
                    for (int i = 0; i < xJump; i++) {
                        if (going == false) {
                            i = xJump;
                            yAim = State.getY(indexMen);
                        }
                        else {
                            State.increaseX(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.decreaseY(indexMen);
                    waitt();
                }
            }
        }
        else if (xDiff < yDiff) {
            int yJump = safeDivision(yDiff, xDiff);
            double przedział = safeDivisionDouble(yDiff, safeDivisionWithRest(yDiff, xDiff));
            double licznik = 0;
            while (State.getX(indexMen) < xAim) {
                if (przedział*licznik+startY>=(double) State.getY(indexMen)) {
                    for (int i = 0; i <= yJump; i++) {
                        if (going == false) {
                            i = yJump;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.decreaseY(indexMen);
                            waitt();
                        }
                    }
                    licznik--;
                }
                else {
                    for (int i = 0; i < yJump; i++) {
                        if (going == false) {
                            i = yJump;
                            xAim = State.getX(indexMen);
                        }
                        else {
                            State.decreaseY(indexMen);
                            waitt();
                        }
                    }
                }
                if (going) {
                    State.increaseX(indexMen);
                    waitt();
                }
            }
        }
    }
    private void attack() {

    }
    public void run() {
        if (going) {
            realLength = (int) Math.sqrt(Math.pow(xAim - startX, 2) + Math.pow(yAim - startY, 2));
            if (yAim < State.getY(indexMen)) {
                if (xAim < State.getX(indexMen)) {
                    lewoGora();
                }
                else if (xAim > State.getX(indexMen)) {
                    prawoGora();
                }
                else {
                    waitRatio = 1;
                    while (yAim < State.getY(indexMen)) {
                        State.decreaseY(indexMen);
                        waitt();
                        if (going == false) {
                            yAim = State.getY(indexMen);
                        }
                    }
                }
            }
            else if (yAim > State.getY(indexMen)) {
                if (xAim < State.getX(indexMen)) {
                    lewoDol();
                }
                else if (xAim > State.getX(indexMen)) {
                    prawoDol();
                }
                else {
                    waitRatio = 1;
                    while (yAim > State.getY(indexMen)) {
                        State.increaseY(indexMen);
                        waitt();
                        if (going == false) {
                            yAim = State.getY(indexMen);
                        }
                    }
                    // System.out.println("dół");
                }
            }
            else {
                if (xAim < State.getX(indexMen)) {
                    waitRatio = 1;
                    do {
                        State.decreaseX(indexMen);
                        waitt();
                        if (going == false) {
                            xAim = State.getX(indexMen);
                        }
                    } while (xAim < State.getX(indexMen));
                }
                else {
                    waitRatio = 1;
                    do {
                        State.increaseX(indexMen);
                        waitt();
                        if (going == false) {
                            xAim = State.getX(indexMen);
                        }
                    } while (xAim > State.getX(indexMen));
                }
            }
            going = false;
            waitRatio = 6;
            while (attack) {
                System.out.println("my: " + State.getLife(indexMen));
                System.out.println("wróg: " + State.getLife(indexAimMen));
                if (State.getLife(indexMen) <= 0) {
                    State.remove(indexMen);
                    attack = false;
                    break;
                }
                else {
                    State.decreaseLife(indexAimMen);
                    waitt();
                }
                if (State.getLife(indexAimMen) <= 0) {
                    State.remove(indexAimMen);
                    attack = false;
                    break;
                }
                else {
                    State.decreaseLife(indexMen);
                    waitt();
                }
//                else {
//                    State.decreaseLife(indexAimMen);
//                    waitt();
//                    if (State.getLife(indexMen) == 0) {
//                        if (State.getLife(indexAimMen) == 0) {
//                            State.remove(indexMen);
//                        }
//                        break;
//                    }
//                    else {
//                        State.decreaseLife(indexMen);
//                    }
//                    waitt();
//                }
            }
            MenActionsControl.clearImputationThreadToMen(indexThread);
        }
    }
}
