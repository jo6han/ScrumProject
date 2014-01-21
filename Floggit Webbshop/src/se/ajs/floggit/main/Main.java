package se.ajs.floggit.main;

import java.lang.Exception;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws SQLException {
//TESTING EGIT
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/floggit", "root", "");
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			
			//Method som får ut alla categories
			getCategories(connection, statement, resultset);

			connection.commit();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			connection.rollback();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {

				}
			}
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {

				}
			}
			
		}
	}
	public static void getCategories(Connection connection, Statement statement, ResultSet resultset) throws SQLException{
		resultset = statement.executeQuery("SELECT * FROM categories_responsible");

		while(resultset.next()){
			System.out.println("Category: " + resultset.getString("category"));
			System.out.println("Staff Repsonsible: " + resultset.getString("staff_responsible") + "\n");
		}
	}

}
