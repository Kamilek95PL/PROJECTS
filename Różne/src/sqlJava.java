/**
 * Imports all entries from the java.sql library.
 * Improve on this by only importing needed classes.
 * E.g.:
 * import java.sql.Connection
 * import java.sql.Statement
 * ...
 */
import java.sql.*;

public class sqlJava
{
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
    }
    static void createDataBase(String nameDataBase) throws SQLException {
        stt.execute("CREATE DATABASE IF NOT EXISTS " + nameDataBase);
    }
    static void createTable(String nameTable) throws SQLException {
        stt.execute("DROP TABLE IF EXISTS " + nameTable);
        stt.execute("CREATE TABLE " + nameTable + " (" +
        "id BIGINT NOT NULL AUTO_INCREMENT,"
        + "fname VARCHAR(25),"
        + "lname VARCHAR(25),"
        + "PRIMARY KEY(id)"
        + ")");
    }
    static void addToTable() throws SQLException {
        stt.execute("INSERT INTO people (fname, lname) VALUES" +
        "('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");
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
        try
        {
            connect();

            stt.execute("USE Osadnicy");
            writeAllToConsole();
            increaseDrewno();
            writeAllToConsole();

            stt.close();
//            prep.close();
            con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}