package menActions;

/**
 * 28.10.15.
 */
public class MenActionsControl {
    static MenActions[] menActionsRunnable = new MenActions[4];
    static Thread[] menActionsThread = new Thread[4];
    static int[] imputationThreadToMen = new int[4];
    public static void initiation() {
        for (int i=0; i<4; i++) {
            menActionsRunnable[i] = new MenActions();
            menActionsThread[i] = new Thread(menActionsRunnable[i]);
            menActionsThread[i].start();
            imputationThreadToMen[i] = -1;
        }
    }
    public static void assignGoingThread(int xA, int yA, int indexMenToActions) {
//        int s = 0;
//        for (int j=0; j<4; j++) {
//            if (imputationThreadToMen[j] == indexMenToActions) {
//                s = 4;
//                menActionsRunnable[j].unactivate();
//                while (menActionsThread[j].isAlive()) {
//
//                }
//                menActionsRunnable[j].activateGoing(xA, yA, indexMenToActions, j);
//                menActionsThread[j] = new Thread(menActionsRunnable[j]);
//                menActionsThread[j].start();
//                Different.setInfo("ten sam: " + j);
//                break;
//            }
//        }
////        Different.setInfo("s: " + s);
//        for (int i=s; i<4; i++) {
//            if (menGoing(i) == false) {
//                imputationThreadToMen[i] = indexMenToActions;
//                menActionsRunnable[i].activateGoing(xA, yA, indexMenToActions, i);
//                menActionsThread[i] = new Thread(menActionsRunnable[i]);
//                menActionsThread[i].start();
//                Different.setInfo("inny: " + i);
//                break;
//            }
//        }
        menActionsRunnable[indexMenToActions].unactivate();
        while (menActionsThread[indexMenToActions].isAlive()) {

        }
        menActionsRunnable[indexMenToActions].activateGoing(xA, yA, indexMenToActions, indexMenToActions);
        menActionsThread[indexMenToActions] = new Thread(menActionsRunnable[indexMenToActions]);
        menActionsThread[indexMenToActions].start();
    }
    public static void assignFightThread(int indexAim, int xA, int yA, int indexMenToActions) {
//        for (int i=0; i<4; i++) {
//            if (menGoing(i) == false) {
//                imputationThreadToMen[i] = indexMenToActions;
//                menActionsRunnable[i].activateSpecialGoing(indexAim, xA, yA, indexMenToActions, i);
//                menActionsThread[i] = new Thread(menActionsRunnable[i]);
//                menActionsThread[i].start();
//                break;
//            }
//        }
        menActionsRunnable[indexMenToActions].unactivate();
        while (menActionsThread[indexMenToActions].isAlive()) {

        }
        menActionsRunnable[indexMenToActions].activateSpecialGoing(indexAim, xA, yA, indexMenToActions, indexMenToActions);
        menActionsThread[indexMenToActions] = new Thread(menActionsRunnable[indexMenToActions]);
        menActionsThread[indexMenToActions].start();
    }
    public static void clearImputationThreadToMen(int indexThread) {
        imputationThreadToMen[indexThread] = -1;
    }
    public static void changeMenIndexInThread(int actualIndexMen, boolean increase) {
        for (int i=0; i<4; i++) {
//            if (imputationThreadToMen[i] == actualIndexMen) {
//                if (increase) {
//                    menActionsRunnable[i].changeMenIndexInThread(actualIndexMen + 1);
//                    imputationThreadToMen[i]++;
//                }
//                else {
//                    menActionsRunnable[i].changeMenIndexInThread(actualIndexMen - 1);
//                    imputationThreadToMen[i]--;
//                }
//            }
                if (increase) {
                    menActionsRunnable[actualIndexMen].changeMenIndexInThread(actualIndexMen + 1);
                    imputationThreadToMen[actualIndexMen]++;
                }
                else {
                    menActionsRunnable[actualIndexMen].changeMenIndexInThread(actualIndexMen - 1);
                    imputationThreadToMen[actualIndexMen]--;
                }
            }
//        }
    }
    public static void stopGoingThread(int indexMenToActions) {
        menActionsRunnable[indexMenToActions].unactivate();
    }
    public static void stopAllThread() {
        for (int i=0; i<4; i++) {
            if (menGoing(i)) {
                menActionsRunnable[i].unactivate();
            }
        }
    }
    public static boolean menGoing(int indexMenToActions) {
        return menActionsThread[indexMenToActions].isAlive();
    }
}

