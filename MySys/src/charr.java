/**
 * 10.12.15.
 */
public class charr {
    static boolean allIsEquel(char wartosc, char... parametry) {
        boolean rowny = true;
        for (char i : parametry) {
            if (i!=wartosc) rowny = false;
        }
        return rowny;
    }
    static boolean oneIsEquel(char wartosc, char... parametry) {
        boolean rowny = false;
        for (char i : parametry) {
            if (i == wartosc) rowny = true;
        }
        return rowny;
    }
    public static void main(char[] args) {
        System.out.println(charr.allIsEquel('b', 'a', 'b', 'c'));
        System.out.println(charr.allIsEquel('b', 'b', 'b', 'b'));
        System.out.println(charr.allIsEquel('c', 'c'));
        System.out.println();
        System.out.println(charr.oneIsEquel('b', 'a', 'b', 'c'));
        System.out.println(charr.oneIsEquel('j', 'a', 'b', 'c'));
    }
}
