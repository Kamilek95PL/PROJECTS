package FibonacciSequence;

/**
 * 04.11.15.
 */
public class CiagFibonacciegoRekurencyjnie {
    static int fibonacci(int a) {
        if (a<=1)       {   return a;   }
        else return fibonacci(a-1)+fibonacci(a-2);
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int proba=0; proba<9; proba++) {
            fibonacci(40);
        }   //5400
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }
}
