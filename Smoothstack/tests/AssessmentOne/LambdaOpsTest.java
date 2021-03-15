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
	//PerformOperation returnValue = null;
	
	
	@Test
	// base test (use two variables for addition)
	public void LOResultsOdd1() {
		assertEquals(false, LO.poToBoolean(LO.isOdd(), 4));	
	}
	@Test
	// base test (use two variables for addition)
	public void LOResultsOdd2() {
		assertEquals(true, LO.poToBoolean(LO.isOdd(), 3));	
	}
	
	@Test
	// base test (use two variables for addition)
	public void LOResultsPrime1() {
		assertEquals(true, LO.poToBoolean(LO.isPrime(), 5));	
	}
	
	@Test
	// base test (use two variables for addition)
	public void LOResultsPrime2() {
		assertEquals(false, LO.poToBoolean(LO.isPrime(), 12));	
	}
	
	@Test
	// base test (use two variables for addition)
	public void LOResultsPalindrome1() {
		assertEquals(true, LO.poToBoolean(LO.isPalindrome(), 898));	
	}
	
	@Test
	// base test (use two variables for addition)
	public void LOResultsPalindrome2() {
		assertEquals(false, LO.poToBoolean(LO.isPalindrome(), 12));	
	}
	



}
