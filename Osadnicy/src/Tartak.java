import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 08.11.15.
 */
public class Tartak implements Runnable {
    private int index, value=100;
    private void increaseDrewno() {
        String newDrewnoValue = String.valueOf(getDrewno()+1);
        try {
            Main.stt2.execute("UPDATE uzytkownicy SET drewno = " + newDrewnoValue + " WHERE id = '0'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int getDrewno() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt2.executeQuery("SELECT drewno FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("drewno");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int getPoziomTartaku() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt2.executeQuery("SELECT tartak FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("tartak");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private void sleep(int poziom) {
        try {
            Thread.sleep(60000/poziom);
        } catch (ArithmeticException ee) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    Tartak(int index) throws SQLException {
        this.index = index;
    }
    @Override
    public void run() {
        while (true) {
            sleep(getPoziomTartaku());
            increaseDrewno();
        }
    }
}
