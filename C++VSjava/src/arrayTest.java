/** 18.09.15 */
public class arrayTest {
    public static void main (String[] args) {
        int liczba = 99999999;
        long start;
        int x[] = new int[99999999];
        start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < liczba; j++) {
                x[j] = j+i;
                x[j] += 510; // twoja stara
            }
        }
        System.out.println("z wskażnikiem: " + (System.currentTimeMillis() - start));
    }
}
