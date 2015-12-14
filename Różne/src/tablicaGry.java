import java.util.ArrayList;
import java.util.Scanner;

/**
 * 31.10.15.
 */
public class tablicaGry {
    static int sizeInDisk = 99999999;
    static int disk[] = new int[sizeInDisk];
    static int sizeInRam = 9999999;
    static int ram[] = new int[sizeInRam];
    static ArrayList<Integer> ramA = new ArrayList();
    static Scanner scanner = new Scanner(System.in);
    static int toDecrease = sizeInRam -1, toIncrease = 0;
    static int nextWprawo = sizeInRam, nextWlewo = -1;
    static int zwieksz(int x) {
        if (x< sizeInRam -1) {
            return ++x;
        }
        else {
            return 0;
        }
    }
    static int zmniejsz(int x) {
        if (x>0) {
            return --x;
        }
        else {
            return sizeInRam -1;
        }
    }
    static void przesunWprawo() {
        if (nextWprawo<sizeInDisk) {
            ram[toIncrease] = disk[nextWprawo];
            toDecrease = zwieksz(toDecrease);
            toIncrease = zwieksz(toIncrease);
            nextWprawo++;
            nextWlewo++;
        }
        else {
            System.out.println("przusniecie w prawo niemożliwe");
        }
    }
    static void przsunWprawoTradycyjnie() {
        if (nextWprawo<sizeInDisk) {
            for (int i = 0; i < sizeInRam-1; i++) {
//                System.out.println(i);
                ram[i] = ram[i + 1];
            }
//            System.out.println();
            ram[sizeInRam-1] = disk[nextWprawo];
            nextWprawo++;
        }
        else {
            System.out.println("przusniecie w prawo niemożliwe");
        }
    }
    static void przesunWprawoArrayListy() {
        if (nextWprawo<sizeInDisk) {
            ramA.remove(0);
            ramA.add(disk[nextWprawo]);
            nextWprawo++;
        }
        else {
            System.out.println("przusniecie w prawo niemożliwe");
        }
    }
    static void przesunWlewo() {
        if (nextWlewo >= 0) {
            ram[toDecrease] = disk[nextWlewo];
            toDecrease = zmniejsz(toDecrease);
            toIncrease = zmniejsz(toIncrease);
            nextWprawo--;
            nextWlewo--;
        }
        else {
            System.out.println("przusniecie w lewo niemożliwe");
        }
    }
    static void wypisz(int index) {
        if (index< sizeInRam -toIncrease) {
            System.out.println(ram[index+toIncrease]);
        }
        else {
            System.out.println(ram[index - sizeInRam + toIncrease]);
        }
    }
    static void wypiszWszystko() {
//        System.out.print("fizycznie: ");
//        for (int i=0; i< sizeInRam; i++) {
//            System.out.print(ram[i] + ", ");
//        }
//        System.out.println();
        for (int i=toIncrease; i< sizeInRam; i++) {
            System.out.print(ram[i] + ", ");
        }
        for (int i=0; i<toIncrease; i++) {
            System.out.print(ram[i] + ", ");
        }
        System.out.println();
    }
    static void wypiszWszystkoTracydyjnie() {
        for (int i=0; i<sizeInRam; i++) {
            System.out.print(ram[i] + ", ");
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < sizeInDisk; i++) {
            disk[i] = i;
        }
        for (int i = 0; i < sizeInRam; i++) {
            ram[i] = disk[i];
            ramA.add(disk[i]);
        }
//        while (true) {
//            wypiszWszystko();
//            System.out.print("akcja: ");
//            String odczyt = scanner.next();
//            if (odczyt.equals("i")) {
//                przesunWprawo();
//            }
//            else if (odczyt.equals("d")) {
//                przesunWlewo();
//            }
//        }
        int prob = 1;


        long start = System.currentTimeMillis();


        // WŁASNE
        for (int i=0; i<prob; i++) {
            przesunWprawo();
        }
        System.out.println("czas własne: " + (System.currentTimeMillis() - start));
//        wypiszWszystko();
        System.out.println();


        nextWprawo = sizeInRam;
        // TRADYCYJNIE
        start = System.currentTimeMillis();
        for (int i=0; i<prob; i++) {
            przsunWprawoTradycyjnie();
        }
        System.out.println("czas tradycyjnie: " + (System.currentTimeMillis() - start));
//        wypiszWszystkoTracydyjnie();
        System.out.println();
        System.out.println();


        //ARRAY LIST
        start = System.currentTimeMillis();
        for (int i=0; i<prob; i++) {
            przesunWprawoArrayListy();
        }
        System.out.println("czas arrayListy: " + (System.currentTimeMillis() - start));
//        wypiszWszystkoTracydyjnie();
    }
}
