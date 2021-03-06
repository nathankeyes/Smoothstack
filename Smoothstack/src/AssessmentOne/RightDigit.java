package AssessmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/14/21
 * @LastEdited  3/14/21
 * @Description Assessment 1 Functional method for finding the right most digit of an integer in a list
 */


public class RightDigit {
	
	public List<Integer> rightDigit(List<Integer> list) {
		try {
			for ( int i = 0; i < list.size(); i++ )
				list.set(i, (list.get(i)) % 10);
		}
		catch (NullPointerException e) {
			System.out.println("Input is null, try again");
			e.printStackTrace();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}

			return list;
	}

	public static void main(String[] args) {
		List<Integer> intList   = new ArrayList<>();
		List<Integer> finalList = new ArrayList<>();
		RightDigit RD = new RightDigit();
		
		///** Test group 1
		//intList.add(1);
		//intList.add(22);
		//intList.add(93);
		//*/
		
		/** Test group 2
		intList.add(16);
		intList.add(8);
		intList.add(886);
		intList.add(8);
		intList.add(1);
		*/
		
		/** Test group 3
		intList.add(10);
		intList.add(0);
		*/
		
		// Test group 4 -  null
		intList.add(null);
	
		
		
		
		finalList = RD.rightDigit(intList);
		
		for ( Integer x : finalList )
			System.out.println(x);
	}

}
