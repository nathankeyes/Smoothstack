package AssessmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/14/21
 * @LastEdited  3/14/21
 * @Description Assessment 1 Functional method to remove letter 'x' from strings
 */

public class removeX {
	public List<String> noX(List<String> list) {
		
		try {
		//iterates through list, grabbing current index and removing x and replacing with nothing
		for ( int i = 0; i < list.size(); i++ )
			list.set(i, ((list.get(i)).replace("x", "")));
		}
		catch ( NullPointerException e ) {
			System.out.println("null input invalid, try again");
			e.printStackTrace();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		List<String> intList   = new ArrayList<>();
		List<String> finalList = new ArrayList<>();
		removeX RX = new removeX();
		
		/** Test Group 1
		intList.add("ax");
		intList.add("bb");
		intList.add("cx");
		*/
		
		/** Test Group 2
		intList.add("xxax");
		intList.add("xbxbx");
		intList.add("xxcx");
		*/
		
		intList.add("x");
		
		finalList = RX.noX(intList);
		
		for ( String x : finalList )
			System.out.println(x);
		

	}

}
