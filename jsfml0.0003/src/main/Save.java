package main;

import java.io.*;
import java.util.ArrayList;

/**
 * 25.10.15.
 */
public class Save {
    private static int saveNumber = 0;
    public static void initLoad() {
        File saveDir = new File(".", "Save/");
        if (saveDir.isDirectory() == false) {
            System.out.println("tworze folder");
            saveDir.mkdir();
        }
        for(int i=0; i<5; i++) {
            File file = file(i);
            if (file.isFile()) {
                saveNumber++;
            }
            else {
                break;
            }
        }
    }
    public static ArrayList load(int index) {
        try {
            File file = file(index);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<int[]> loadResult = new ArrayList<>();
            int[] temporary = new int[5];
            for (int i = 0; i < 5; i++) {
                temporary[i] = Integer.valueOf(bufferedReader.readLine());
            }
            boolean ok = true;
            while (ok) {
                loadResult.add(temporary);
                temporary = new int[5];
                for (int i = 0; i < 5; i++) {
                    try {
                        temporary[i] = Integer.valueOf(bufferedReader.readLine());
                    } catch (NumberFormatException e) {
                        ok = false;
                        break;
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
            return loadResult;
        } catch (IOException e) {

        }
        return null;
    }
    public static void delete(int index) {
        File file = file(index);
        file.delete();
        for (int i=index+1; i<saveNumber; i++) {
            file = file(i);
            File newRenamedFile = file(i-1);
            try {
                newRenamedFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.renameTo(newRenamedFile);
        }
        saveNumber--;
    }
    private static File file(int index) {
        return new File(".", "Save/" + index + ".txt");
    }
    public static void save(ArrayList<int[]> toSave){
        try {
            File file = file(saveNumber);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.append(name);
//        bufferedWriter.newLine();
            for (int i = 0; i < toSave.size(); i++) {
                bufferedWriter.append(Integer.toString(toSave.get(i)[0]));
                bufferedWriter.newLine();
                bufferedWriter.append(Integer.toString(toSave.get(i)[1]));
                bufferedWriter.newLine();
                bufferedWriter.append(Integer.toString(toSave.get(i)[2]));
                bufferedWriter.newLine();
                bufferedWriter.append(Integer.toString(toSave.get(i)[3]));
                bufferedWriter.newLine();
                bufferedWriter.append(Integer.toString(toSave.get(i)[4]));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            saveNumber++;
            Different.setInfo("ZAPISANO");
        } catch (IOException e) {
            Different.setInfo("NIE ZAPISANO");
        }
    }
    public static int getSizeSaves() {
        return saveNumber;
    }
}
