package se.team.webshop.model;

//import se.team.webshop.cart.ShoppingCart;

public class Order {
	private final int orderId;
	private final User user;
	//private final ShoppingCart cart;

	public Order(int orderId, User user) {
		this.orderId = orderId;
		this.user = user;
		//this.cart = cart;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public User getUser() {
		return user;
	}
	
//	public ShoppingCart getCart() {
//		return cart;
//	}
	@Override
	public String toString() {
		return String.format(
				"Order Id: %s, User: %s",orderId, user);
	}
}
