package AssessmentOne;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for doubleInts.java		
 */

public class doubleIntsTest {
	private doubleInts DI = new doubleInts();
	
	private List<Integer> intList1   = new ArrayList<>();
	private List<Integer> intList2   = new ArrayList<>();
	private List<Integer> intList3   = new ArrayList<>();
	
	private List<Integer> finalList1 = new ArrayList<>();
	private List<Integer> finalList2 = new ArrayList<>();
	private List<Integer> finalList3 = new ArrayList<>();
	
	@Test
	// base test
	public void doublingResults1() {
		
		intList1.add(1);
		intList1.add(2);
		intList1.add(3);
		
		finalList1.add(2);
		finalList1.add(4);
		finalList1.add(6);
		
		assertEquals(finalList1, DI.doubling(intList1));	
	}
	
	@Test
	// add negative
	public void doublingResults2() {
		
		intList2.add(6);
		intList2.add(8);
		intList2.add(6);
		intList2.add(8);
		intList2.add(-1);
		
		finalList2.add(12);
		finalList2.add(16);
		finalList2.add(12);
		finalList2.add(16);
		finalList2.add(-2);
		
		assertEquals(finalList2, DI.doubling(intList2));	
	}
	
	@Test
	// add null
	public void doublingResults3() {
		
		intList2.add(null);
		
		finalList2.add(null);

		
		assertEquals(finalList3, DI.doubling(intList3));	
	}


}
