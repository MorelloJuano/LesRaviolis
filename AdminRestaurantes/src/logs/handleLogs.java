package logs;

import Classes.Ticket;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class handleLogs {
    public static final String logsFile = "logs.juano";
    
    public static void insertNewLog(double amount){
        String text = "\n" + Date.from(Instant.now()).toString() + " :: " + amount;
        
        try (PrintWriter output = new PrintWriter(new FileWriter(logsFile, true))) {
            output.println(text);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
