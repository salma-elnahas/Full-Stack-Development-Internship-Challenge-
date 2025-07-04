// class for managing cart items in a shopping cart with its product and quantity
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    // Getters
    public Product getProduct() { return product; }

    public int getQuantity() { return quantity; }
    // method to calculate the total price of the cart item
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}