/**
 * Imports all entries from the java.sql library.
 * Improve on this by only importing needed classes.
 * E.g.:
 * import java.sql.Connection
 * import java.sql.Statement
 * ...
 */
import java.sql.*;

public class Main
{
    static Statement stt, stt2, stt3;
    static Connection con;
    static String apo = "'";
    static void connect() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, user, password);
        stt = con.createStatement();
        stt2 = con.createStatement();
        stt3 = con.createStatement();

    }
    static int getDrewnoByNameInt(String imie) throws SQLException {
        ResultSet resultSet = stt.executeQuery("SELECT drewno FROM uzytkownicy WHERE user=" + apo + imie + apo);
        resultSet.next();
        return resultSet.getInt("drewno");
    }
    static String getDrewnoByNameString(String imie) throws SQLException {
        ResultSet resultSet = stt.executeQuery("SELECT drewno FROM uzytkownicy WHERE user=" + apo + imie + apo);
        resultSet.next();
        return String.valueOf(resultSet.getInt("drewno"));
    }
    static ResultSet getOneByName(String imie) throws SQLException {
        return stt.executeQuery("SELECT * FROM uzytkownicy WHERE user=" + apo + imie + apo);
    }
    static ResultSet getAll() throws SQLException {
        return stt.executeQuery("SELECT * FROM uzytkownicy");
//            PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
//            prep.setString(1, "Bloggs");
//
//            res = prep.executeQuery();
//            while (res.next())
//            {
//                System.out.println(res.getString("fname") + " " + res.getString("lname"));
//            }
    }
    static void writeAllToConsole() throws SQLException {
        ResultSet resultSet = getAll();
        while (resultSet.next())
        {
            System.out.println(resultSet.getString("user") + " " + resultSet.getString("drewno"));
        }
        System.out.println("");
        resultSet.close();
    }
    static void writeOneByName(String imie) throws SQLException {
        ResultSet resultSet = getOneByName(imie);
        while (resultSet.next())
        {
            System.out.println(resultSet.getString("user") + " " + resultSet.getString("drewno"));
        }
        System.out.println("");
        resultSet.close();
    }
    static void increaseDrewno() throws SQLException {
        String newDrewnoValue = String.valueOf(getDrewnoByNameInt("kamil")+1);
        stt.execute("UPDATE uzytkownicy SET drewno = " + newDrewnoValue + " WHERE user = 'kamil'");
    }
    public static void main(String[] args)
    {
        try {
            connect();
            stt.execute("USE Osadnicy");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            Cegielnia zero = new Cegielnia(0);
            Thread thread1 = new Thread(zero);
            thread1.start();
            Tartak one = new Tartak(0);
            Thread thread2 = new Thread(one);
            thread2.start();
            HutaZelaza two = new HutaZelaza(0);
            Thread thread3 = new Thread(two);
            thread3.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        while (true) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("*");
//        }
//        try
//        {
//            connect();
//
//            stt.execute("USE Osadnicy");
//            writeAllToConsole();
//            increaseDrewno();
//            writeAllToConsole();
//
//            stt.close();
////            prep.close();
//            con.close();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}