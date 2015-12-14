import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 08.11.15.
 */
public class Cegielnia implements Runnable {
    private int index, value=100;
    private void increaseGlina() {
        String newGlinaValue = String.valueOf(getGlina()+1);
        try {
            Main.stt.execute("UPDATE uzytkownicy SET glina = " + newGlinaValue + " WHERE id = '0'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int getGlina() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt.executeQuery("SELECT glina FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("glina");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int getPoziomCegielni() {
        ResultSet resultSet = null;
        try {
            resultSet = Main.stt.executeQuery("SELECT cegielnia FROM uzytkownicy WHERE id=" + Main.apo + index + Main.apo);
            resultSet.next();
            return resultSet.getInt("cegielnia");
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
    Cegielnia(int index) throws SQLException {
        this.index = index;
    }
    @Override
    public void run() {
        while (true) {
            sleep(getPoziomCegielni());
            increaseGlina();
        }
    }
}
