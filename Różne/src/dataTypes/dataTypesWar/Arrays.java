package dataTypes.dataTypesWar;

/**
 * 08.11.15.
 */
public class Arrays {
    int tab[];
    int ile = 0;
    Arrays(int size) {
        tab = new int[size];
    }
    void odczytZsuma(int j) {
        int suma = 0;
        for (int i=0; i<j; i++) {
            suma += tab[i];
        }
    }
    void odczyt(int j) {
        int r;
        for (int i=0; i<j; i++) {
            r = tab[i];
        }
    }
    void zapis(int j) {
        for (int i=0; i<j; i++) {
            tab[i] = i;
            ile++;
        }
    }
}
