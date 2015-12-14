package dataTypes;

import java.util.ArrayList;

/**
 * 08.11.15.
 */
public class abc {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();


        int jedynek = 0;

        int tab[][] = new int[99999][99];
        for(int i=0; i<10000; i++) {
            tab[i][0] = 1;
            jedynek++;
        }
//        System.out.println(jedynek);
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for(int i=0; i<100; i++) {
//            list.add(1);
//        }

        //odczyt
        int r=0;
//        Array
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i=0; i<jedynek; i++) {
//            r += list.get(i);
            r += tab[i][0];
        }
        System.out.println(r);
        System.out.println(System.currentTimeMillis() - start);

    }
}
