import java.util.HashMap;

public class hashMapInHashMap {
    static HashMap<Integer, HashMap<Integer, Byte>> zniszczenia = new HashMap();
    static byte get(int i, int j) {
        try { return zniszczenia.get(i).get(j);  }
        catch (NullPointerException e) {  return 0;     }
    }
    static void set(int i, int j, byte life)
    {
        zniszczenia.get(i).put(j, life);
    }
    public static void remove(int i, int j) {
        System.out.println("usuwam: " + i + " " + j);
        try {
            zniszczenia.get(i).remove(j);
        }
        catch (NullPointerException e) 		{   System.out.println("BŁĄD");     }
    }
    public static void main (String[]args) {
        for (int i=0; i<100; i++) {
            zniszczenia.put(i, new HashMap());
        }
        set(0, 0, (byte)1);
        set(1, 1, (byte)1);
        set(1, 2, (byte)1);
        set(2, 2, (byte)1);
        remove(0, (byte)0);
        for (int j=0; j<4; j++) {
            for (int i=0; i<5; i++) {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
