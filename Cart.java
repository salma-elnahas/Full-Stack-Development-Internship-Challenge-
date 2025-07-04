import java.util.ArrayList;

// Cart class for managing logic related to a shopping cart
public class Cart {
    // List to hold cart items
    private ArrayList<CartItem> items = new ArrayList<>();
    // Method to add a product to the cart with a specified quantity
    public void add(Product product, int quantity) {
        product.reduceQuantity(quantity);
        items.add(new CartItem(product, quantity));

    }

    public ArrayList<CartItem> getItems() { return items; }

    public Boolean isEmpty() {
        return items.isEmpty();
    }

     // method to get subtotal of products
     public double getSubtotal() {
        double subTotal = 0.0;
        // iterate through each cart item and calculate the total price
        for(CartItem item :items){
            subTotal += item.getTotalPrice();
        }
        return subTotal;
    }
    // method to get all shippable items in the cart
    public ArrayList<CartItem> getShippableCartItems() {
    ArrayList<CartItem> result = new ArrayList<>();
    for (CartItem item : items) {
        // Check if the product is shippable
        if (item.getProduct() instanceof Shippable) {
            result.add(item);
        }
    }
    return result;
}
}
 