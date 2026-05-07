package assignment_eight;
import java.util.*;
public class ShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        Map<String, Double> productPrice = new HashMap<>();
        productPrice.put("laptop", 50000.0);
        productPrice.put("Phone", 15000.0);
        productPrice.put("jeans", 1500.0);

    
        List<String> cart = new ArrayList<>();
        cart.add("laptop");
        cart.add("Phone");
        cart.add("Phone");

        double total = 0;

        System.out.println("cart items:");
        for (String item : cart) {
            double price = productPrice.get(item);
            System.out.println(item + " - " + price);
            total += price;
        }

        System.out.println("total: " + total);

	}

}
