package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAdministration {
    public static Connection getConnection() {
        try {
            String driverStr = "jdbc:mysql://localhost/lesraviolis";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(driverStr, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
