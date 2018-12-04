package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;

public class TicketDAO {
    public static Ticket getTicketById(int ticketID){
        Ticket ticket = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM tickets WHERE ticketID = " + ticketID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                ticket = new Ticket(
                        rs.getInt("ticketID"),
                        ClientDAO.getClientById(rs.getInt("clientID")),
                        BranchOfficeDAO.getBranchOfficeByID(rs.getInt("branchID")),
                        rs.getDate("ticketDate"),
                        EmployeeDAO.getEmployeeByID(rs.getInt("employeeID")),
                        ProductDAO.getProductListByTicketID(rs.getInt("ticketID"))
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ticket;
    }
    
    public static int getNewTicketID(){
        int nextTicketID = 1;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT ticketID from tickets order by ticketID DESC LIMIT 1";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                nextTicketID += rs.getInt("ticketID");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nextTicketID;
    }
    
    public static void insertNewTicket(Ticket ticket, Employee employee, double amount){
        try{
            int ticketID = TicketDAO.getNewTicketID(); //Returns the index number that the future insert will use
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "INSERT INTO tickets (clientID, branchID, ticketDate, employeeID, amount) VALUES (?,?,NOW(),?,?);";
            
            for(ProductRow product : ticket.getProductList()){
                String sql2 = "INSERT INTO ticket_item (ticketID, itemID, amount) VALUES (?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql2);
                stmt.setInt(1, ticketID);
                stmt.setInt(2, product.getProductID());
                stmt.setInt(3, product.getAmount());
                stmt.executeUpdate();
            }
            
            java.util.Date utilStartDate = Date.from(Instant.now());
            java.sql.Date sqlDate = new java.sql.Date(utilStartDate.getTime());
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, Employee.getLoggedEmployee().getBranchID());
            //stmt.setDate(3, sqlDate);
            stmt.setInt(3, Employee.getLoggedEmployee().getEmployeeID());
            stmt.setDouble(4, amount);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
