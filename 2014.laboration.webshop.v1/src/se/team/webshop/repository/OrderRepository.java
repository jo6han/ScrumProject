package se.team.webshop.repository;

import java.util.List;

import se.team.webshop.model.Order;
import se.team.webshop.model.User;

public interface OrderRepository
{
	
	public void addOrder(User userOrder);

    public Order getOrder(Integer idKey, User userOrder);

	public List<Order> getOrders();

	public void deleteOrder(Integer idKey, User removeOrder);
	
	// public void updateOrder(String idKey, Order order);
	
}
