import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    // Example usage of the classes
       ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 100.0, 2, 400, false);
    ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150.0, 2, LocalDate.of(2025, 12, 31));

    Customer customer = new Customer("MixedUser", 1000.0);
    Cart cart = new Cart();
    cart.add(cheese, 2);
    cart.add(biscuits, 1);

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);
    }
}