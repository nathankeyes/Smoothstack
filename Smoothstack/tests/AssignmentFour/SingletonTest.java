package AssignmentFour;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description Junit tests for Simpleton double lock
 */

//assertEquals(expected, actual)

public class SingletonTest {
	
	private SingletonDouble SD = new SingletonDouble();
	volatile public static SingletonDouble instance = new SingletonDouble();
	
	@Test
	public void testgetInstance() {
		
		//expected return is a 
		assertEquals(instance ,SD.getInstance());
	}
	

}
