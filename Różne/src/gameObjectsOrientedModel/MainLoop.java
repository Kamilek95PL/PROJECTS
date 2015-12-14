//package gameObjectsOrientedModel;
//
//
///**
// * 02.11.15.
// */
//
//import gameObjectsOrientedModel.Objects.Men;
//
//import static gameObjectsOrientedModel.State.addObject;
//
//public class MainLoop {
//    boolean menu = true;
//    public static MouseEvents mouse = new MouseEvents();
//    public void mainLoop() {
//        addObject(new Men(100, 120, 0));
//        addObject(new Men(560, 70, 0));
//        while (true) {
//            while (menu) {
//                // click load button
////                Save.loadSave();
//            }
//            while (menu == false) {
//                mouse.update();
//                mouse.mouseClickCheck();
//            }
//        }
//    }
//    public static void main(String[] args) {
//        new MainLoop().mainLoop();
//    }
//}
