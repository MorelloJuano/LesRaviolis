package Classes;

public class ProductRow extends Product{
    private int amount;

    public ProductRow(int productID, String name, double price, int amount) {
        super(productID, name, price);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
