package se.ajs.floggit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Category extends Repository {

	
	public void create(Connection connection, PreparedStatement preparedstatement, String categoryName) throws SQLException {
		preparedstatement = connection.prepareStatement("INSERT INTO categories (category) VALUES(?)");
		preparedstatement.setString(1, categoryName);
		preparedstatement.executeUpdate();
	}

	
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

}
