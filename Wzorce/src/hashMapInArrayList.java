import java.util.ArrayList;
import java.util.HashMap;


public class hashMapInArrayList {
    static ArrayList<ArrayList<ArrayList<HashMap<Integer, Byte>>>> zniszczenia  = new ArrayList();
    static byte get(int i, int j, int k, int r) {
        try     {   return zniszczenia.get(i).get(j).get(k).get(r);    }
        catch (NullPointerException e)  {  return 0;     }
    }
    static void set(int i, int j, int k, int r, byte life)
    {
        zniszczenia.get(i).get(j).get(k).put(r, life);
    }
    public static void remove(int i, int j, int k) {
        System.out.println("usuwam: " + i + " " + j);
        try {   zniszczenia.get(i).get(j).remove(k);   }
        catch (NullPointerException e) 		{   System.out.println("BŁĄD");     }
    }
    public static void main (String[]args) {
        for (int i=0; i<5; i++) {
            zniszczenia.add(new ArrayList());
        }
        for (int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                zniszczenia.get(i).add(new ArrayList());
            }
        }
        for (int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k=0; k<5; k++)  {
                    zniszczenia.get(i).get(j).add(new HashMap());
                }
            }
        }
        set(0, 0, 0, 0, (byte) 1);
        set(0, 0, 1, 1, (byte) 1);
        set(0, 0, 1, 2, (byte) 1);
        set(0, 0, 3, 3, (byte) 1);

        set(0, 1, 0, 0, (byte) 2);
        set(0, 1, 1, 1, (byte) 2);
        set(0, 1, 1, 2, (byte) 2);
        set(0, 1, 3, 3, (byte) 2);

        set(1, 0, 0, 0, (byte) 1);
        set(1, 0, 1, 1, (byte) 1);
        set(1, 0, 1, 2, (byte) 1);
        set(1, 0, 3, 3, (byte) 1);
      //        remove(0, (byte)0);
        for (int i=0; i<2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int r =0; r<5; r++)
                        System.out.print(get(i, j, k, r) + " ");
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
