package fastClickAnalysys;

public class ListInArray {
    private int[] array;
    private int size = 0;
    ListInArray(int size) {
        array = new int[size];
    }
    public void add(int value) {
        array[size] = value;
        size++;
    }
    public int get(int value) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == value) {
                return value;
            }
        }
        return -1;
    }
}
