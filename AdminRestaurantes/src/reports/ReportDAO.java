package reports;

import Classes.BranchOffice;
import Classes.BranchOfficeDAO;
import Classes.DatabaseAdministration;
import Classes.Employee;
import Classes.EmployeeDAO;
import Classes.Product;
import Classes.ProductDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportDAO {
    public static Employee getMostValuableEmployee(){
        Employee employee = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT employeeID, SUM(amount) FROM tickets ORDER BY employeeID DESC LIMIT 1";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()){
                employee = EmployeeDAO.getEmployeeByID(rs.getInt("employeeID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
    
    public static Product getMostProductSold(){
        Product product = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT itemID, SUM(amount) FROM ticket_item ORDER BY itemID DESC LIMIT 1";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()){
                product = ProductDAO.getProductById(rs.getInt("itemID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
    
    public static BranchOffice getMostVisitedOffice(){
        BranchOffice office = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT branchID, SUM(ticketID) FROM tickets ORDER BY branchID DESC LIMIT 1";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()){
                office = BranchOfficeDAO.getBranchOfficeByID(rs.getInt("branchID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return office;
    }
    
    public static ResultSet earningsPerBranchOffice(){
        ResultSet earnings = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT branchID, SUM(amount) FROM tickets";
            earnings = connection.prepareStatement(sql).executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return earnings;
    }
}
