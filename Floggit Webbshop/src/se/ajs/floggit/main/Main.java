package se.ajs.floggit.main;

import java.lang.Exception;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws SQLException {
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
			if (preparedstatement != null) {
				try {
					preparedstatement.close();
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

//	public static void getCategory(Connection connection, PreparedStatement preparedstatement,  ResultSet resultset) throws SQLException {
//		preparedstatement = connection.prepareStatement("SELECT category, staff_responsible FROM categories_responsible");
//		resultset = preparedstatement.executeQuery();
//		
//		while (resultset.next()) {
//			System.out.println("Category: " + resultset.getString("category"));
//			System.out.println("Staff Repsonsible: " + resultset.getString("staff_responsible") + "\n");
//		}
//	}

}
