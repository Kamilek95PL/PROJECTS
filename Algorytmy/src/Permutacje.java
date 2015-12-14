public class Permutacje {
	final static int N = 3;
	/*
	* tablica reprezentujaca liste elementow
	*/
	private static int[] lista = new int[N];

	static void permutacje(int i) {
	/*
	* Wypisanie permutacji w przypadku gdy lista wypelniona jest elementami -
	* znaleziono jeden ze stanow koncowych
	*/
		if(i == N) {
			for(int j = 0; j < N; j++) {
				System.out.print(lista[j] + " ");
			}
			System.out.println();
		} else {
			//Dla kazdego elementu ze zbioru {1,...,N}
			for (int j = 1; j <= N; j++) {
				int k;
				//Dla aktualnej listy elementow o dlugosci "i"
				for (k = 0; k < i; k++) {
					/*
					* Sprawdzenie, czy element "j" znajduje sie na liscie
					* jeśli tak, to przejscie do kolejnego stanu (czyli dodanie
					* elementu na koniec listy) nie bedzie mozliwe - petla zostanie
					* przerwana, wartosc "k" nie zrowna sie z wartoscia "i"
					*/
					if (lista[k] == j) {
						break;
					}
				}
				/*
				* Jesli warunek jest spelniony to znaczy, ze jest mozliwe przejscie
				* do kolejnego stanu (element j dodawany jest na koniec listy)
				*/
				if(k == i) {
					lista[k] = j;
					permutacje(i + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		permutacje(0);
	}
}
