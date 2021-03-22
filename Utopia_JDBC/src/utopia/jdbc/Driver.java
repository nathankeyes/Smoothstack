package utopia.jdbc;

import java.sql.SQLException;
import java.util.Scanner;


import utopia.service.AdminService;
import utopia.service.EmployeeService;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 example code from Pramod
 */

public class Driver {
	
	public void travelerFunc1() {
		
		
		
		return;
	}
	
	public void adminFunc1() {
		
		
		
		return;
	}
	
	public void employeeFunc2() throws SQLException, ClassNotFoundException {
		Driver drive = new Driver();
		

		// Menu two operation ----------------------------------------
		EmployeeService es = new EmployeeService();
		String result = null;
		
		result = es.viewFlights();



		// -----------------------------------------------------------
		int userInput = readInput();

		// won't be 1, will be a count variable for how many flights there are, count+1 is option for going back
		if (userInput == 1) {			//
			drive.employeeFunc2();
		}
		else if (userInput == 2) {		// 
			drive.employeeFunc1();
		}
		else {
			System.out.println("Incorrect Input, Try Again");
			drive.employeeFunc2();
		}
		
		return;
	}
	
	public void employeeFunc1() throws SQLException, ClassNotFoundException {
		
		Driver drive = new Driver();
		
		System.out.println("1) Enter Flights To Manage\n2) Quit to Previous");
			
		int userRole = readInput();
		
		if (userRole == 1) {			// go to View Flights
			drive.employeeFunc2();
		}
		else if (userRole == 2) {		// Go back to entry
			drive.entryPoint();
		}
		else {
			System.out.println("Incorrect input for role try again");
			drive.entryPoint();
		}
		
		return;
	}
	
	
	public void entryPoint() throws SQLException, ClassNotFoundException {
		Driver drive = new Driver();
		
		System.out.println("Welcome to the Utopia Airlines Management System. Which Category of a user are you (Input integer for role)");
		System.out.println("1) Employee\n2) Administrator\n3) Traveler");
			
		int userRole = readInput();
		
		if (userRole == 1) {			//Employee
			drive.employeeFunc1();
		}
		else if (userRole == 2) {		// Admin
			drive.adminFunc1();
		}
		else if (userRole == 3) {		// Traveler
			drive.travelerFunc1();
		}
		else {
			System.out.println("Incorrect input for role try again");
			drive.entryPoint();
		}
		
		return;
	}
	
	public int readInput() {	
		try (Scanner scan = new Scanner(System.in)) {
			return scan.nextInt();
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Driver drive = new Driver();
		
		drive.entryPoint();
		
//		AdminService as = new AdminService();
//		String result = null;
//		result = as.readAirports();
	}
}
