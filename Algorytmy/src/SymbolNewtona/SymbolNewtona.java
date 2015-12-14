package SymbolNewtona;

import java.util.Scanner;

/**
 * 04.11.15.
 */
public class SymbolNewtona {
    static int newton(int n, int k) throws IllegalArgumentException {
        if (0 < k && k < n) {
            if (k == 0 || k == n) {
                return 1;
            }
            else {
                return newton(n - 1, k - 1) + newton(n - 1, k);
            }
        }
        else {
            throw new IllegalArgumentException("złe dane");
        }
    }
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj n: ");
            int n = scanner.nextInt();
            System.out.print("Podaj k: ");
            int k = scanner.nextInt();
            try {
                System.out.println(newton(n, k));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

