package AssessmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/14/21
 * @LastEdited  3/14/21
 * @Description Assessment 1 Functional method to multiply each value by two
 */


public class doubleInts {
	public List<Integer> doubling(List<Integer> list) {
		
		if (list == null) {
			System.out.println("Empty List");
			return null;
		}
		
		for ( int i = 0; i < list.size(); i++ )
			list.set(i, (list.get(i) * 2));
		
		return list;
	}

	public static void main(String[] args) {
		List<Integer> intList   = new ArrayList<>();
		List<Integer> finalList = new ArrayList<>();
		doubleInts DI = new doubleInts();
		
		/** Test Group 1
		//intList.add(1);
		//intList.add(2);
		//intList.add(3);
		*/
		
		/** Test Group 2
		intList.add(6);
		intList.add(8);
		intList.add(6);
		intList.add(8);
		intList.add(-1);
		*/
		
		//Test Group 3
		//intList.add();
		
		finalList = DI.doubling(intList);
		
		for ( Integer x : finalList )
			System.out.println(x);
	}

}
