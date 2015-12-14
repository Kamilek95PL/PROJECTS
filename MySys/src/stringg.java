/**
 * 10.12.15.
 */
public class stringg {
    static boolean allIsEquel(String wartosc, String... parametry) {
        boolean rowny = true;
        for (String i : parametry) {
//            if (! i.equals(wartosc)) rowny = false;
            if (i != wartosc) rowny = false;
        }
        return rowny;
    }
    static boolean oneIsEquel(String wartosc, String... parametry) {
        boolean rowny = false;
        for (String i : parametry) {
            if (i == wartosc) rowny = true;
        }
        return rowny;
    }
    public static void main(String[] args) {
        System.out.println(stringg.allIsEquel("b", "a", "b", "c"));
        System.out.println(stringg.allIsEquel("b", "b", "b", "b"));
        System.out.println(stringg.allIsEquel("c", "c"));
        System.out.println();
        System.out.println(stringg.oneIsEquel("b", "a", "b", "c"));
        System.out.println(stringg.oneIsEquel("j", "a", "b", "c"));


        String s1 = new String( "Test" );
        String s2 = new String( "Test" );

        System.out.println( "\n1 - PRIMITIVES ");
        System.out.println( s1 == s2 ); // false
        System.out.println( s1.equals( s2 )); // true
    }
}
