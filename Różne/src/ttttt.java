/**
 * 28.11.15.
 */
public class ttttt {
    public static void main(String[] args) {
        Matka matka1 = new Dziecko1();
        Matka matka2 = new Dziecko2();
//        if (matka1 instanceof Dziecko1) {
//            System.out.println("***");
//        }
//        if (matka1 instanceof Matka) {
//            System.out.println("***");
//        }
        Dziecko1 dziecko1 = (Dziecko1)matka1;
    }
}
