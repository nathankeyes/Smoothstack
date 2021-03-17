package AssessmentOne;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for RecursionPrac.java		
 */

public class RecursionPracTest {
	
	RecursionPrac RPobj = new RecursionPrac();

	@Test
	// base test (use two variables for addition)
	public void RPResults1() {
		int index = 0;
		Integer target = 10;
		int[] intArr =  new int[] {2, 4, 8};
		
		assertEquals(true, RPobj.groupSumClump(index, intArr, target));	
	}
	
	@Test
	// need more than two variables for addition
	public void RPResults2() {
		int index = 0;
		Integer target = 14;
		int[] intArr2 =  new int[] {1, 2, 4, 8, 1};
		
		assertEquals(true, RPobj.groupSumClump(index, intArr2, target));	
	}
	
	@Test
	// check if combining sequential integers
	public void RPResults3() {
		int index = 0;
		Integer target = 14;
		int[] intArr3 =  new int[] {2,4,4,8};
		
		assertEquals(false, RPobj.groupSumClump(index, intArr3, target));	
	}
	
	@Test
	// check if combining sequential integers
	public void RPResults4() {
		int index = 0;
		Integer target = 3;
		int[] intArr4 = new int[] {1, 2, 2, 2, 5, 2};
		
		assertEquals(true, RPobj.groupSumClump(index, intArr4, target));	
	}
	
	@Test
	// check if combining sequential integers
	public void RPResults5() {
		int index = 0;
		Integer target = 7;
		int[] intArr5 = new int[] {1, 2, 2, 2, 2, 5};
		
		assertEquals(false, RPobj.groupSumClump(index, intArr5, target));	
	}
	

}
