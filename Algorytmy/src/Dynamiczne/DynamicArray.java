package Dynamiczne;
import java.util.ArrayList;

public class DynamicArray<T> {

    private T[] tab;
    private int startSize = 50;
    private int nOfElements;
    public DynamicArray() {
        nOfElements = 0;
        tab = (T[])new Object[startSize];
    }
    public DynamicArray(int size) {
        startSize = size;
        nOfElements = 0;
        tab = (T[])new Object[startSize];
    }
    public boolean contains(T element) {
        for(int i = 0; i < nOfElements; i++) {
            if(tab[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    public void add(T element) {
        if(nOfElements >= tab.length) {
            T[] newTab = (T[])new Object[tab.length * 2];
            System.arraycopy(tab, 0, newTab, 0, nOfElements);
            tab = newTab;
        }
        tab[nOfElements++] = element;
    }
    public void add(int index, T element) {
		/*
		 * Nalezy zadbac o:
		 *  - relokacje elementow,
		 *  - przesuniecie elementow na prawo od podanego indeksu,
		 *  - wstawienie elementu na podanym indeksie,
		 *  - aktualizacje informacji o liczbie elementow w tablicy dynamicznej,
		 *  - rzucenie wyjatku w przypadku proby wstawienia elementu
		 *    w miejscu przekraczajacym rozmiar tablicy dynamicznej. 
		 */
    }
    public boolean remove(int index) {
//        if(nOfElements == 0) {
//            return false;
//        }
        if(index >= 0 && index < nOfElements) {
            for(int i = index; i < nOfElements - 1; i++) {
                tab[i] = tab[i + 1];
            }
            nOfElements--;
        } else {
            throw new IndexOutOfBoundsException("" + index);
        }
        return true;
    }
    public T get(int index) {
        if(index >= 0 && index < nOfElements) {
            return tab[index];
        } else {
            throw new IndexOutOfBoundsException("" + index);
        }
    }
    public int size() {
        return nOfElements;
    }
    public void clear() {
        nOfElements = 0;
        tab = (T[])new Object[startSize];
    }
    public boolean isEmpty() {
        return nOfElements == 0;
    }
    public void print() {
        StringBuilder content = new StringBuilder("[");
        for(int i = 0; i < nOfElements; i++) {
            content.append(tab[i]).append(",");
        }

        content.append("]");
        if(content.length() > 2) {
            content.deleteCharAt(content.length() - 2);
        }
        System.out.println(content);
    }
}
class DynamicArrayApp {
    public static void main(String[] args) {
        DynamicArray<Integer> dynArray = new DynamicArray<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
		//Wstawienie 100 liczb
        for(int i = 1; i <= 100; i++) {
            dynArray.add(i);
        }
        System.out.println("Dodano 100 elementow. Rozmiar: " + dynArray.size() + "\nZawartosc: ");
		//Wyswietlenie zawartosci tablicy
        dynArray.print();
		//Usuniecie 5 elementow
        dynArray.remove(0);
        dynArray.remove(39);
        dynArray.remove(29);
        dynArray.remove(19);
        dynArray.remove(dynArray.size() - 1);
        System.out.println("Usunieto 5 elementow. Rozmiar: " + dynArray.size() + "\nZawartosc: ");
        dynArray.print();
        ArrayList<Integer> arrayka = new ArrayList<>();
		//Wyswietlenie elementu na indeksie 5
        System.out.println("Element na indeksie 5: " + dynArray.get(5));
		//Sprawdzenie, czy tablica zawiera liczbe 20
        System.out.println("Czy zawiera liczbe 20?: " + dynArray.contains(20));
        System.out.println("Czy zawiera liczbe 21?: " + dynArray.contains(21));
		//Wyczyszczenie tablicy
        dynArray.clear();
        System.out.println("Wyczyszczono tablice. Rozmiar: " + dynArray.size() + "\nZawartosc: ");
        dynArray.print();
		//Utworzenie nowej tablicy o podanym rozmiarze poczatkowym
        dynArray = new DynamicArray(4);
    	//Kilka operacji wstawiania elementow
        dynArray.add(1);
        dynArray.add(2);
        dynArray.add(3);
        dynArray.add(4);
        dynArray.add(5);
        dynArray.add(0, 999);
        dynArray.add(dynArray.size() / 2, 777);
        dynArray.add(dynArray.size() - 1, 888);
        dynArray.print();
		//Utworzenie tablicy przechowujacej obiekty typy String
        DynamicArray array = new DynamicArray();
        array.add("ASDF");
        array.add(1);
        array.print();
    }
}
