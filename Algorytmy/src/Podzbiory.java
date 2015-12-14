/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author �ukasz
 */
public class Podzbiory {

    public static void main(String[] args) {
        //moc zbioru
        final int N = 3;
        /*
         * rozmiar tablicy jest o 1 wiekszy od mocy zbioru ze wzgledu na ostatnia
         * operacje dodawania (111 + 1 = 1000: gdyby dlugosc tablicy byla rowna N,
         * to w ostatniej operacji dodawania rozmiar zostalby przekroczony)
         */
        int[] tab = new int[N + 1];
        //liczba wszystkich podzbiorow zbioru N elementowego = 2^N
        int s = (int) Math.pow(2, N);
        for (int l = 0; l < s; l++) {
            //Wypisanie aktualnego podzbioru
            System.out.print("{ ");
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println("}");
            int i = 0;
            /*
             * operacje dodawania jedynki do aktualnej liczby binarnej reprezentowanej
             * przez tablice "tab"
            */
            do {
                if (tab[i] == 1) {
                    tab[i] = 0;
                    i++;
                } else {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }
    }
}
