package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchOfficeDAO {
    public static BranchOffice getBranchOfficeByID(int branchID){
        BranchOffice branchOffice = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM branch WHERE branchID = " + branchID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                branchOffice = new BranchOffice(
                        rs.getInt("branchID"),
                        EmployeeDAO.getEmployeeByID(rs.getInt("managerID")),
                        rs.getString("address")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return branchOffice;
    }
    
    public static List<BranchOffice> branchList(){
        List<BranchOffice> branchList = new ArrayList<>();
        
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM branch";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()) {
                branchList.add(new BranchOffice(
                        rs.getInt("branchID"),
                        EmployeeDAO.getEmployeeByID(rs.getInt("managerID")),
                        rs.getString("address")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return branchList;
    }
    
    public static void insertNewBranchOffice(String address, String managerUsername) throws UsernameNotFoundException{
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "INSERT INTO branch (managerID, address) VALUES ((SELECT employeeID FROM employee WHERE username = ?), ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, managerUsername);
            stmt.setString(2, address);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
