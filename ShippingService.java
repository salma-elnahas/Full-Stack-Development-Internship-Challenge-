import java.util.List;
// This class is responsible for sending the items in the cart and calculating the total weight of the package.
public class ShippingService {
    public void send(List<CartItem> items) {
        double totalWeight = 0;
        for (CartItem item : items) {
            // cast the product to Shippable to access its weight and name
            Shippable product = (Shippable) item.getProduct();
            System.out.println(item.getQuantity() + "x " + (product.getName() + "      " + (int) product.getWeight() * item.getQuantity() + "g"));
            totalWeight += product.getWeight() * item.getQuantity();
        }

        System.out.println("Total package weight " + (totalWeight / 1000.0) + "kg");
    }
    

    
    
}