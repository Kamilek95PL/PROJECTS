package testSql;

import java.sql.*;

/**
 * 14.11.15.
 */
public class wieleMalych {
    static Statement stt;
    static Connection con;
    static String apo = "'";
    static void connect() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, user, password);
        stt = con.createStatement();
        stt.execute("USE drzewo");
    }
    static void createTable(String nameTable) throws SQLException {
        stt.execute("DROP TABLE IF EXISTS " + nameTable);
        stt.execute("CREATE TABLE " + nameTable + " ("
//               + "id BIGINT NOT NULL AUTO_INCREMENT,"
                + "imie VARCHAR(25),"
                + "wiek VARCHAR(25)"
//                + "PRIMARY KEY(id)"
                + ")");
    }
    static void addToTable(String tabName, String imie, String wiek) throws SQLException {
        stt.executeUpdate("INSERT INTO " + tabName + " (imie, wiek) VALUES(" + (apo + imie + apo + "," + apo + wiek + apo)+")");
    }
    static int getWiekByName(String nameTab, String imie) throws SQLException {
        ResultSet resultSet = stt.executeQuery("SELECT wiek FROM " + nameTab + " WHERE imie=" + apo + imie + apo);
        resultSet.next();
        return resultSet.getInt("wiek");
    }
//    static ResultSet getOneByName(String nameTab, String imie) throws SQLException {
//        return stt.executeQuery("SELECT wiek FROM " + nameTab + " WHERE imie=" + apo + imie + apo);
//    }
//    static ResultSet getAll() throws SQLException {
//        return stt.executeQuery("SELECT * FROM uzytkownicy");
////            PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
////            prep.setString(1, "Bloggs");
////
////            res = prep.executeQuery();
////            while (res.next())
////            {
////                System.out.println(res.getString("fname") + " " + res.getString("lname"));
////            }
//    }
//    static void writeAllToConsole() throws SQLException {
//        ResultSet resultSet = getAll();
//        while (resultSet.next())
//        {
//            System.out.println(resultSet.getString("user") + " " + resultSet.getString("drewno"));
//        }
//        System.out.println("");
//        resultSet.close();
//    }
//    static void writeOneByName(String imie) throws SQLException {
////        ResultSet resultSet = getOneByName(, imie);
////        while (resultSet.next())
////        {
////            System.out.println(resultSet.getString("user") + " " + resultSet.getString("drewno"));
////        }
////        System.out.println("");
////        resultSet.close();
//    }
//    static void increaseDrewno() throws SQLException {
//        String newDrewnoValue = String.valueOf(getWiekByName("kamil")+1);
//        stt.execute("UPDATE uzytkownicy SET drewno = " + newDrewnoValue + " WHERE user = 'kamil'");
//    }
    static void wypisz() throws Exception {
        int result = 0;
        for (int i=97; i<123; i++) {
            char[] value = {(char)i, 'a', 'a', 'a', 'a', 'a'};
            for(int j=1; j<6; j++) {
                for (int s=98; s<123; s++) {
                    value[j]=((char)s);
                    String valuee = "";
                    for (int p=0; p<6; p++) {
                        valuee += value[p];
                    }
                    result += getWiekByName(String.valueOf((char)i), valuee);
//                    result += getWiekByName("az", valuee);
                }
            }
//                System.out.println(i-96 + "/26");
        }
        System.out.println(result);
    }
    static void uzupelnij() throws Exception {
        for (int i=97; i<123; i++) {
            createTable(String.valueOf((char)i));
        }
//        createTable("az");
        for (int i=97; i<123; i++) {
            char[] value = {(char)i, 'a', 'a', 'a', 'a', 'a'};
            for(int j=1; j<6; j++) {
                for (int s=98; s<123; s++) {
                    value[j]=((char)s);
                    String valuee = "";
                    for (int p=0; p<6; p++) {
                        valuee += value[p];
                    }
                    addToTable(String.valueOf((char)i), valuee, String.valueOf(i*s));
//                    addToTable(" az", valuee, String.valueOf(i*s));
                }
            }
            System.out.println(i-96 + "/26");
        }
    }
    public static void main(String[] args)
    {
        try
        {
            connect();
//            int a = (int)'a';
//            int z = (int)'z';
//            System.out.println(a);
//            System.out.println(z);
//            uzupelnij();
//            long start = System.currentTimeMillis();
//            wypisz();
            ResultSet resultSet = stt.executeQuery("SELECT name FROM `glowneWezly`");
            resultSet.next();
            System.out.println(resultSet.getString("name"));
            resultSet.next();
            System.out.println(resultSet.getString("name"));
        }
        // 39146250
        // 4650
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
