package Astronauci;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author �ukasz
 */
public class Astronauci {

    public static void main(String[] args) {
        //moc zbioru
        final int N = 5;
        /*
         * rozmiar tablicy jest o 1 wiekszy od mocy zbioru ze wzgledu na ostatnia
         * operacje dodawania (111 + 1 = 1000: gdyby dlugosc tablicy byla rowna N,
         * to w ostatniej operacji dodawania rozmiar zostalby przekroczony)
         */
        int[][] umiejetnosciAstronauty = {{0, 3}, {3, 1}, {2, 1}, {1, 0}, {3, 2}};
        boolean[] najlepszyUklad = {false, false, false, false, false};
        boolean[][] inneNajlepszeUklady = new boolean[10][5];
        int liczbaInnych = 0;
        int najmniejszaIloscAstronautow = 6;
        int[] tab = new int[N + 1];
        int s = (int) Math.pow(2, N);
        for (int l = 0; l < s; l++) {
            boolean[] potencjalnyNajlepszyUklad = {false, false, false, false, false};
            boolean[] umiejetnosciUkladu = {false, false, false, false};
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) {
                    potencjalnyNajlepszyUklad[i] = true;
                    umiejetnosciUkladu[umiejetnosciAstronauty[i][0]] = true;
                    umiejetnosciUkladu[umiejetnosciAstronauty[i][1]] = true;
                }
            }
            boolean wszystkieUmiejetnosci = true;
            for (int i=0; i<4; i++) {
                if (umiejetnosciUkladu[i] == false) {
                    wszystkieUmiejetnosci = false;
                }
            }
            if (wszystkieUmiejetnosci) {
                int potencjalnieNajmniejszaIloscAstronautow = 0;
                for (int i=0; i<N; i++) {
                    if (potencjalnyNajlepszyUklad[i]) {
                        potencjalnieNajmniejszaIloscAstronautow++;
                    }
                }
                if (potencjalnieNajmniejszaIloscAstronautow < najmniejszaIloscAstronautow) {
                    najmniejszaIloscAstronautow = potencjalnieNajmniejszaIloscAstronautow;
                    najlepszyUklad = potencjalnyNajlepszyUklad;
                }
                else if (potencjalnieNajmniejszaIloscAstronautow == najmniejszaIloscAstronautow) {
                    inneNajlepszeUklady[liczbaInnych] = potencjalnyNajlepszyUklad;
                    liczbaInnych++;
                }
            }
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
        for (int j=0; j<liczbaInnych; j++) {
            for (int i=0; i<N; i++) {
                if (inneNajlepszeUklady[j][i]) {
                    System.out.print("k" + (i+1) + " ");
                }
            }
            System.out.println();
        }
        for (int i=0; i<N; i++) {
            if (najlepszyUklad[i]) {
                System.out.print("k" + (i+1) + " ");
            }
        }
//        for (int i=0; i<N; i++) {
//            if (najlepszyUklad[i]) {
//                System.out.print("k" + (i+1) + " ");
//            }
//        }
    }
}
