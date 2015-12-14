package main;

public class GameLoop {
    public static void mainLoop() {
        while (MenuLoop.displayMenu == false) { //window.isOpen()
            Background.draw();
            for (int j = 0; j< State.getSize(); j++) {
                switch (State.getType(j)) {
                    case 0:
                        Men.draw(j);
                        break;
                    case 1:
                        Hut.draw(State.getOwnership(j), State.getX(j), State.getY(j), Selected.getSelected(j));
                        break;
                    default:
                        System.out.println("unknown type to draw: " + State.getType(j));
                }
            }
            KeyboardEvents.check();
            Mousee.updateXandY();
            MouseEvents.check();
            Cam.analysisMoveCam();
            Different.drawInfo();
            Main.window.display();
        }
    }
}
