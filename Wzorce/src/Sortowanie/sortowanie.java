package Sortowanie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class sortowanie {
    static int ile;
    static double start;
    static double czas;
    static int tablica[];
    static int tablicaWynikowa[];
    static void sortowanie_babelkowe(int tab[]) {
        for (int i = 1; i < tab.length; i++) {
            for (int j = tab.length - 1; j >= 1; j--) {
                if (tab[j] < tab[j - 1]) {
                    int bufor;
                    bufor = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = bufor;
                }
            }
        }
    }
    static void sortowanie_babelkoweP(int tab[]) {
        for (int i = 1; i < tab.length; i++) {
            for (int j = tab.length - 1; j >= i; j--) {
                if (tab[j] < tab[j - 1]) {
                    int bufor;
                    bufor = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = bufor;
                }
            }
        }
    }
    static void quicksort(int lewy, int prawy) {
        int v = tablica[(lewy + prawy) / 2];
        int i, j, x;
        i = lewy;
        j = prawy;
        do {
            while (tablica[i] < v) i++;
            while (tablica[j] > v) j--;
            if (i <= j) {
                x = tablica[i];
                tablica[i] = tablica[j];
                tablica[j] = x;
                i++;
                j--;
            }
        }
        while (i <= j);
        if (j > lewy) quicksort(lewy, j);
        if (i < prawy) quicksort(i, prawy);
    }
    static void sortowanieNajmniejsze(int tablica[]) {
        double startt = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i: tablica) {
            arrayList.add(i);
        }
        tablicaWynikowa = new int[tablica.length];
        System.out.println("Czas na tabele: " + (System.currentTimeMillis() - startt));
        int indexMin = -1;
        int ulozone = 0;
        for (int s=0; s<tablica.length; s++) {
            int sesyjnieNajmniejsza = 999999999;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j) < sesyjnieNajmniejsza) {
                    sesyjnieNajmniejsza = arrayList.get(j);
                    indexMin = j;
                }
            }
            tablicaWynikowa[ulozone] = arrayList.get(indexMin);
            ulozone++;
            arrayList.remove(indexMin);
        }
    }
    public static void main(String[] args) {
        {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
//            System.out.println("Porownanie czasow sortowania v.1");
            System.out.print("Ile losowych liczb w tablicy: ");
            ile = scanner.nextInt();
            tablica = new int[ile];
            int tablicaWzorcowa[] = new int[ile];
//            int tablica2[] = new int[ile];
//            int tablica3[] = new int[ile];
            for (int i = 0; i < ile; i++) {
                tablicaWzorcowa[i] = random.nextInt(100000) + 1;
            }
//            for (int i = 0; i < ile; i++) {
//                tablica2[i] = tablica[i];
//                tablica3[i] = tablica[i];
//            }
//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablica[i]+", ");
//            }
//            System.out.println();
//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablica2[i]+", ");
//            }
//            System.out.println();
//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablica3[i]+", ");
//            }
//            System.out.println();

//            start = System.currentTimeMillis();
//            sortowanie_babelkowe(tablica);
//            System.out.println("Czas sortowania babelkowego: " + (System.currentTimeMillis() - start) + " s");
            int liczbaProb = 2;
            int czas = 0;
            for (int j=0; j<liczbaProb; j++) {
//                for (int i = 0; i < ile; i++) {
//                    tablica[i] = tablicaWzorcowa[i];
//                }
                tablica = tablicaWzorcowa.clone();
                start = System.currentTimeMillis();
//                quicksort(0, ile - 1);
                czas += System.currentTimeMillis() - start;
            }
            System.out.println("Czas sortowania quicksort: " + czas/liczbaProb + " s");


//            start = System.currentTimeMillis();
//            sortowanie_babelkoweP(tablica3);
//            System.out.println("Czas sortowania babelkowegoP: " + (System.currentTimeMillis() - start) + " s");

//            start = System.currentTimeMillis();
//            sortowanieNajmniejsze(tablica3);
//            System.out.println("Czas sortowania najmniejszego: " + (System.currentTimeMillis() - start) + " s");

//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablica[i]+", ");
//            }
//            System.out.println();
//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablica2[i]+", ");
//            }
//            System.out.println();
//            for(int i=0; i<ile; i++)
//            {
//                System.out.print(tablicaWynikowa[i]+", ");
//            }
        }
    }
}
