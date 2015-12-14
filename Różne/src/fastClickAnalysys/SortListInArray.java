package fastClickAnalysys;

import java.util.Arrays;

/**
 * 05.12.15.
 */
public class SortListInArray {
    private int[] array;
    private int size = 0;
    SortListInArray(int size) {
        array = new int[size];
        for (int i=0; i<size; i++) {
            array[i] = 999999999;
        }
    }
    public void add(int value) {
//        for (int i=0; i<size; i++) {
//            if (array[i]>value) {
//                for (int j=i+1; j<=size; j++)
//                array[j] = array[j-1];
//            }
//        }
        array[size] = value;
        size++;
    }
    public void sort() {
        Arrays.sort(array);
    }
    public int get(int value) {
        int prebiousS = -1;
        int s = size/2;
        int zakres = size/2;
        boolean first = true;
//        System.out.print("Szukam " + value + ": ");
//        int zaDuze = size, zaMale = 0;
        while (true) {
//            System.out.print(s + " " + zakres + ", ");
//            if (s == size/2) {
//                if (first) first=false;  else return -1;
//            }
//            if (s==prebiousS) {
//                if (s!=0 && s!=size-1)   s--;
//                else        return -1;
//            }
//            else {
                prebiousS = s;
                if (array[s] == value)      return s;
                else if (array[s] > value) {
                    zakres = (int)Math.ceil(zakres / 2.0);
                    if (zakres == 0)    return -1;
                    s -= zakres;
                    if (s<0)            return -1;
                }
                else {
                    zakres = (int)Math.ceil(zakres / 2.0);
                    if (zakres == 0)    return -1;
                    s += zakres;
                    if (zakres ==1) {
                        zakres = 0;
                    }
//                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getByIndex(int index) {
        return array[index];
    }
    public static void main(String[] args) {
//        SortListInArray sortListInArray = new SortListInArray(100);
//        sortListInArray.add(9);
//        sortListInArray.add(16);
//        sortListInArray.add(4);
//        sortListInArray.add(36);
//        sortListInArray.add(25);
//        sortListInArray.add(49);
//        sortListInArray.add(1);
//        sortListInArray.add(2);
//        sortListInArray.add(3);
//        sortListInArray.add(6);
//        sortListInArray.add(5);
//        sortListInArray.add(4);
//        sortListInArray.add(11);
//        sortListInArray.add(12);
//        sortListInArray.add(13);
//        sortListInArray.add(16);
//        sortListInArray.add(15);
//        sortListInArray.add(14);
//        for (int i=0; i<20; i+=2) {
//            sortListInArray.add(i);
//        }
//        sortListInArray.sort();
//        for(int i=0; i<20; i++) {
//            System.out.print(sortListInArray.getByIndex(i) + ", ");
//        }
//        System.out.println();
//        for (int i=0; i<20; i++) {
//            int znalazlem = sortListInArray.get(i);
//            if (znalazlem != -1) {
//                System.out.print("\t\t\tZnalazłem " + i + " na pozycji: " + znalazlem);
//            }
//            System.out.println();
//        }

    }
}
