// class for managing checkout operations 
public class CheckoutService {

     public void checkout(Customer customer, Cart cart) {
        // Check if the cart is empty
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart is empty. Cannot checkout.");
        }
        for (CartItem item : cart.getItems()) {
            // Check if the product is expired 
            if (item.getProduct() instanceof Expirable) {
                Expirable expItem = (Expirable) item.getProduct();
                if (expItem.isExpired()) {
                    throw new RuntimeException("Product expired: " + item.getProduct().getName());
                }
            }
        }
        // Calculate subtotal and shipping fee
        double subtotal = cart.getSubtotal();

        double totalWeight = 0.0;
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                // Convert from grams to kilograms
                totalWeight += (shippable.getWeight() / 1000.0) * item.getQuantity();
            }
        }
        // assuming shipping is 27.27 EGP per kg
        double shippingFee = totalWeight * 27.27;
        double totalAmount = subtotal + shippingFee;
        // check if the customer has enough balance
        if (totalAmount > customer.getBalance()) {
            throw new RuntimeException("Insufficient balance to complete checkout. Total: " + totalAmount
                    + ", Balance: " + customer.getBalance());
        }
        // Deduct the total amount from the customer's balance and reduce product quantities
        customer.reduceBalance(totalAmount);

        // Print shipment notice and checkout receipt
        System.out.println("** Shipment notice **");
        // Print shipping items and their weights
        if (!cart.getShippableCartItems().isEmpty()) {
            ShippingService shippingService = new ShippingService();
            shippingService.send(cart.getShippableCartItems());
            }
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "    "
                    + (int) item.getTotalPrice() + " EGP");
            }
             // print formatted receipt
            System.out.println("----------------------");
            System.out.printf("Total Amount: %.0f EGP\n", subtotal);
            System.out.printf("Shipping Fee: %.0f EGP\n", shippingFee);
            System.out.printf("Total Amount: %.0f EGP\n", totalAmount);




    }
}