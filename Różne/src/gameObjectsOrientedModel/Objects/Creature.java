package gameObjectsOrientedModel.Objects;

/**
 * 02.11.15.
 */
public abstract class Creature extends Object {
    int life, ownership, attack;
    public Creature(int x, int y, int owership) {
        super(0, x, y);
        this.ownership = owership;
        this.life = 100;
        this.attack = 1;
    }
    public  int getLife() {
        return life;
    }
    public  int getOwnership() {
        return ownership;
    }
    public  int getTypeCreature() {
        return type;
    }
    public int getAttack() {
        return attack;
    }
    public void decreaseLife() {
        life--;
    }

//    abstract public boolean checkMouseIn(int index, int mouseX, int mouseY);
}
