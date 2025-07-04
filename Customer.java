// Customer class for managing customer details 
public class Customer {
    private Cart cart;
    private String name;
    private double balance;
 
    public Customer(String name, double balance) {
        this.cart = new Cart();
        this.name = name;
        this.balance = balance;
    }
    // Getters
    public Cart getCart() { return cart; }
    public String getName() { return name; }

    public double getBalance() { return balance; }

    // method to reduce the customer's balance after a purchase
    public void reduceBalance(double amount) {
        this.balance -= amount;
    }
}