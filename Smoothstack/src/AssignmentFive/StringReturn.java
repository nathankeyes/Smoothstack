package AssignmentFive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/13/21
 * @LastEdited  3/13/21
 * @Description Given a list of Strings, write a method that returns: 
 * 					a list of all strings:
 * 						1. that start with the letter 'a' (lower case)
 * 						2. have exactly 3 letters
 * 
 * 	Referenced again
 *  https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */

public class StringReturn {
	
	public List<String> perfectString(List<String> stringList) {
		
		// filters, then converts the stream<list> to a String<list>
		return stringList.stream()
						 .filter(i -> (i.startsWith("a") && i.length() == 3))
						 .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		List<String> finalList  = new ArrayList<>();
		
		StringReturn obj = new StringReturn();
		
		stringList.add("Dog");				// 3 letters no a
		stringList.add("Elephant");			// More than 3 letters
		stringList.add("Ant");				// perfect, but uppercase
		stringList.add("ant");				// perfect
		
		finalList = obj.perfectString(stringList);
		
		finalList.forEach(i -> System.out.println(i));
		
		
		

	}

}
