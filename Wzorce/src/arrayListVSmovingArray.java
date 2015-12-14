import java.util.ArrayList;

/**
 * 02.12.15.
 */
public class arrayListVSmovingArray {
    public static void main(String[] args) {
        int size = 999;
        MovingArray movingArray = new MovingArray(size);
        double start = System.currentTimeMillis();
        movingArray.remove(1);
        System.out.println(System.currentTimeMillis() - start);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<size; i++) {
            arrayList.add(i);
        }
        start = System.currentTimeMillis();
        movingArray.remove(1);
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));

    }
}
