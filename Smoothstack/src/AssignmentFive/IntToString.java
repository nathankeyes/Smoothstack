package AssignmentFive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/13/21
 * @LastEdited  3/13/21
 * @Description Write a method that returns a comma separated string based on a given list of integers
 * 				Each element should be preceded by: 'e' if num == even
 * 				Each element should be preceded by: 'o' if num == odd
 * 				Input:  (3,44)
 * 				Output: (o3,e44)
 * 
 * great stream info for future refernece and referenced for solution
 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */

public class IntToString {
	
	public String intToString(List<Integer> integerList) {
		String solution;
		
		// uses the lambda expression to go through and add the e's, and o's then
		solution = integerList
						.stream()
						.map(i -> i % 2 == 0 ? "e" + i : "o" + i)
						.collect(Collectors.joining(","));
		
		return solution;
	}

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();

		IntToString obj = new IntToString();
		
		intList.add(1);
		intList.add(2);
		intList.add(3);
	
		
		String finalList = obj.intToString(intList);
		
		System.out.println(finalList);
		
	}

}
