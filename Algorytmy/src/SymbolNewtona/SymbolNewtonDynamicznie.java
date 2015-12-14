/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SymbolNewtona;

/**
 *
 * @author student
 */
public class SymbolNewtonDynamicznie {
    public static void main(String[] args) {
        System.out.println(newton(4, 3));
    }
    static int newton(int K, int N) {
        int[][] newton = new int[K+1][N+1];
        boolean end = false;
        for (int s=1; s<=K; s++) {
            newton[s][s]=1;
        }
        for (int r=1; r<=N; r++) {
            newton[0][r] = 1;
        }
        int limitK = 1;
        for(int n=1; n<=N; n++) {
            for(int k=1; k<limitK; k++) {
                if (k<K) {
                    newton[k][n] = newton[k-1][n-1] + newton[k-1][n];
                }
                else {
                    end = true;
                    break;
                }
            }
            limitK++;
            if (end) {
                break;
            }
        }
        for (int i=0; i<=K; i++) {
            for (int j=0; j<=N; j++) {
                if (newton[i][j] != 0) {
                    System.out.print(newton[i][j] + " ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        return newton[K][N];
    }
}
