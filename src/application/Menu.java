package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DBConnection;
import dao.OrderDao;

public class Menu {
	
	private Connection connection;
	
	public Menu() {
		connection = DBConnection.getConnection();
	}
	
	private Scanner scanner = new Scanner(System.in);
	private OrderDao orderDao = new OrderDao();
	
	private List<String> options = Arrays.asList(	
			"Create Order", // //create
			"Display Orders", //read
			"Delete Order", //delete
			"Update Order" // update
			);
	
	public void start() {
		String selection = "";
		
		do {	
			printMenu(); 
			selection = scanner.nextLine();	
			
			try {	
				if (selection.equals("1")) {	
					createOrder();	
				} else if (selection.equals("2")) {	
					showAllOrders();
				} else if (selection.equals("3")) {	
					deleteOrder();
				} else if (selection.equals("4")) {
					updateOrder();
			}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
		
		private void printMenu() {	
			System.out.println("Select an Option: \n--------------------------------");
			for (int i = 0; i < options.size(); i++ ) {
				System.out.println(i + 1 + ") " + options.get(i));
			}
		}
		
		private void showAllOrders() throws SQLException {
			orderDao.showAllOrders();
			}
			
			
		private void createOrder() throws SQLException {
			System.out.print("Enter new customer name: ");
			String name = scanner.nextLine();
			System.out.print("Enter desired flavor: ");
			String flavor = scanner.nextLine();
			System.out.print("Enter how many scoops: ");
			int scoops = Integer.parseInt(scanner.nextLine());
			orderDao.createNewOrder(name, flavor, scoops);	
		}
		
	
		private void deleteOrder() throws SQLException {
			System.out.print("Enter order id to delete:");
			int id = Integer.parseInt(scanner.nextLine());
			orderDao.deleteOrderById(id);
		}
		private void updateOrder() throws SQLException {
			System.out.print("Enter order id to update:  ");
			int orderId = Integer.parseInt(scanner.nextLine());
			System.out.print("Update desired flavor: ");
			String flavor = scanner.nextLine();
			orderDao.updateOrderById(orderId, flavor);
		}
		
	}
