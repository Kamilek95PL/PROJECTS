/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plecakowy.zachlany;

/**
 *
 * @author student
 */
public class PlecakowyZachalnyObjetosc {

        /**
         * @param args the command line arguments
         */
    final static int N = 6; // liczba przedmiotów
    final static int MAX_V = 10; // objetość plecaka
    final static int[] V = {2, 6, 3, 3, 1, 2}; // objetości przedmiotów
    final static int[] W = {4, 6, 5, 10, 2, 7}; // wartości przedmiotów
    public static void pakujCenne() {
        // tablica na optymalny podzbior
        boolean[] rozw = new boolean[N];
        for (int i = 0; i < N; i++) {
            // Na poczatku nic nie zostalo zabrane (pusty plecak)
            rozw[i] = false;
        }
        int sumW = 0;
        int sumV = 0;
        while (true) {
            int minV = 11;
            int minPoz = -1;
            // Szukamy najcenniejszego przedmiotu, ktory jeszcze nie zostal zabrany
            for (int i = 0; i < N; i++)
            {
                // jesli jeszcze nie zabrany
                if (!rozw[i])
                {
                    if ((sumV + V[i] <= MAX_V) && (V[i] < minV)) {
                        minV = V[i];
                        minPoz = i;
                    }
//                    else if ((sumV + V[i] <= MAX_V) && (V[i] == minV)) {
//                        if (W[i]>W[minPoz]) {
//                            minV = V[i];
//                            minPoz = i;
//                        }
//                    }
                }
            }
            if (minPoz > -1) {
                rozw[minPoz] = true;
                sumW = sumW + W[minPoz];
                sumV = sumV + V[minPoz];
            } 
            else {
                break;
            }
        }
        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + sumW);
        System.out.print("Przedmioty w plecaku: ");
        for (int i = 0; i < N; i++) {
            if (rozw[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
            pakujCenne();
            // TODO code application logic here
    }
}

