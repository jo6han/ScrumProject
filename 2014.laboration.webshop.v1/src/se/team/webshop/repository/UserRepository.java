package se.team.webshop.repository;

import se.team.webshop.model.User;

public interface UserRepository {
	
	public void addUser(User newUser);

	public User getUser(String idKey);

	public String getUsers();

	public void deleteUser(String idKey);

	public void updateUser(String idKey, User user);
	
}