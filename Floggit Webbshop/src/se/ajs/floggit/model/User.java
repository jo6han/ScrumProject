package se.ajs.floggit.model;

import se.ajs.floggit.tools.Cart;

public final class User {

	private final String userId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phoneNumber;

	private final ShoppingCart userCart;

	public User(String userId, String name, String password, String address,
			String email, String phoneNumber, ShoppingCart userCart) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userCart = new ShoppingCart(userCart);
	}

	public User(String userId, String name, String password, String address,
			String email, String phoneNumber) {
		this(userId, name, password, address, email, phoneNumber,
				new ShoppingCart());
	}

	public User(User other) {
		this(other.userId, other.name, other.password, other.address,
				other.email, other.phoneNumber);
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ShoppingCart getUserCart() {
		return userCart;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == this)
			return true;

		if (otherObject instanceof User) {
			User otherUser = (User) otherObject;
			// Check for user duplicates comparing the id's.
			boolean isSameClass = this.getClass().equals(otherUser.getClass());
			return (userId.equals(otherUser.userId) || name.equals(otherUser.name) || email.equals(otherUser.email)) && isSameClass;
		}
		return false;
	}

	@Override
	public int hashCode() {
		//int result = 1; To avoid the same user compare names and emails.
		//return result;
		return 37 * userId.hashCode();
	}

	@Override
	public String toString() {
		return String
				.format("User Id: %s, Name: %s, Password: %s, Address: %s, Email: %s, Phone: %s.",
						userId, name, password, address, email, phoneNumber);
	}
}