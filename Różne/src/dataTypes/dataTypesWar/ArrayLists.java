package dataTypes.dataTypesWar;

import java.util.ArrayList;

/**
 * 08.11.15.
 */
public class ArrayLists {
    ArrayList<Integer> arrayList;
    ArrayLists() {
        arrayList = new ArrayList<Integer>();
    }
    void odczytZsuma(int j) {
        int suma = 0;
        for (int i=0; i<j; i++) {
            suma += arrayList.get(i);
        }
    }
    void odczyt(int j) {
        int r;
        for (int i=0; i<j; i++) {
            r = arrayList.get(i);
        }
    }
    void zapis(int j) {
        for (int i=0; i<j; i++) {
            arrayList.add(i);
        }
    }
}
