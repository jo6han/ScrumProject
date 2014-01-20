package se.team.webshop.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import se.team.webshop.model.Product;

public class InMemoryProductRepository implements ProductRepository {
	private Map<String, Product> products = new LinkedHashMap<String, Product>();

	@Override
	public void addProduct(Product product) {
		if (!products.containsKey(product.getProductId())) {
			products.put(product.getProductId(), product);
		}
	}

	@Override
	public Product getProduct(String idKey) {
		return products.get(idKey);
	}

	@Override
	public String getProducts() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object key : products.keySet()) {
			stringBuilder.append("Product Id = ")
					.append(products.get(key).getProductId()).append(" - ")
					.append("Product name = ")
					.append(products.get(key).getName()).append(" - ")
					.append("Description = ")
					.append(products.get(key).getShortDescription())
					.append(" - ").append("Price = ")
					.append(products.get(key).getPrice()).append(" Kronor.")
					.append("\n");
		}
		return stringBuilder.toString();
	}

	@Override
	public void deleteProduct(String idKey) {
		products.remove(idKey);
	}

	@Override
	public void updateProduct(String idKey, Product product) {
		if (products.containsKey(idKey)) {
			products.put(idKey, product);
		}
	}
}
