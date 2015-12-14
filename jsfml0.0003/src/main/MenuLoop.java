package main;

import menActions.MenActionsControl;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

/**
 * 24.10.15.
 */
public class MenuLoop {
    static Sprite menuBackground, button, buttonFlash, delete, on, off;
    static boolean displayMenu = true, isActiveGame = false, simpleClick = true;
    static int menuType = 0;
    public static Text textButton[] = new Text[14];
    static int j=1, yShiftStart = -200;
    static boolean[] flashButton = new boolean[6];
    private static void mainMenuEvents(int mouseX, int mouseY, int yShiftTemp) {
        for (int i=j; i<6; i++) {
            if (mouseX >= Main.resolutionX / 2 - 100 && mouseX <= Main.resolutionX / 2 + 100 && mouseY >= Main.resolutionY / 2 - 33 + yShiftTemp && mouseY <= Main.resolutionY / 2 + 33 + yShiftTemp) {
                flashButton[i] = true;
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    if (simpleClick) {
                        if (i == 0) {     // continue
                            if (isActiveGame) {
                                displayMenu = false;
                            }
                        }
                        if (i == 1) {     // new Game
                            State.clearAll();
                            MenActionsControl.stopAllThread();
                            Selected.clearAll();
                            Cam.setCam(0, 0);
                            State.generateStart(-1);
                            displayMenu = false;
                            isActiveGame = true;
                            yShiftStart = -250;
                            j = 0;
                        }
                        else if (i == 2) {    // load Game
                            menuType = 1;
                        }
                        else if (i == 3) {    // save Game
                            if (isActiveGame) {
                                Save.save(State.state);
                            }
                            else {
                                Different.setInfo("NIC DO ZAPISU");
                            }
                        }
                        else if (i == 4) {
                            menuType = 2;
                        }
                        else if (i == 5) {    // exit Game
                            Main.window.close();
                            System.exit(0);
                        }
                        simpleClick = false;
                    }
                }
                else {
                    simpleClick = true;
                }
            }
            else {
                flashButton[i] = false;
            }
            yShiftTemp += 100;
        }
    }
    private static void saveMenuEvents(int mouseX, int mouseY, int yShiftTemp) {
        for (int i=0; i<6; i++) {
            if (mouseX >= Main.resolutionX / 2 - 100 && mouseX <= Main.resolutionX / 2 + 100 && mouseY >= Main.resolutionY / 2 - 33 + yShiftTemp && mouseY <= Main.resolutionY / 2 + 33 + yShiftTemp) {
                flashButton[i] = true;
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    if (simpleClick) {
                        if (i < 5) {
                            if (i < Save.getSizeSaves()) {
                                State.clearAll();
                                Selected.clearAll();
                                Cam.setCam(0, 0);
                                MenActionsControl.stopAllThread();
                                State.generateStart(i);
                                displayMenu = false;
                                isActiveGame = true;
                                yShiftStart = -250;
                                j = 0;
                            }
                            else {
                                Different.setInfo("TEN SLOT JEST PUSTY");
                            }
                        }
                        else if (i == 5) {
                            menuType = 0;
                        }
                        simpleClick = false;
                    }
                }
                else {
                    simpleClick = true;
                }
            }
            else if (mouseX >= Main.resolutionX / 2 - 100+210 && mouseX <= Main.resolutionX / 2 + 100+210+40 && mouseY >= Main.resolutionY / 2 - 33 + yShiftTemp+8 && mouseY <= Main.resolutionY / 2 + 33 + yShiftTemp + 8+40) {
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    if (simpleClick) {
                        if (i < 5) {
                            Save.delete(i);
                        }
                        simpleClick = false;
                    }
                }
                else {
                    simpleClick = true;
                }
                flashButton[i] = false;
            }
            else {
                flashButton[i] = false;
            }
            yShiftTemp += 100;
        }
    }
    private static void optionsMenuEvents(int mouseX, int mouseY, int yShiftTemp) {
        for (int i=0; i<6; i++) {
            if (mouseX >= Main.resolutionX / 2 - 100 && mouseX <= Main.resolutionX / 2 + 100 && mouseY >= Main.resolutionY / 2 - 33 + yShiftTemp && mouseY <= Main.resolutionY / 2 + 33 + yShiftTemp) {
                flashButton[i] = true;
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    if (simpleClick) {
                        if (i < 5) {
                            if (i == 0) {
                                State.changePositionUpdate();
                            }
                            else {
                                Different.setInfo("TEN SLOT JEST PUSTY");
                            }
                        }
                        else if (i == 5) {
                            menuType = 0;
                        }
                        simpleClick = false;
                    }
                }
                else {
                    simpleClick = true;
                }
            }
            else if (mouseX >= Main.resolutionX / 2 - 100+210 && mouseX <= Main.resolutionX / 2 + 100+210+40 && mouseY >= Main.resolutionY / 2 - 33 + yShiftTemp+8 && mouseY <= Main.resolutionY / 2 + 33 + yShiftTemp + 8+40) {
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    if (simpleClick) {
                        if (i==1) {
                            Save.delete(i);
                        }
                        simpleClick = false;
                    }
                }
                else {
                    simpleClick = true;
                }
                flashButton[i] = false;
            }
            else {
                flashButton[i] = false;
            }
            yShiftTemp += 100;
        }
    }
    private static void events() {
        int mouseX = Mouse.getPosition(Main.window).x;
        int mouseY = Mouse.getPosition(Main.window).y;
        for (Event event : Main.window.pollEvents()) {
            int yShiftTemp = yShiftStart;
            if (event.type == Event.Type.KEY_PRESSED) {
                if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE)) {
                    if (menuType == 0) {
                        if (isActiveGame) {
                            displayMenu = false;
                        }
                    }
                    else {
                        menuType = 0;
                    }
                }
            }
            if (menuType == 0) {
                mainMenuEvents(mouseX, mouseY, yShiftTemp);
            }
            else if (menuType == 1) {
                saveMenuEvents(mouseX, mouseY, -250);
            }
            else {
                optionsMenuEvents(mouseX, mouseY, -250);
            }
        }
    }
    public static void initiation() {
        Color color = new Color(159, 90, 90);
        for (int i=0; i<=13; i++) {
            textButton[i] = new Text();
            textButton[i].setFont(Different.arialFont);
            textButton[i].setColor(color);
        }
        textButton[0].setString("CONTINUE");
        textButton[1].setString("NEW GAME");
        textButton[2].setString("LOAD GAME");
        textButton[3].setString("SAVE GAME");
        textButton[4].setString("OPTIONS");
        textButton[5].setString("EXIT GAME");
        textButton[6].setString("SAVE 1");
        textButton[7].setString("SAVE 2");
        textButton[8].setString("SAVE 3");
        textButton[9].setString("SAVE 4");
        textButton[10].setString("SAVE 5");
        textButton[11].setString("BACK");
        textButton[12].setString("----");
        textButton[13].setString("ZMIANA INDEKSÓW");
        textButton[13].setCharacterSize(17);
        menuBackground = Different.setSprite("menuBackground.jpg");
        menuBackground.setScale(Main.resolutionX/1920f, Main.resolutionY/1080f);
        button = Different.setSprite("button.png");
        buttonFlash = Different.setSprite("buttonFlash.png");
        delete = Different.setSprite("delete.png");
        on = Different.setSprite("on.png");
        on.setPosition(Main.resolutionX / 2 - 100 + 210, Main.resolutionY / 2 - 33 + -250 + 8);
        off = Different.setSprite("off.png");
        off.setPosition(Main.resolutionX / 2 - 100 + 210, Main.resolutionY / 2 - 33 + -250 + 8);
    }
    private static void drawString(int y, Text text) {
        float shift = (200-text.getLocalBounds().width)/2;           // znak = 20 ?
        text.setPosition(Main.resolutionX / 2 - 100+shift, y);
        Main.window.draw(text);
    }
    private static void drawFlashButton(int y) {
        buttonFlash.setPosition(Main.resolutionX / 2 - 100, y);
        Main.window.draw(buttonFlash);
    }
    private static void drawDeleteButton(int y) {
        delete.setPosition(Main.resolutionX / 2 - 100 + 210, y);
        Main.window.draw(delete);
    }
    private static void drawButton(int y) {
        button.setPosition(Main.resolutionX / 2 - 100, y);
        Main.window.draw(button);
    }
    public static void menuLoop() {
        while (displayMenu) {
            Main.window.draw(menuBackground);
            int yShiftTemp = yShiftStart;
            if (menuType == 0) {        // main menu
                for (int i = j; i < 6; i++) {
                    drawButton(Main.resolutionY / 2 - 33 + yShiftTemp);
                    drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[i]);
                    if (flashButton[i]) {
                        drawFlashButton(Main.resolutionY / 2 - 33 + yShiftTemp);
                    }
                    yShiftTemp += 100;
                }
            }
            else if (menuType == 1) {   // load menu
                yShiftTemp=-250;
                for (int i = 0; i < 6; i++) {
                    button.setPosition(Main.resolutionX / 2 - 100, Main.resolutionY / 2 - 33 + yShiftTemp);
                    Main.window.draw(button);
                    if(i==5) {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[11]);
                    }
                    else if (i < Save.getSizeSaves()) {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[i + 6]);
                        drawDeleteButton(Main.resolutionY / 2 - 33 + yShiftTemp + 8);
                    }
                    else {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[12]);
                    }
                    if (flashButton[i]) {
                        drawFlashButton(Main.resolutionY / 2 - 33 + yShiftTemp);
                    }
                    yShiftTemp += 100;
                }
            }
            else {  // options menu
                yShiftTemp=-250;
                for (int i = 0; i < 6; i++) {
                    button.setPosition(Main.resolutionX / 2 - 100, Main.resolutionY / 2 - 33 + yShiftTemp);
                    Main.window.draw(button);
                    if(i==5) {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[11]);
                    }
                    else if (i==0) {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 20, textButton[13]);
                        if (State.getPositionUpdate()) {
                            Main.draw(off);
                        }
                        else {
                            Main.draw(on);
                        }
                    }
                    else {
                        drawString(Main.resolutionY / 2 - 33 + yShiftTemp + 10, textButton[12]);
                    }
                    if (flashButton[i]) {
                        drawFlashButton(Main.resolutionY / 2 - 33 + yShiftTemp);
                    }
                    yShiftTemp += 100;
                }
            }
            Different.drawInfo();
            Main.window.display();
            events();
        }
    }
}
