import java.util.ArrayList;
import java.util.Random;

/**
 * 30.11.15.
 */
public class LosowanieZeZbioru {
    static int tab[] = {11, 51, 18, 20, 44, 55, 66};
    static ArrayList<Integer> doWylosowania = new ArrayList<>();
    static Random random = new Random();
    static void dodajDoDoWylosowania(int[] doDodania) {
        for (int i=0; i<doDodania.length; i++) {
            doWylosowania.add(doDodania[i]);
        }
    }
    static void losuj() {
        int wylosowanyIndex = random.nextInt(doWylosowania.size());
        System.out.println(doWylosowania.get(wylosowanyIndex));
        doWylosowania.remove(wylosowanyIndex);
    }
    static void losujTablice() {
        dodajDoDoWylosowania(tab);
        for (int i=0; i<tab.length; i++) {
            int wylosowanyIndex = random.nextInt(doWylosowania.size());
            System.out.print(doWylosowania.get(wylosowanyIndex) + ", ");
            doWylosowania.remove(wylosowanyIndex);
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        dodajDoDoWylosowania(tab);
        losujTablice();
        losujTablice();
    }
}
