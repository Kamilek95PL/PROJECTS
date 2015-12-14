package gameObjectsOrientedModel.Objects;

/**
 * 02.11.15.
 */
public abstract class Object {
    int type, x, y;
    public Object(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    public int getType() {
        return type;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void increaseX() {
        x++;
    }
    public void decreaseX() {
        x--;
    }
    public void increaseY() {
        y++;
    }
    public void decreaseY() {
        y--;
    }
    abstract public boolean checkMouseIn(int index, int mouseX, int mouseY);
}
