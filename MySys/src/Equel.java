/**
 * 10.12.15.
 */
public class Equel {
    static boolean allIsEquel(Object wartosc, Object... parametry) {
        boolean rowny = true;
        for (Object i : parametry) {
            if (i!=wartosc) rowny = false;
        }
        return rowny;
    }
    static boolean oneIsEquel(Object wartosc, Object... parametry) {
        boolean rowny = false;
        for (Object i : parametry) {
            if (i==wartosc) rowny = true;
        }
        return rowny;
    }
    public static void main(String[] args) {
        System.out.println(Equel.allIsEquel(2, 1, 2, 3));
        System.out.println(Equel.allIsEquel(2, 2, 2, 2));
        System.out.println(Equel.allIsEquel(3, 3));
        System.out.println();
        System.out.println(Equel.oneIsEquel(2, 1, 2, 3));
        System.out.println(Equel.oneIsEquel(5, 1, 2, 3));
        System.out.println();
        System.out.println(Equel.allIsEquel("b", "a", "b", "c"));
        System.out.println(Equel.allIsEquel("b", "b", "b", "b"));
        System.out.println(Equel.allIsEquel("c", "c"));
        System.out.println();
        System.out.println(Equel.oneIsEquel("b", "a", "b", "c"));
        System.out.println(Equel.oneIsEquel("j", "a", "b", "c"));
    }
}
