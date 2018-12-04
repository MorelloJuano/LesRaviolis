package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {
    public static Employee getEmployeeByID(int employeeID){
        Employee employee = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM employee WHERE employeeID = " + employeeID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                employee = new Employee(
                        rs.getInt("employeeID"),
                        rs.getInt("branchID"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("document")
                );
                employee.setIsManager(EmployeeDAO.isManagerByID(employee.getEmployeeID()));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }
    
    public static Employee getEmployeeByDocument(int employeeDNI){
        Employee employee = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM employee WHERE document = " + employeeDNI;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                employee = new Employee(
                        rs.getInt("employeeID"),
                        rs.getInt("branchID"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("document")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }
    
    public static Employee handleEmployeeLoginData(String username){
        Employee employee = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM employee WHERE username = '" + username + "'";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                employee = new Employee(
                        rs.getInt("employeeID"),
                        rs.getInt("branchID"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("document"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }
    
    public static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM employee";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()) {
                employeeList.add(new Employee(
                    rs.getInt("employeeID"),
                    rs.getInt("branchID"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("document")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }   
    
    public static boolean isManagerByID(int index){
        boolean isManager= false;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT br.managerID FROM branch AS br, employee AS em WHERE br.managerID = em.employeeID AND em.employeeID = '" + index + "'";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                isManager = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isManager;
    }
    
    public static void updateManagement(Employee employee, BranchOffice office){
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "UPDATE branch SET managerID = ? WHERE branchID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(0, employee.getEmployeeID());
            stmt.setInt(1, office.getBranchID());
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateOffice(Employee employee, BranchOffice office){
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "UPDATE employee SET branchID = ? WHERE employeeID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(0, office.getBranchID());
            stmt.setInt(1, employee.getEmployeeID());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void insertNewUser(Employee employee){
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "INSERT INTO employee (branchID, name, surname, document, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, employee.getBranchID());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getSurname());
            stmt.setInt(4, employee.getDocument());
            stmt.setString(5, employee.getName() + "." + employee.getSurname());
            stmt.setString(6, "testeo123");
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
