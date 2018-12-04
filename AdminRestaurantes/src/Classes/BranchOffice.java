package Classes;

public class BranchOffice {
    private int branchID;
    private Employee manager;
    private String address;

    public BranchOffice(int branchID, Employee manager, String address) {
        this.branchID = branchID;
        this.manager = manager;
        this.address = address;
    }

    public BranchOffice(String address) {
        this.address = address;
    }
    
    public int getBranchID() {
        return branchID;
    }

    public Employee getManager() {
        return manager;
    }

    public String getAddress() {
        return address;
    }
    
    public static BranchOffice newBranch(int branchID){
        return BranchOfficeDAO.getBranchOfficeByID(branchID);
    }
}
