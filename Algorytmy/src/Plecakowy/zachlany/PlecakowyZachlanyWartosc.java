package Plecakowy.zachlany;
public class PlecakowyZachlanyWartosc {
    final static int N = 6;
    final static int MAX_V = 10;
    final static int[] V = {2, 6, 3, 3, 1, 2}; // objetości przedmiotów
    final static int[] W = {4, 6, 5, 10, 2, 7}; // wartości przedmiotów
    public static void pakujCenne() {
        boolean[] rozw = new boolean[N];
        for (int i = 0; i < N; i++) {
        // Na poczatku nic nie zostalo zabrane (pusty plecak)
            rozw[i] = false;
        }
        int sumW = 0;
        int sumV = 0;
        while (true) {
            int maxW = 0;
            int maxPoz = -1;
            // Szukamy najcenniejszego przedmiotu, ktory jeszcze nie zostal zabrany
            for (int i = 0; i < N; i++) {
            // jesli jeszcze nie zabrany
                if (!rozw[i]) {
                    if ((sumV + V[i] <= MAX_V) && (W[i] > maxW)) {
                        maxW = W[i];
                        maxPoz = i;
                    }
                }
            }
            if (maxPoz > -1) {
                rozw[maxPoz] = true;
                sumW = sumW + W[maxPoz];
                sumV = sumV + V[maxPoz];
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
    }
}