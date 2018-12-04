package reports;

import Classes.BranchOffice;
import Classes.Employee;
import Classes.Product;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

public class handleReports {
    Employee mvp = ReportDAO.getMostValuableEmployee(); //Most Valuable Player :P
    Product mostSelled = ReportDAO.getMostProductSold();
    BranchOffice mostVisited = ReportDAO.getMostVisitedOffice();
    ResultSet earnings = ReportDAO.earningsPerBranchOffice();
    
    public void printReport() throws SQLException{
        String text = "Employee of the Week: " + mvp.getName() + System.lineSeparator()
                 + "Most consumed product: " + mostSelled.getName() + System.lineSeparator()
                 + "Most visited Branch Office: " + mostVisited.getAddress() + System.lineSeparator()
                 + "Branch office earnings: ";
        while(earnings.next()){
            text += System.lineSeparator() + earnings.getString(1) + "  >>>  " + earnings.getDouble(2);
        }
        
        try (PrintWriter output = new PrintWriter(new FileWriter(Date.from(Instant.now()).toString().replaceAll(":", "-") + ".txt"))) {
            output.println(text);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
