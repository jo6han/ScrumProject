package se.team.webshop.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;

import se.team.webshop.model.Product;

public class ShoppingCart {

	private final List<Product> products;
	
	public ShoppingCart() {
		products = new ArrayList<Product>();
	}
	
	// To avoid pointing to the cart object ... cart copy
	public ShoppingCart(ShoppingCart products) {
		this();
		for (Product product : products.products) {
			this.products.add(new Product(product));
		}
	}
	 
	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}
	
	public void addProductToCart(Product product) {
		products.add(product);
	}
	
	public Map<Product, Integer> getProductsInCart() {
		Map<Product, Integer> productsInCart = new HashMap<Product, Integer>();
		for (Product product : getProducts()) {
			if (!productsInCart.containsKey(product))
				productsInCart.put(product, 0);
			productsInCart.put(product, productsInCart.get(product) + 1);
		}
		return productsInCart;
	}

	public void removeProductInCart(Product product) {
		products.remove(product);
	}
	
	public void clearCart() {
		products.clear();
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Iterator<Product> iterator = getProducts().iterator(); iterator.hasNext();) {
			Product product = iterator.next();
				totalPrice += ((Product) product).getPrice();
		}
		return totalPrice;
	}

	// Returns an empty map if products is null
    @Override
	public String toString()
	{
		return products == null ? "The cart is empty!!!" : products.toString();
	}
}
