package AssignmentFour;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for Line
 * 				NOT WORKING
 * 				keep receiving ClassNotFoundException waiting to hear back from Pramod
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for Line.java
 */

public class LineTest {
	private Line line = new Line(1,4,2,5);
	private Line I = new Line(2,5,3,6);
	
	@Test
	public void testgetSlope() {
		//assertEquals(expected, actual)
		assertEquals(1.0, line.getSlope(), 0.001);
	}
	
	@Test
	public void testgetDistance() {
		Double result = Math.sqrt(2);
		
		assertEquals(result, line.getDistance(), 0.001);
		
	}
	
	@Test
	public void testparallelTo() {
		assertEquals(true, line.parallelTo(I));
	}

}
