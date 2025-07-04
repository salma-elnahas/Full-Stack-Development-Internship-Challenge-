// subclass of product that can be shipped such as TV  
public class ShippableProduct extends Product implements Shippable {
    // weight of the product in kilograms
    private double weight;
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    public String getName() {
        return super.getName();
    }
}