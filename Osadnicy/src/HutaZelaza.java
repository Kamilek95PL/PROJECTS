import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 08.11.15.
 */
public class HutaZelaza implements Runnable {
    private int index, value=100;
    private void increaseZelazo() {
        String newZelazoValue = String.valueOf(getZelazo()+1);
        try {
            Main.stt3.execute("UPDATE uzytkownicy SET zelazo = " + newZelazoValue + " WHERE id = '0'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int getZelazo() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt3.executeQuery("SELECT zelazo FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("zelazo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int getPoziomHutyZelaza() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt3.executeQuery("SELECT hutaZelaza FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("hutaZelaza");
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
    HutaZelaza(int index) throws SQLException {
        this.index = index;
    }
    @Override
    public void run() {
        while (true) {
            sleep(getPoziomHutyZelaza());
            increaseZelazo();
        }
    }
}
