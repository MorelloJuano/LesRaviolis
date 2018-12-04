package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {
    public static Product getProductById(int productID){
        Product product = null;
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM items WHERE itemID = " + productID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            if(rs.next()) {
                product = new Product(
                        rs.getInt("itemID"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return product;
    }
    
    public static List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM items";
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()) {
                productList.add(new Product(
                        rs.getInt("itemID"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productList;
    }
    
    public static List<Product> getProductListByTypeID(int typeID){
        List<Product> productList = new ArrayList<>();
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql = "SELECT * FROM items WHERE type = " + typeID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()) {
                productList.add(new Product(
                        rs.getInt("itemID"),
                        rs.getString("name"),
                        rs.getDouble("price")
                    )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productList;
    }
    
    public static List<ProductRow> getProductListByTicketID(int ticketID){
        List<ProductRow> productList  = new ArrayList<>();
        try{
            Connection connection = DatabaseAdministration.getConnection();
            String sql =    "SELECT	items.itemID, items.name, items.price, ticketItem.amount\n" +
                            "FROM	items AS items,\n" +
                            "           ticket_item AS ticketItem\n" +
                            "WHERE	ticketItem.itemID = items.itemID" +
                            "AND 	tickets.ticketID = ticketItem.ticketID" +
                            "AND        tickets.ticketID = " + ticketID;
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()) {
                productList.add(new ProductRow(
                        rs.getInt("itemID"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("amount")
                )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productList;
    }
    
    public static void insertNewProduct(Product product, int type){
        try{
            String sql = "INSERT INTO items (name, price, type) VALUES (?, ?, ?)";
            Connection connection = DatabaseAdministration.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, type);
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
