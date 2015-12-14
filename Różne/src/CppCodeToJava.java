import java.io.*;
/**
 * 05.11.15.
 */
public class CppCodeToJava {
    void analiseLine(String cppLine) {
        String result = "";
        System.out.println("orginał: " + cppLine);
        if (cppLine.substring(0, 4).equals("cout")) {
            result += "System.out.print";
            if (cppLine.charAt(cppLine.length()-2) == 'l') {          //  endl
                result += "ln";
            }
            result += "(";
//            int i=6;
//            boolean end = false;
//            do {
//                String block = "";
//                while (true) {
//                    if (cppLine.charAt(i) == ';') {
//                        if (! block.equals("endl")) {
//                            result += block;
//                        }
//                        end  =  true;
//                        break;
//                    }
//                    else if (cppLine.charAt(i) == '<') {
//                        i += 2;
//                        result += block;
//                        result += "+";
//                        break;
//                    }
//                    block += cppLine.charAt(i);
//                    i++;
//                }
//            }   while (end == false);
//            result += ");";
//            System.out.println(result);
            int i=4;
            boolean firstBlock = true;
            boolean end = false;
            do {
                i += 2;
                String block = "";
//                while (cppLine.charAt(i) != '<' && cppLine.charAt(i) != ';') {
//                    block += cppLine.charAt(i);
//                    i++;
//                }
                while (! charr.allIsEquel(cppLine.charAt(i), '<', ';')) {
                    block += cppLine.charAt(i);
                    i++;
                }
                if (! block.equals("endl")) {
                    if (firstBlock) {
                        firstBlock = false;
                    }
                    else {
                        result += '+';
                    }
                    result += block;
                }
            }   while (cppLine.charAt(i) != ';');
            result += ");";
            System.out.println(result);
        }
    }
    public CppCodeToJava(String fileLocation) {
        File file = new File(fileLocation);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(new File(fileLocation));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                analiseLine(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new CppCodeToJava("Różne/src/cpp.txt");
    }
}
