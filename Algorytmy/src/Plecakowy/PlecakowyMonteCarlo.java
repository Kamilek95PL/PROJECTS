package Plecakowy;

import java.util.Random;

public class PlecakowyMonteCarlo {
    static final int N = 6;
    static final int V = 10;
    final static int[] Vi = {2, 6, 3, 3, 1, 2};
    final static int[] Wi = {4, 6, 5, 10, 2, 7};
    public static void main(String[] args) {
        String optKonfig = new String();
        Random los = new Random();
        int optV = -1;
        int optW = 0;
        int liczbaLosowan = 10;
        for (int i = 0; i < liczbaLosowan; i++) {
            // wstepne ustawienie przedmiotow
            int[] ustaw = new int[N];
            for (int j = 0; j < N; j++) {
                ustaw[j] = j;
            }
            // tasowanie przedmiotow
            for (int j = 0; j < N; j++) {
                int rndIndex = los.nextInt(N);
                if (rndIndex != j) {
                    // Zamiana elementow
                    int pom = ustaw[j];
                    ustaw[j] = ustaw[rndIndex];
                    ustaw[rndIndex] = pom;
                }
            }
            String locKonfig = new String();
            int sumV = 0;
            int sumW = 0;
            int j = 0;
            // bierzemy przedmioty do plecaka od poczatku tablicy dopoki sie mieszcza
            while ((j < N) && (sumV + Vi[ustaw[j]] <= V)) {
                sumV = sumV + Vi[ustaw[j]];
                sumW = sumW + Wi[ustaw[j]];
                locKonfig = locKonfig + " " + ustaw[j];
                j++;
            }
            if (sumW > optW) {
                optW = sumW;
                optV = sumV;
                optKonfig = locKonfig;
            }
        }
        System.out.println("Objetosc przedmiotow w plecaku: " + optV);
        System.out.println("Wartosc przedmiotow w plecaku: " + optW);
        System.out.println("Przedmioty w plecaku: " + optKonfig);
    }
}