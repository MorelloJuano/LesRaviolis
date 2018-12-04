package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    public static Client getClientById(int clientID){
        Client client = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM clients WHERE clientID = " + clientID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                client = new Client(
                        rs.getInt("clientID"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("document")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }
    
    public static Client getClientByDocument(int userDNI){
        Client client = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM clients WHERE document = " + userDNI;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                client = new Client(
                        rs.getInt("clientID"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("document")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }
}
