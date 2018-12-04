package Classes;

import java.util.List;

public class Product {
    private int productID;
    private String name;
    private double price;

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public static Product getProductById(int productID){
        return ProductDAO.getProductById(productID);
    }
    
    public static List<Product> getProductList(){
        return ProductDAO.getProductList();
    }
}
