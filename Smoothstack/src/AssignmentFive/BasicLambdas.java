package AssignmentFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/13/21
 * @LastEdited  3/13/21
 * @Description Make an array containing a few Strings and sort it by:
 * 				1. shortest to longest
 * 				2. longest to shortest
 * 				3. alphabetically by first character only
 * 				4. strings that contain "e" first, everything else second
 * 				5. do 4 again but with a static helper method
 */

public class BasicLambdas {
	

	
	private static int helperMethod(String s1) {
		
		//System.out.println(((s1.charAt(0) == 'E' || (s1.charAt(0) == 'e')) ? 0 : 1));
		return ((s1.charAt(0) == 'E' || (s1.charAt(0) == 'e')) ? 0 : 1);
	}
	
	public boolean eFirstWithHelper(List<String> strList) {
		
		Comparator<String> compObj = Comparator.comparingInt(BasicLambdas::helperMethod);
		Collections.sort(strList, compObj);
		
		strList.forEach((i) -> System.out.println(i));	
		
		return true;
	}
	
	public boolean eFirst(List<String> strList) {
		System.out.println("Strings with Letter e first: ");

		// check with pseudo boolean if the first letter is e or E, else don't sort
		Collections.sort(strList, Comparator.comparingInt(i -> ((i.charAt(0) == 'E' || (i.charAt(0) == 'e')) ? 0 : 1)));
		
		strList.forEach((i) -> System.out.println(i));	
		
		return true;
	}
	
	public boolean firstChar(List<String> strList) {
		System.out.println("Strings alphabetical by first char only: ");
		
		Collections.sort(strList, (i1, i2) -> ( i1.charAt(0) - i2.charAt(0) ));
		strList.forEach((i) -> System.out.println(i));	
		
		return true;
	}
	
	public boolean longToShort(List<String> strList) {
		System.out.println("Strings from Longest to Shortest: ");
		
		Collections.sort(strList, (i1, i2) -> ( i2.length() - i1.length() ));
		strList.forEach((i) -> System.out.println(i));	
		
		return true;
	}
	
	public boolean shortToLong(List<String> strList) {
		System.out.println("Strings from Shortest to longests: ");
		
		// use collections.sort instead of arrays.sort because array.sort is for primitive types and collections is for objects Arraylist etc.
		Collections.sort(strList, (i1, i2) -> ( i1.length() - i2.length() ));
		strList.forEach((i) -> System.out.println(i));	
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		BasicLambdas BL = new BasicLambdas();
		boolean result;
		
		List<String> strList = new ArrayList<>();
		
		strList.add("Zebra");
		strList.add("Elephant");
		strList.add("Dog");
		strList.add("Berry");
		strList.add("Apple");
		strList.add("Eel");
		strList.add("Elephant");
		strList.add("Angry");
		strList.add("Berry");
		strList.add("Cat");
		strList.add("Dog");
		strList.add("Zebra");

		//result = BL.shortToLong(strList);
		//result = BL.longToShort(strList);
		//result = BL.firstChar(strList);
		//result = BL.eFirst(strList);
		result = BL.eFirstWithHelper(strList);
		
		if (result)
			System.out.println("End of Program");
		

	}

}
