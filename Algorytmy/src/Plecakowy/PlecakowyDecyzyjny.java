package Plecakowy;

public class PlecakowyDecyzyjny {
    //liczba przedmiotow
    final static int N = 6;
    //objetosc plecaka
    final static int MAX_V = 10;
    //objetosci przedmiotow
    final static int[] V = {6, 2, 3, 2, 3, 1};
    //wartosci przedmiotow
    final static int[] W = {6, 4, 5, 7, 10, 2};
    static int P(int i, int v) {
        //wartosc, gdy nie bierzemy i-tego przedmiotu
        int w1;
        //wartosc, gdy bierzemy i-tego przedmiotu
        int w2;
        //jezeli do zapakowania jest przedmiot 0 i nie miesci sie w plecaku
        if (i == 0 && v < V[0]) {
            return 0;
        }
        //jezeli do zapakowania jest przedmiot 0 i miesci sie w plecaku
        if (i == 0 && v >= V[0]) {
            return W[0];
        }
        //maksymalna wartosc plecaka o objetosci v, zapakowanego sposrod przedmiotow 0..i-1
        //(bez i-tego przedmiotu)
        w1 = P(i - 1, v);
        //jezeli i-ty przedmiot nie miesci sie do plecaka
        if (i > 0 && v < V[i]) {
            return w1;
        }
        //maksymalna wartosc plecaka o objetosci v - Vi, zapakowanego sposrod przedmiotow
        //0..i-1 plsus wartosc i-tego przedmiotu
        w2 = W[i] + P(i - 1, v - V[i]);
        if (w2 > w1) {
            return w2;
        } else {
            return w1;
        }
    }
    public static void main(String[] args) {
        int wynik = P(N - 1, MAX_V);
        System.out.println("Wartosc przedmiotow: " + wynik);
    }
}