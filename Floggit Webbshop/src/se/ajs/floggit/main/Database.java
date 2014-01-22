package se.ajs.floggit.main;
import java.lang.Exception;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database {
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/floggit", "root", "");
		connection.setAutoCommit(false);
		
		Category category = new Category();
		
		//category.create(connection, preparedstatement, "L3C");
		connection.commit();

	}
	
	catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
		connection.rollback();
	}

}
