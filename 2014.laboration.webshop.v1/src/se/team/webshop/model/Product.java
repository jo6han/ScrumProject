package se.team.webshop.model;

public final class Product {

	private final String productId;
	private final String name;
	private final String shortDescription;
	private final double price;

	public Product(String productId, String name, String shortDescription,
			double price) {

		this.productId = productId;
		this.name = name;
		this.shortDescription = shortDescription;
		this.price = price;
	}

	public Product(Product product) {
		this(product.productId, product.name, product.shortDescription,
				product.price);
	}

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == this)
			return true;

		if (otherObject instanceof Product) {
			Product otherProduct = (Product) otherObject;
			// Check for product duplicates comparing the id's or names.
			boolean isSameClass = this.getClass().equals(
					otherProduct.getClass());
			return (productId.equals(otherProduct.productId)) && isSameClass;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 37 * productId.hashCode();
	}

	@Override
	public String toString() {
		return String.format(
				"Product Id: %s, Name: %s, Short description: %s, price: %s.",
				productId, name, shortDescription, price);
	}
}
