package dataTypes.dataTypesWar;

/**
 * 08.11.15.
 */
public class main {
    public static void main(String[] args) {
        int sizeArray = 99999999;
        int saveSize = 3;
        int loadSize = 999;
        int ttry = 99999;
//        Arrays test = new Arrays(sizeArray);
        ArrayLists test = new ArrayLists();
        long start = System.currentTimeMillis();
        for (int i=0; i<ttry; i++) {
            test.zapis(saveSize);
//            test.odczyt(loadSize);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void save() {
/*
SAVE:
size - 9999999  (WITH CREATE)
    saveSize - 3
        arrayLists time:    1
        arrays time:        7
    saveSize - 999
        arrayLists time:    2
        arrays time:        8
    saveSize - 99999
        arrayLists time:    17
        arrays time:        13
    saveSize - 999999
        arrayLists time:    13
        arrays time:        16
    saveSize - 9999999
        arrayLists time:    5223
        arrays time:        23
size - 9999999  (WITHOUT CREATE)
    saveSize - 3
        arrayLists time:    0
        arrays time:        0
    saveSize - 3 * 99 999
        arrayLists time:    15
        arrays time:        7
    saveSize - 999
        arrayLists time:    1
        arrays time:        0
    saveSize - 99999
        arrayLists time:    17
        arrays time:        2
    saveSize - 999999
        arrayLists time:    28
        arrays time:        7
    saveSize - 9999999
        arrayLists time:    5259
        arrays time:        14
*/

    }
    public static void load() {
/*
sizeArray - 99999999
LOAD saveSize - 999
    loadSize - 999
        (z suma)
            * 10
                arrayLists time:    4
                arrays time:        0
            * 100
                arrayLists time:    11
                arrays time:        1
        (bez sumy)
            * 10
                arrayLists time:    5
                arrays time:        1
            * 100
                arrayLists time:    9
                arrays time:        1
    loadSize - 1
            * 999 999
                arrayLists time:    14
                arrays time:        9
            * 9 999 999
                arrayLists time:    45
                arrays time:        5
LOAD saveSize - 9999999
    loadSize - 999
            * 10
                arrayLists time:    5
                arrays time:        0
            * 100
                arrayLists time:    13
                arrays time:        1
    loadSize - 1
            * 999 999
                arrayLists time:    20
                arrays time:        4
            * 9 999 999
                arrayLists time:    54
                arrays time:        6
*/
    }
}
