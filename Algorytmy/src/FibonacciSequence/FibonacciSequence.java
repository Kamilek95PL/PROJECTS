package FibonacciSequence;

/**
 * 30.10.15.
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int wyraz1;
        int wyraz2 = 0;
        int oczekiwanyWyraz = 41;
        int tempWyraz1;
        long start = System.currentTimeMillis();
        for (int proba=0; proba<99999999; proba++) {
            wyraz1 = 0;
            wyraz2 = 1;
            for (int i = 3; i <= oczekiwanyWyraz; i++) {
                tempWyraz1 = wyraz1;
                wyraz1 = wyraz2;
                wyraz2 = tempWyraz1 + wyraz2;
            }
        } //5137
        System.out.println("time: " + (System.currentTimeMillis() - start));
        System.out.println(wyraz2);
    }
}
