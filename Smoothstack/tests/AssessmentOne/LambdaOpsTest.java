package AssessmentOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/15/21
 * @LastEdited  3/15/21
 * @Description Assessment 1 Junit tests for LambdaOps.java

 * 
 */


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdaOpsTest {
	
	LambdaOps LO = new LambdaOps();
	
	@Test
	// base test (use two variables for addition)
	public void LOResults1() {
		int index = 0;
		Integer target = 10;
		int[] intArr =  new int[] {2, 4, 8};
		
		assertEquals(true, LO.isOdd());	
	}

}
