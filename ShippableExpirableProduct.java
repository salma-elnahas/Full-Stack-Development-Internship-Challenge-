// subclass of product that requires shipping and can be expired such as Cheese
public class ShippableExpirableProduct extends Product implements Shippable, Expirable {
    private double weight;
    private boolean expired;

    public ShippableExpirableProduct(String name, double price,int quantity, double weight, boolean expired) {
        super(name, price, quantity);
        this.weight = weight;
        this.expired = expired;
    }

     public String getName() { return super.getName();}

    
    public double getWeight() {return weight; }

    @Override
    public boolean isExpired() { return expired;}
}