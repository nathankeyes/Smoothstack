package utopia.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import utopia.entity.Airport;
import utopia.service.AdminService;
import utopia.service.EmployeeService;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 example code from Pramod
 */

public class Driver {
	
	static Scanner scan = new Scanner(System.in);
	
	public void travelerFunc1() {
		
		
		
		return;
	}
	
	public void adminFunc1() {
		
		
		
		return;
	}
	
	public void employeeOption1(int userRoute) throws ClassNotFoundException, SQLException {
		Driver drive = new Driver();
		EmployeeService es = new EmployeeService();
		
		String response = null;
		
		response = es.flightInfo(userRoute);
		
		System.out.println("1) Press 1 to return to last menu");
		
		
		int userInput = readInput();
		
		if (userInput == 1) {							// return
			drive.employeeFunc3(userRoute);											
		}
		else {
			System.out.println("Incorrect Input, Try Again");
			drive.employeeOption1(userRoute);
		}
		
	}
	
	public void employeeFunc3(int userRoute) throws SQLException, ClassNotFoundException {
		Driver drive = new Driver();
		EmployeeService es = new EmployeeService();
		
		System.out.println("1) View more details about the flight\n" + "2) Update the details of the Flight\n" + "3) Add Seats to Flight\n" + "4) Quite to previous");
		
		int userInput = readInput();
		
		if (userInput == 1) {							// more details
			drive.employeeOption1(userRoute);											
		}
		else if (userInput == 2) {						// update details
			//drive.employee											
		}
		
		else if (userInput == 3) {						// add seats to flight
														
		}
		else if (userInput == 4) {
			drive.employeeFunc2();						// go back
		}
		else {
			System.out.println("Incorrect Input, Try Again");
			drive.employeeFunc3(userRoute);
		}
	}
	
	public void employeeFunc2() throws SQLException, ClassNotFoundException {
		Driver drive = new Driver();
		
		// Menu two operation ----------------------------------------
		EmployeeService es = new EmployeeService();
		
		int count = es.viewFlights();

		int userInput = readInput();
	
		
		if (userInput < count) {			// got to emp 3
			drive.employeeFunc3(userInput);
		}
		else if (userInput == count) {		// go back to emp1
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
		return scan.nextInt();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Driver drive = new Driver();
		
		drive.entryPoint();
		
		scan.close();
		
//		AdminService as = new AdminService();
//		String result = null;
//		result = as.readAirports();
	}
}
