package AssessmentOne;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;




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
	 * @args: 	needs PerformOperation obj to acesss interface, and integer
	 * @return: boolean
	 * @notes:  need this to convert from type PerformOperation to boolean for the check at the end
	 */
	public boolean poToBoolean(PerformOperation po, int num) {
		return po.operation(num);
	}
	
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
			int remain = 0, reverse = 0, tempToChange = x;
			
			//keep taking %10 amounts off the input number and performing operation
			while( tempToChange != 0 ) {
				remain = tempToChange % 10;
				reverse = (reverse * 10) + remain;
				tempToChange /= 10;
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
		int operationCount = 0;
		int i = 0;								//quick value separate the first operation
		PerformOperation returnValue = null;
		String finalAnswer = null;
		
		
		

		// ---------- reading in input ----------
		try (  Scanner scan = new Scanner(new File("C:\\Users\\natha\\git\\Smoothstack\\Smoothstack\\src\\AssessmentOne\\InputStub.txt"))) {
			if ( i == 0 ) {
				operationCount = scan.nextInt();
				i++;
			}
			
			int[][] valuesArr = new int[operationCount][2];
			
			int index1 = 0;
			
			// while we are in the number operations and while there is a line to read in
			while ( index1 < operationCount && scan.hasNextLine() ) {
				valuesArr[index1][0] = scan.nextInt();
				valuesArr[index1][1] = scan.nextInt();
				index1++;
			}
			
			//prints contents of array
			//for (int j = 0; j < operationCount; j++)
				//System.out.println(valuesArr[j][0] + " " + valuesArr[j][1]);
			
			
			for (int j = 0; j < operationCount; j++) {
				if ( valuesArr[j][0] == 1 ) {
					returnValue = obj.isOdd();
					finalAnswer = (obj.poToBoolean(returnValue, valuesArr[j][1])) ? "EVEN" : "ODD";
				}
				else if ( valuesArr[j][0] == 2 ) {
					returnValue = obj.isPrime();
					finalAnswer = (obj.poToBoolean(returnValue, valuesArr[j][1])) ? "PRIME" : "COMPOSITE";
				}
				else if ( valuesArr[j][0] == 3 ) {
					returnValue = obj.isPalindrome();
					finalAnswer = (obj.poToBoolean(returnValue, valuesArr[j][1])) ? "NOT PALINDROME" : "PALINDROME";
				}
				else {
					System.out.println("Invalide Operation Code");
				}
				
				System.out.println(finalAnswer);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		

	}

}
