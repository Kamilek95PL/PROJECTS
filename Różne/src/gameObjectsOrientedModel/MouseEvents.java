//package gameObjectsOrientedModel;
//
//import gameObjectsOrientedModel.Objects.Creature;
//import gameObjectsOrientedModel.Objects.Men;
//
//
//import static gameObjectsOrientedModel.State.*;
//
///**
// * 11.11.15.
// */
//public class MouseEvents {
//    private int indexSelectedObject = -1;
//    public int checkMouseInObject() {
//        int mouseInObject = -1;
//        for (int i=0; i<size(); i++) {
//            Object object = object(i);
//            switch (object.getType()) {
//                case 0:
//                    if (object.checkMouseIn(i, Mouse.x(), Mouse.y())) {
//                        mouseInObject = i;
//                    }
//                    break;
//                case 1:
//                    if (object.checkMouseIn(i, gameModel.Mouse.x(), gameModel.Mouse.y())) {
//                        mouseInObject = i;
//                    }
//                    break;
//            }
//            if (mouseInObject != -1) {
//                break;
//            }
//        }
//        return mouseInObject;
//    }
//    private void mouseLeftSelectedClick() {
//        int indexMouseObject = checkMouseInObject();
//        if (indexMouseObject != -1) {              // click in object
//            if (object(indexSelectedObject).getType() == 0 && object(indexMouseObject).getType() == 0 && men(indexMouseObject).getOwnership()!=0) {     // enemy men - going and attack
//                Creature.goingAndAtack(gameModel.Mouse.x(), gameModel.Mouse.y(), indexMouseObject);
//            }
//            if (object(indexSelectedObject).getType() == 0 && object(indexMouseObject).getType() == 0 && men(indexMouseObject).getOwnership()==0) {     // our men  - change select
//                indexSelectedObject = indexMouseObject;
//            }
//        }
//        else {                                  // click in empty area - going
//            switch (object(indexSelectedObject).getType()) {
//                case 0:
//                    Creature.going(gameModel.Mouse.x(), gameModel.Mouse.y());
//            }
//        }
//    }
//    private void mouseLeftUnselectedClick() {
//        int indexMouseObject = checkMouseInObject();
//        if (indexMouseObject != -1) {              // click in object - set select
//            indexSelectedObject = indexMouseObject;
//        }
//        else {                                  // click in empty area - nothing
//
//        }
//    }
//    public void update() {
//
//    }
//    public void mouseClickCheck() {
//        boolean mouseLeftClick = true;
//        if (mouseLeftClick) {
//            if (indexSelectedObject == -1) {
//                mouseLeftSelectedClick();
//            }
//            else {
//                mouseLeftUnselectedClick();
//            }
//        }
//    }
//}
