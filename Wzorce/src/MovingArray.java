/**
 * 02.12.15.
 */
public class MovingArray {
    private int[] tablica;
    private int size;
    MovingArray(int size) {
        tablica = new int[size];
        for (int i=0; i<size; i++) {
            tablica[i] = i;
        }
        this.size = size;
    }
    void set(int index, int value) {
        tablica[index] = value;
    }
    int get(int index) {
        return tablica[index];
    }
    void remove(int index) {
        size--;
        for (int i=index; i<size; i++) {
            tablica[i] = tablica[i+1];
        }
    }
    public void toStringg() {
        for (int i=0; i<size; i++) {
            System.out.print(tablica[i] + ", ");
        }
    }
}
