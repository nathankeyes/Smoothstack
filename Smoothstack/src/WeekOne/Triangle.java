package WeekOne;

import java.util.Scanner;

public class Triangle implements iShape{
	
	public double calculateArea(double length, double height) {	
		return ((length * height) / 2);
	}
	
	public void display(double area) {
		System.out.print("area of Triangle: " + area);
		return;
	}

	public static void main(String[] args) {
		double length = 0, height = 0;
		
		Triangle obj = new Triangle();
		
		// ----- make sure user input is correct -----
		try ( Scanner scan = new Scanner(System.in )){
			for ( int i = 0; i < 2; i++ ) {
				if ( i == 0 )
					System.out.print("Please enter a value for length: ");
				else
					System.out.print("Please enter a value for width: ");
				
				
				if ( scan.hasNextDouble() && i == 0 )
					length = scan.nextDouble();
				else if ( scan.hasNextDouble() && i == 1)
					height = scan.nextDouble();
				else if ( scan.nextDouble() < 0 ) {
					System.out.println("Sorry, can't have negative lengths, try again");
					scan.nextLine();	
					i--;
					continue;
				}
				else
				{
					System.out.println("Sorry, thats not a number, try again");
					scan.nextLine();	
					i--;
					continue;
				}
			}
		}
		
		obj.display(obj.calculateArea(length, height));
		
		return;
	}

}
