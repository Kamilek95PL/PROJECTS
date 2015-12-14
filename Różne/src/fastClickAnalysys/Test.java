package fastClickAnalysys;

import myJava.opop;

import java.util.HashMap;
import java.util.Random;

/**
 * 05.12.15.
 */
public class Test {
    int liczbaLosowan = 100;  // obiekty w grze
    int zakreLosowania = 100;    // wielkosc mapy
    int[] wylosowane = new int[liczbaLosowan];
    HashMap<Integer, Integer> hashMap = new HashMap<>();
//    ListInArray listInArray = new ListInArray(liczbaLosowan);
    SortListInArray listInArray = new SortListInArray(102);
    Test() {
        randomGameObjects();
        testHashMap();
        testListInArray();
    }
    private void testHashMap() {
        double start = System.currentTimeMillis();
        System.out.print("Hash map: ");
        for (int i=0; i<liczbaLosowan; i++) {
            int temp;
            if (hashMap.get(wylosowane[i]) != null) {
                System.out.print(wylosowane[i] + " ");
//                System.out.print(hashMap.get(wylosowane[i]) + "  ");
                temp = wylosowane[i];
            }
        }
        System.out.println(opop.endl + (System.currentTimeMillis() - start) + "ms");
    }
    public void testListInArray() {
        System.out.print(opop.endl + "Array: ");
        double start = System.currentTimeMillis();
        listInArray.sort();
        System.out.println("sort time: " + (System.currentTimeMillis() - start) + "ms");
        int temp;
//        for (int i=0; i<liczbaLosowan; i++) {
//            temp = listInArray.get(wylosowane[i]);
//            System.out.print(temp  + " ");
//        }
//        System.out.println();
        for (int i=0; i<liczbaLosowan; i++) {
            temp = listInArray.getByIndex(i);
            System.out.print(temp  + " ");
        }
        System.out.println(opop.endl + listInArray.get(100) + "ooo");
        System.out.println(opop.endl + (System.currentTimeMillis() - start) + "ms");
    }
    private void randomGameObjects() {
        Random random = new Random();
        int wylosowanych = 0;
        for (int i=0; i<liczbaLosowan; i++) {
            int los = random.nextInt(zakreLosowania);
            wylosowane[wylosowanych++] = los;
            listInArray.add(los);
            hashMap.put(los, 1);
        }
    }
    public static void main(String[] args) {
        new Test();
    }
}
