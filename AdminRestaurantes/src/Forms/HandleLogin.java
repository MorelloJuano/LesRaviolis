package Forms;

import Classes.Employee;
import Classes.EmployeeDAO;

public class HandleLogin {
    private String username;
    private String password;

    public HandleLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Employee doLogin() throws EmployeeWrongPasswordException, EmployeeDoesntExistException{
        Employee employeeToCheck = EmployeeDAO.handleEmployeeLoginData(username);
        
        if(employeeToCheck  == null){ //Employee with selected username doesn't exist in DB
            throw new EmployeeDoesntExistException();
        } else{
            if(!(employeeToCheck.getPassword().equals(this.password))){ //User password input is not equal to the one retrieved from the database
                throw new EmployeeWrongPasswordException();
            } else{
                Employee.setLoggedEmployee(EmployeeDAO.getEmployeeByID(employeeToCheck.getEmployeeID()));
                return Employee.getLoggedEmployee(); //We return another employee with the same ID, but without their username & password to prevent data leaks
            }
        }
    }
}

class EmployeeDoesntExistException extends Exception{
    @Override
    public String getMessage() {
        return "El usuario ingresado no corresponde con ningún empleado del sistema";
    }
}

class EmployeeWrongPasswordException extends Exception{
    @Override
    public String getMessage() {
        return "La contraseña ingresada no corresponde con la contraseña almacenada para el usuario ingresado";
    }
}