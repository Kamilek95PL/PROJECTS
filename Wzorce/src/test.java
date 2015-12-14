/**
 * 02.12.15.
 */
public class test {
    public static void main(String[] args) {
        int liczbaProb = 100;
        int wynik = 0;
        for (int j=0; j<liczbaProb; j++) {
            long start = System.currentTimeMillis();
            int tab[] = new int[99999999];
            for (int i : tab) {
                i = 999999999;
            }
            wynik += System.currentTimeMillis() - start;
        }
        System.out.println(wynik/100);
        // 0 - 83.5
    }
}
