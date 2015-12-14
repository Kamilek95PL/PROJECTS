package gameObjectsOrientedModel.Objects;

/**
 * 02.11.15.
 */
public abstract class Buildings extends Object {
    int life, ownership, capacity;
    public Buildings(int x, int y, int owership) {
        super(1, x, y);
        life = 1000;
        this.ownership = owership;
        this.capacity = 100;
    }
    public int getLife() {
        return life;
    }
    public int getOwnership() {
        return ownership;
    }
    public int getCapacity() {
        return capacity;
    }
    public void increaseLife() {
        life++;
    }
    public void decreaseLife() {
        life--;
    }
}
