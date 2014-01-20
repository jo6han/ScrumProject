package se.team.webshop.service;

import java.util.List;

import se.team.webshop.model.User;
import se.team.webshop.model.Product;
import se.team.webshop.model.Order;
import se.team.webshop.repository.UserRepository;
import se.team.webshop.repository.ProductRepository;
import se.team.webshop.repository.OrderRepository;

public final class ECommerceService {
	private UserRepository userRepository;
	private ProductRepository productRepository;
	private OrderRepository orderRepository;

	public ECommerceService(UserRepository userRepository,
			ProductRepository productRepository, OrderRepository orderRepository) {
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}

	// -----------------------------------------------

	public void addUser(User user) {
		userRepository.addUser(user);
	}

	public User getUser(String idKey) {
		return userRepository.getUser(idKey);
	}

	public String getUsers() {
		return userRepository.getUsers();
	}

	public void deleteUser(String idKey) {
		userRepository.deleteUser(idKey);
	}

	public void updateUser(String idKey, User user) {
		userRepository.updateUser(idKey, user);
	}

	// -----------------------------------------------

	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	public Product getProduct(String idKey) {
		return productRepository.getProduct(idKey);
	}

	public String getProducts() {
		return productRepository.getProducts();
	}

	public void deleteProduct(String idKey) {
		productRepository.deleteProduct(idKey);
	}

	public void updateProduct(String idKey, Product product) {
		productRepository.updateProduct(idKey, product);
	}

	// -----------------------------------------------

	public void addOrder(User user) {
		orderRepository.addOrder(user);
		user.getUserCart().clearCart();
	}

	public Order getOrder(Integer idKey, User user) {
		return orderRepository.getOrder(idKey, user);
	}

	public List<Order> getOrders() {
		return orderRepository.getOrders();
	}

	public void deleteOrder(Integer idKey, User user) {
		orderRepository.deleteOrder(idKey, user);
	}
	
//	public void updateOrder(Integer idKey, User user) {
//		orderRepository.updateOrder(idKey, user);
//	}
}
