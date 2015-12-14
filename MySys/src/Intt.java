/**
 * 10.12.15.
 */
public class Intt {
    static boolean allIsEquel(int wartosc, int... parametry) {
        boolean rowny = true;
        for (int i : parametry) {
            if (i!=wartosc) rowny = false;
        }
        return rowny;
    }
    static boolean oneIsEquel(int wartosc, int... parametry) {
        boolean rowny = false;
        for (int i : parametry) {
            if (i==wartosc) rowny = true;
        }
        return rowny;
    }
    public static void main(String[] args) {
        System.out.println(Intt.allIsEquel(2, 1, 2, 3));
        System.out.println(Intt.allIsEquel(2, 2, 2, 2));
        System.out.println(Intt.allIsEquel(3, 3));
        System.out.println();
        System.out.println(Intt.oneIsEquel(2, 1, 2, 3));
        System.out.println(Intt.oneIsEquel(5, 1, 2, 3));
    }
}

