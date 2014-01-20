package se.team.webshop.repository;

import se.team.webshop.model.Product;

public interface ProductRepository {
	
	public void addProduct(Product newProduct);

	public Product getProduct(String idKey);

	public String getProducts();

	public void deleteProduct(String idKey);

	public void updateProduct(String idKey, Product product);
	
}