import Models.*;
import Models.SpecialProducts.ShippableExpirableProduct;
import Models.SpecialProducts.ShippableProduct;
import Services.*;

public class Main {
    public static void main(String[] args) {
        //Design idea : some products may expire and some not as well as for shipment so i created interfaces for each for
        //separation of concerns and created special models taking all properties of general product as well as its special interface properties
        //Error handling: Try catch for centralized and easier error handling through the app
//////////////////////////
        //Test 1 (valid)

        System.out.println("Test 1");
       try{
           ShippableExpirableProduct cheese = new ShippableExpirableProduct
                   ("Cheese", 200, 10, 400, System.currentTimeMillis() + 86400000); // 1 day expiration
           ShippableProduct tv = new ShippableProduct("TV", 1500, 5, 8000); // No expiration
           Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
           // Create a customer
           Customer customer = new Customer("Mustafa", 2000.0);
           // Create a cart and add products
           Cart cart = new Cart();
           cart.add(cheese, 2);
           cart.add(tv, 1);
           cart.add(scratchCard, 1);

           // Perform checkout
           CheckoutService checkoutService = new CheckoutService();
           checkoutService.checkout(customer, cart);

       }
       catch (Exception ex)
       {
        System.out.println(ex.getMessage());
       }
       /////////////////////////////
        //Test 2 (valid)

        System.out.println("Test 2");
        try{
            ShippableExpirableProduct cheese = new ShippableExpirableProduct
                    ("Cheese", 100, 10, 400, System.currentTimeMillis() + 86400000); // 1 day expiration
            ShippableProduct tv = new ShippableProduct("TV", 1000, 5, 8000); // No expiration
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 10000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 3);
            cart.add(tv, 4);
            cart.add(scratchCard, 2);

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////
        /////////////////////////////
        //Test 3 ( No Shippable products: valid)
        System.out.println("Test 3");
        try{

            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 10000.0);
            // Create a cart and add products
            Cart cart = new Cart();

            cart.add(scratchCard, 2);

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
/////////////////////////////////////////
        //Test 4 (Insufficient stock:Not valid)
        System.out.println("Test 4");
        try{
            ShippableExpirableProduct cheese = new ShippableExpirableProduct
                    ("Cheese", 200, 10, 400, System.currentTimeMillis() + 86400000); // 1 day expiration
            ShippableProduct tv = new ShippableProduct("TV", 1500, 5, 8000); // No expiration
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 11);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);
            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        ///////////////////////////////////
        //Test 5 (Empty Cart:Not valid)
        System.out.println("Test 5");
        try{
            ShippableExpirableProduct cheese = new ShippableExpirableProduct
                    ("Cheese", 200, 10, 400, System.currentTimeMillis() + 86400000); // 1 day expiration
            ShippableProduct tv = new ShippableProduct("TV", 1500, 5, 8000); // No expiration
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //Test 6 ( Insufficient Balance:Invalid)

        System.out.println("Test 5");
        try{
            ShippableExpirableProduct cheese = new ShippableExpirableProduct
                    ("Cheese", 200, 10, 400, System.currentTimeMillis() + 86400000); // 1 day expiration
            ShippableProduct tv = new ShippableProduct("TV", 1500, 5, 8000); // No expiration
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 1999.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        //Test 7 ( Expired:Invalid)

        System.out.println("Test 6");
        try{
            ShippableExpirableProduct cheese = new ShippableExpirableProduct
                    ("Cheese", 200, 10, 400, System.currentTimeMillis() - 86400000); // 1 day expiration
            ShippableProduct tv = new ShippableProduct("TV", 1500, 5, 8000); // No expiration
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20); // No expiration and No weight
            // Create a customer
            Customer customer = new Customer("Mustafa", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }


    }
}
