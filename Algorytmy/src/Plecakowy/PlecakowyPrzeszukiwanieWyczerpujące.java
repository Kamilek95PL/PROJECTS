package Plecakowy;

public class PlecakowyPrzeszukiwanieWyczerpujące {
    public static void main(String[] args) {
        final int N = 6;
        int[] objetoscPrzedmiotu = {6, 2, 3, 2, 3, 1};
        int[] wartoscPrzedmiotu = {6, 4, 5, 7, 10, 2};
        boolean[] najlepszyUklad = {false, false, false, false, false, false};
        int wartoscNajlepszegoUkladu = 0;
        int objetoscNajlepszegoUkladu = 0;
        int[] tab = new int[N + 1];
        int s = (int) Math.pow(2, N);
        for (int l = 0; l < s; l++) {
            boolean[] potencjalnyNajlepszyUklad = {false, false, false, false, false, false};
            int wartoscPotencjalnegoNajlepszegoUkladu = 0;
            int objetoscPotencjalnegoNajlepszegoUkladu = 0;
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) {
                    objetoscPotencjalnegoNajlepszegoUkladu += objetoscPrzedmiotu[i];
                    wartoscPotencjalnegoNajlepszegoUkladu += wartoscPrzedmiotu[i];
                    potencjalnyNajlepszyUklad[i] = true;
                }
            }
            if (objetoscPotencjalnegoNajlepszegoUkladu<=10) {
                if (wartoscPotencjalnegoNajlepszegoUkladu > wartoscNajlepszegoUkladu) {
                    wartoscNajlepszegoUkladu = wartoscPotencjalnegoNajlepszegoUkladu;
                    objetoscNajlepszegoUkladu = objetoscPotencjalnegoNajlepszegoUkladu;
                    najlepszyUklad = potencjalnyNajlepszyUklad;
                }
            }
            int i = 0;
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
        System.out.println("wartosc najlepszego uk?adu: " + wartoscNajlepszegoUkladu);
        System.out.println("objetosc najlepszego uk?adu: " + objetoscNajlepszegoUkladu);
        for (int i=0; i<6; i++) {
            if (najlepszyUklad[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
