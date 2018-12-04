package Classes;

public class Employee {
    private int employeeID;
    private int branchID;
    private String name;
    private String surname;
    private int document;
    private boolean isManager;
    private String username;
    private String password;
    private static Employee loggedEmployee;

    public Employee(int employeeID, int branchID, String name, String surname, int document, String username, String password) {
        this.employeeID = employeeID;
        this.branchID = branchID;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.username = username;
        this.password = password;
    }
    
    public Employee(int employeeID, int branchID, String name, String surname, int document) {
        this.employeeID = employeeID;
        this.branchID = branchID;
        this.name = name;
        this.surname = surname;
        this.document = document;
    }

    public Employee(int branchID, String name, String surname, int document) {
        this.branchID = branchID;
        this.name = name;
        this.surname = surname;
        this.document = document;
    }
    
    

    public int getEmployeeID() {
        return employeeID;
    }

    public int getBranchID() {
        return branchID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDocument() {
        return document;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Employee getLoggedEmployee() {
        return loggedEmployee;
    }

    public static void setLoggedEmployee(Employee loggedEmployee) {
        Employee.loggedEmployee = loggedEmployee;
    }
    
    public static Employee newEmployeeById(int id){
        return EmployeeDAO.getEmployeeByID(id);
    }
    
    public static Employee newEmployeeByDocument(int dni){
        return EmployeeDAO.getEmployeeByDocument(dni);
    }
}
