package Classes;

public class Client {
    
    private String name;
    private String surname;
    private int dni;
    
    private int userIndex;

    public Client( int userIndex, String name, String surname, int dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.userIndex = userIndex;
    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDni() {
        return dni;
    }

    public int getUserIndex() {
        return userIndex;
    }
    
    public static Client newClientByID(int clientID){
        return ClientDAO.getClientById(clientID);
    }
    
    public static Client newClientByDNI(int document){
        return ClientDAO.getClientByDocument(document);
    }
}
