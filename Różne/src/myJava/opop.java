package myJava;

/**
 * 05.12.15.
 */
public class opop {
    public static String endl = "\n";
    public static int safeDivision(int x, int y) {
        try {
            return x / y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie przez 0");
            return -1;
        }
    }
    public static double safeDivisionDouble(int x, int y) {
        try {
            return (double)x / (double)y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie przez 0 Double");
            return -1;
        }
    }
    public static int safeDivisionWithRest(int x, int y) {
        try {
            return x % y;
        }
        catch (ArithmeticException e) {
            // System.out.println("dzielenie z resztą przez 0");
            return -1;
        }
    }
}
