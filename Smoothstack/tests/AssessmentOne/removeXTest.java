package AssessmentOne;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description JUnit test for removeX.java		
 */

public class removeXTest {
	private removeX rx = new removeX();
	
	private List<String> intList1   = new ArrayList<>();
	private List<String> intList2   = new ArrayList<>();
	private List<String> intList3   = new ArrayList<>();
	
	private List<String> finalList1 = new ArrayList<>();
	private List<String> finalList2 = new ArrayList<>();
	private List<String> finalList3 = new ArrayList<>();
	
	@Test
	// base test x's after the initial character and no x's
	public void rxResults1() {
		
		intList1.add("ax");
		intList1.add("bb");
		intList1.add("cx");
		
		finalList1.add("a");
		finalList1.add("bb");
		finalList1.add("c");
		
		assertEquals(finalList1, rx.noX(intList1));	
	}
	
	@Test
	// x's before and after character inside string
	public void rxResults2() {
		
		intList2.add("xxax");
		intList2.add("xbxbx");
		intList2.add("xxcx");
		
		finalList2.add("a");
		finalList2.add("bb");
		finalList2.add("c");
		
		assertEquals(finalList2, rx.noX(intList2));	
	}
	
	@Test
	// only an x
	public void rxResults3() {
	
		intList3.add("x");

		finalList3.add("");
		
		assertEquals(finalList3, rx.noX(intList3));	
	}
	
	@Test (expected = NullPointerException.class)
	// add null
	public void rxResults4() {
		List<String> intList   = new ArrayList<>();
		List<String> finalList = new ArrayList<>();
	
		intList.add(null);

		finalList.add(null);
		
		// supposed to just call funciton with expected and it catches NPE
		// not catching NullPointerException, but is returning NullPointerException from function call, not sure,
		//rx.noX(intList);
	}

}