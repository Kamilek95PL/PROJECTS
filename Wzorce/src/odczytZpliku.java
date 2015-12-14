import java.io.*;

public class odczytZpliku {
    public static void main(String[]args) {
        String linia = "";
        BufferedReader dupa = null;
        try {   dupa = new BufferedReader(new FileReader("/home/kamil/text.txt"));      }
        catch (FileNotFoundException e)               { System.out.println("1"); }
        try {
            while((linia = dupa.readLine()) != null) {
                System.out.println(linia);
            }
        }
        catch (IOException ex) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }
    }
}
