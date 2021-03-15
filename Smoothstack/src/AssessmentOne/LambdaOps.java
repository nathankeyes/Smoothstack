package AssessmentOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;



/**
 * @author      Nathan Keyes
 * @DateCreated 3/14/21
 * @LastEdited  3/14/21
 * @Description Assessment 1 lambda function methods
 * 
 * Referenced for functional interfaces
 * https://www.baeldung.com/java-8-lambda-expressions-tips
 */

//provides target type for lambda expressions and method references
@FunctionalInterface
interface PerformOperation {
	boolean operation(Integer x);
}

public class LambdaOps {
	/**
	 * @args:
	 * @return: returns true when it IS a prime
	 * @notes:  tried just returning the lambda function kept returning error target type of this expression is function interface
	 * 			going to try and make a functional interface
	 *  
	 */
	public PerformOperation isOdd() {
		return (x) -> (x % 2 == 0) ? true : false;
	}
	
	
	/**
	 * @args:
	 * @return: returns true when it IS a prime
	 * @notes:  
	 *  
	 */
	public PerformOperation isPrime() {
		/* convert into lambda function
		if (x <= 1)
			return false;
		else {
			for (int  i = 2; i < x; i++)
				if ((x % i) == 0)
					return false;
		}
		return true;
		*/
		return (x) -> {
			if(x <= 1)
				return false;
			for(int i = 2; i < x; i++) {
				if(x % i == 0) 
					return false;
			} 
		return true; 
		};
	}
	
	
	/**
	 * @args:
	 * @return: returns true when it IS a palindrome
	 * @notes:  palindrome is a number that, when reversed, is the same number
	 *  
	 */
	public PerformOperation isPalindrome() {
		
		return (x) -> {
			Integer remain = 0, reverse = 0;
			while( x != 0 ) {
				remain = x % 10;
				reverse = (reverse * 10) + remain;
				x /= 10;
			}
			if (x == reverse)
				return true;
			else
				return false;
		};
	}
	
	
	/**
	 * @args:
	 * @return:
	 * @notes: Referenced for BufferedReader
	 *  https://www.tutorialspoint.com/difference-between-scanner-and-bufferreader-class-in-java#:~:text=Scanner%20and%20BufferReader%20both%20classes,for%20efficient%20reading%20of%20characters.
	 */
	public static void main(String[] args) throws IOException {	
		LambdaOps obj = new LambdaOps();

		
		// methods return a return value, need to convert it to boolean
		PerformOperation returnValue = null;
		boolean result = false;
		
		
		// ----- reading in input -----
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		Integer inputInt = Integer.parseInt(buffer.readLine());
		
		/*
		// ----- Results -----
		if ( num1 == 1 ) {
			result = returnValue.operation(numToCheck);
			
			if ( obj.isOdd() )
				System.out.println("ODD");
			else
				System.out.println("EVEN");	
		}
		else if ( num1 == 2) {
			if ( obj.isPrime() )
				System.out.println("PRIME");
			else
				System.out.println("COMPOSITE");	
		}
		else if ( num1 == 3 ) {
			if ( isPalindrome(num) )
				System.out.println("PALINDROME");
			else
				System.out.println("NOT PALINDROME");		
		}
		else {
			System.out.println("Something went wrong");
		}
		*/

	}

}
