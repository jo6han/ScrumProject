package se.team.webshop.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import se.team.webshop.model.Order;
import se.team.webshop.model.User;

public class InMemoryOrderRepository implements OrderRepository {
	
	private static int orderIdCounter = 0;	
	private Map<Integer, Order> orders = new LinkedHashMap<Integer, Order>();

	@Override
	public void addOrder(User user) {
		int orderId = getNextOrderId();
		orders.put(orderId, new Order(orderId, new User(user)));
	}

	@Override
	public Order getOrder(Integer idKey, User user) {
		return orders.get(idKey);
	}

	@Override
	public List<Order> getOrders() {
		List<Order> listOrders = new ArrayList<Order>(orders.values());		
		return listOrders;
	}

//	@Override
//	public String getOrders() {
//		StringBuilder stringBuilder = new StringBuilder();
//		for (Object key : orders.keySet()) {
//			stringBuilder.append("Order Id = ")
//					.append(users.get(key).getUserId()).append(" - ")
//					.append("User name = ").append(users.get(key).getName()).append(".")
//					.append("\n");
//		}
//		return stringBuilder.toString();
//	}
	
	@Override
	public void deleteOrder(Integer idKey, User user) {
		orders.remove(idKey);
	}

	private int getNextOrderId(){
		orderIdCounter++;
		return orderIdCounter;
	}
}