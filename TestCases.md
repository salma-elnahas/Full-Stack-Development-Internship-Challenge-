Test case 1 :
ShippableProduct cheese = new ShippableProduct("Cheese", 100.0, 4, 200);
        ShippableProduct biscuits = new ShippableProduct("Biscuits", 150.0, 2, 700);

        Customer customer = new Customer("Ahmed", 500.0);
        Cart cart = new Cart();
        cart.add(cheese, 2);

        cart.add(biscuits, 1);

         CheckoutService receipt = new CheckoutService();
        receipt.checkout(customer, cart);

** Shipment notice **
2x Cheese      400g
1x Biscuits      700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese    200 EGP
1x Biscuits    150 EGP
----------------------
Total Amount: 350 EGP
Shipping Fee: 30 EGP
Total Amount: 380 EGP


-----------------------------------
Test Case 2 :
 ExpirableProduct expiredCheese = new ExpirableProduct("Cheese", 200.0, 1, LocalDate.of(2022, 1, 1));

    Customer customer = new Customer("Mona", 1000.0);
    Cart cart = new Cart();
    cart.add(expiredCheese, 1);

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);

CONSOLE OUTPUT:
 Exception in thread "main" java.lang.RuntimeException: Product expired: Cheese

----------------------------------
Test Case 3 :
 ShippableProduct tv = new ShippableProduct("TV", 1500.0, 1, 2000);

    Customer customer = new Customer("Sara", 100.0);  
    Cart cart = new Cart();
    cart.add(tv, 1);

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);

CONSOLE OUTPUT:
 Exception in thread "main" java.lang.RuntimeException: Insufficient balance to complete checkout. Total: 1554.54, Balance: 
100.0

----------------------------------
Test Case 4 :

 Customer customer = new Customer("EmptyCartUser", 5000.0);
    Cart cart = new Cart(); // Empty

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);

CONSOLE OUTPUT:
Exception in thread "main" java.lang.RuntimeException: Cart is empty. Cannot checkout.

Test Case 5 :
 ShippableProduct mobile = new ShippableProduct("Mobile", 5000.0, 2, 300);  

    Customer customer = new Customer("Ali", 10000.0);
    Cart cart = new Cart();
    cart.add(mobile, 3);  

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);
    
CONSOLE OUTPUT:
Exception in thread "main" java.lang.RuntimeException: ? Not enough stock for Mobile. Requested: 3, Available: 2

Test Case 6 :
    ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 100.0, 2, 400, false);
    ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150.0, 2, LocalDate.of(2025, 12, 31));

    Customer customer = new Customer("MixedUser", 1000.0);
    Cart cart = new Cart();
    cart.add(cheese, 2);
    cart.add(biscuits, 1);

    CheckoutService receipt = new CheckoutService();
    receipt.checkout(customer, cart);
CONSOLE OUTPUT:
** Shipment notice **
2x Cheese      800g
Total package weight 0.8kg

** Checkout receipt **
2x Cheese    200 EGP
1x Biscuits    150 EGP
----------------------
Total Amount: 350 EGP
Shipping Fee: 22 EGP
Total Amount: 372 EGP

Test Case 4 :
CONSOLE OUTPUT:

