package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/orders";	//8
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Disclosure1.";
	private static Connection connection;	//9b
	private static DBConnection instance;	//10b singleton pattern, allows us to only have 1 instance of DBConnection
	
	
	private DBConnection(Connection connection) { 	//9 constructor
		this.connection = connection;
	}
	
	public static Connection getConnection() {	//10 method
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
		return DBConnection.connection;
	}
}

