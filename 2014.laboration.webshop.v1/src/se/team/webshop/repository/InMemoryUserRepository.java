package se.team.webshop.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import se.team.webshop.model.User;

public class InMemoryUserRepository implements UserRepository {
	private Map<String, User> users = new LinkedHashMap<String, User>();

	@Override
	public void addUser(User user) {
		if (!users.containsKey(user.getUserId())) {
			users.put(user.getUserId(), user);
		}
		users.put(user.getUserId(), user);
	}

	@Override
	public User getUser(String idkey) {
		return users.get(idkey);
	}

	@Override
	public String getUsers() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object key : users.keySet()) {
			stringBuilder.append("User Id = ")
					.append(users.get(key).getUserId()).append(" - ")
					.append("User name = ").append(users.get(key).getName()).append(".")
					.append("\n");
		}
		return stringBuilder.toString();
	}

	@Override
	public void deleteUser(String idKey) {
		if (users.containsKey(idKey)) {
			users.remove(idKey);
		}
	}

	@Override
	public void updateUser(String idKey, User user) {
		if (users.containsKey(idKey)) {
			users.put(idKey, user);
		}
	}
}
