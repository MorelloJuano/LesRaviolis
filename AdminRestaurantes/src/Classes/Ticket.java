package Classes;

import java.util.Date;
import java.util.List;

public class Ticket {
    private int ticketID;
    private Client client;
    private BranchOffice branchOffice;
    private Date ticketDate;
    private Employee waiter;
    private List<ProductRow> productList;

    public Ticket(int ticketID, Client client, BranchOffice branchOffice, Date ticketDate, Employee waiter, List<ProductRow> productList) {
        this.ticketID = ticketID;
        this.client = client;
        this.branchOffice = branchOffice;
        this.ticketDate = ticketDate;
        this.waiter = waiter;
        this.productList = productList;
    }
    
    

    public int getTicketID() {
        return ticketID;
    }

    public Client getClient() {
        return client;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public List<ProductRow> getProductList() {
        return productList;
    }
    
    public static void submitNewTicket(Ticket ticket){
        
    }
}
