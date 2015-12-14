package main;

import menActions.MenActionsControl;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;

public class Men {
    public static Sprite men, menEnemy;
    public static Text lifeText = new Text();
    public static void initiation() {
        men = Different.setSprite("men.png");
        menEnemy = Different.setSprite("menEnemy.png");
        lifeText.setFont(Different.arialFont);
    }
    public static void add(int x, int y, int ownership) {
        State.add(0, x, y, ownership, 100);
    }
    public static void draw(int index) {
        int x = State.getX(index);
        int y = State.getY(index);
        int ownership = State.getOwnership(index);
        boolean selected = Selected.getSelected(index);
        int life = State.getLife(index);
        if (selected) {
            Selected.draw(x - 25 - Cam.x, y + 28 - Cam.y);    //y+72-44
        }
        if (ownership==0) {
            men.setPosition(x - 25 - Cam.x, y - 44 - Cam.y);
            Main.draw(men);
        }
        else {
            menEnemy.setPosition(x - 25 - Cam.x, y - 44 - Cam.y);
            Main.draw(menEnemy);
        }
        if (life<100) {
            lifeText.setString(String.valueOf(life));
            lifeText.setPosition(x-25- Cam.x, y + 28 - Cam.y);
            Main.draw(lifeText);
        }
       /* //test index
        lifeText.setString(String.valueOf(index));
        lifeText.setPosition(x-25- Cam.x, y + 28 - Cam.y);
        Main.draw(lifeText);*/
    }
    public static void leftClick(int i) {
        if (Selected.getSelected(i)) {
            boolean normalGoing = true;
            for (int clickMenAim = 0; clickMenAim < State.getSize(); clickMenAim++) {
                if (Mousee.getX()+Cam.x >= State.getX(clickMenAim)-25 && Mousee.getX()+Cam.x <= State.getX(clickMenAim)+25 && Mousee.getY()+Cam.y >= State.getY(clickMenAim)-44 && Mousee.getY()+Cam.y <= State.getY(clickMenAim)+44) {
                    if (State.getType(clickMenAim) == 0) {
                        if (State.getOwnership(clickMenAim) == 0) {
                        }
                        else {
                            if (State.getX(i) > State.getX(clickMenAim)) {
                                MenActionsControl.assignFightThread(clickMenAim, State.getX(clickMenAim) + 50, State.getY(clickMenAim) + MouseEvents.manySelectedShift, i);
                                MouseEvents.manySelectedShift = -MouseEvents.manySelectedShift;
                            }
                            else {
                                MenActionsControl.assignFightThread(clickMenAim, State.getX(clickMenAim) - 50, State.getY(clickMenAim) + MouseEvents.manySelectedShift, i);
                            }
                        }
                        normalGoing = false;
                    }
                }
            }
            if (normalGoing) {
                MenActionsControl.assignGoingThread(Mousee.getX() + Cam.x, Mousee.getY() + Cam.y + MouseEvents.manySelectedShift, i);
                MouseEvents.manySelectedShift = -MouseEvents.manySelectedShift;
            }
        }
        else if (Mousee.getX() + Cam.x >= State.getX(i) - 25 && Mousee.getX() + Cam.x <= State.getX(i) + 25 && Mousee.getY() + Cam.y >= State.getY(i) - 44 && Mousee.getY() + Cam.y <= State.getY(i) + 44) {
            if (State.getOwnership(i) == 0) {
                if (MouseEvents.mouseSimpleClick) {
                    if (Selected.getSelected(i)) {
                        Selected.setUnselected(i);
                    }
                    else {
                        Selected.setSelected(i);
                    }
                }
            }
        }
    }
}
