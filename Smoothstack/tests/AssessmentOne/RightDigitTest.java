package AssessmentOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for Line.java		
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RightDigitTest {
	private RightDigit RD = new RightDigit();
	
	private List<Integer> intList1   = new ArrayList<>();
	private List<Integer> intList2   = new ArrayList<>();
	private List<Integer> intList3   = new ArrayList<>();
	
	private List<Integer> finalList1 = new ArrayList<>();
	private List<Integer> finalList2 = new ArrayList<>();
	private List<Integer> finalList3 = new ArrayList<>();
	
	
	@Test
	// base test
	public void rdResults1() {
		intList1.add(1);
		intList1.add(22);
		intList1.add(93);
		
		finalList1.add(1);
		finalList1.add(2);
		finalList1.add(3);
		
		assertEquals(finalList1, RD.rightDigit(intList1));	
	}
	
	@Test
	// more than 2 digits
	public void rdResults2() {	
		intList2.add(16);
		intList2.add(8);
		intList2.add(886);
		intList2.add(8);
		intList2.add(1);
		
		finalList2.add(6);
		finalList2.add(8);
		finalList2.add(6);
		finalList2.add(8);
		finalList2.add(1);
		
		assertEquals(finalList2, RD.rightDigit(intList2));	
	}
	
	@Test
	// zero handled the same
	public void rdResults3() {
		intList3.add(10);
		intList3.add(0);
		
		finalList3.add(0);
		finalList3.add(0);
		
		assertEquals(finalList3, RD.rightDigit(intList3));
	}
	
	@Test
	// zero handled the same
	public void rdResults4() {
		intList3.add(null);
		
		finalList3.add(null);
		
		assertEquals(finalList3, RD.rightDigit(intList3));
	}

}
