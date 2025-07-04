// This is the base class for all products in the system.
 public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name;}

    public double getPrice() { return price; }

    public int getQuantity() { return quantity;}
  // This method reduces the quantity of the product by the specified amount.
    public int reduceQuantity(int amount) {
        if (amount <= 0 || amount > quantity) {
        throw new RuntimeException(" Not enough stock for " + name + ". Requested: " + amount + ", Available: " + quantity);
    }
    quantity -= amount;
    return quantity;
    }
    

}

