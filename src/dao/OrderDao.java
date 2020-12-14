package dao;
	

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	
public class OrderDao {
		
	private Connection connection; 
	private final String GET_ORDERS_QUERY = "SELECT * FROM orders";	
	private final String CREATE_NEW_ORDER_QUERY = "INSERT INTO orders (name, flavor, scoops) VALUES (?,?,?)";
	private final String DELETE_ORDER_BY_ID_QUERY = "DELETE FROM orders WHERE id = ?";	
	private final String UPDATE_ORDER_BY_ID_QUERY = "UPDATE orders SET flavor = ? WHERE id = ?";
		
	public OrderDao () {	
		connection = DBConnection.getConnection();
			
	}
		
	public void showAllOrders() throws SQLException {	
		PreparedStatement ps = connection.prepareStatement(GET_ORDERS_QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "\tName: " + rs.getString(2) + "\tFlavor: " + rs.getString(3) + "\tHow many scoops?: " + rs.getInt(4));	
		}

	}
		
	public void createNewOrder(String name, String flavor, int scoops) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ORDER_QUERY);
		ps.setString(1, name);
		ps.setString(2, flavor);
		ps.setInt(3, scoops);
		ps.executeUpdate();
		}
		
	public void deleteOrderById(int orderId) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(DELETE_ORDER_BY_ID_QUERY);
		ps.setInt(1, orderId);
		ps.executeUpdate();
		}
	public void updateOrderById (int orderId, String flavor) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER_BY_ID_QUERY);
		ps.setString(1, flavor);
		ps.setInt(2, orderId);
		ps.executeUpdate();
		}

}
