package WeekOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/10/21
 * @LastEdited  3/10/21
 * @Description Create hierarchy between iShape(interface), square, circle, triangle
 */

public interface iShape {

	public double calculateArea(double length, double height);
	
	public void display(double area);
	
}
