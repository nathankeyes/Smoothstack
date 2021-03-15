package AssessmentOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/15/21
 * @LastEdited  3/15/21
 * @Description Assessment 1 recursion method
 */

public class RecursionPrac {
	
	/**
	 * @args:	1. index for your recursive array
	 * 			2. list you are looking at
	 * 			3. target value you are trying to get to
	 * @return: returns true when it IS a prime
	 * @notes:  choose a group of some of the ints from the array that sum to given target
	 * 			- constraint: if numbers adjacent in list are the same, they must all or none be selected
	 */
	public boolean groupSumClump(int index, int[] intArr, Integer target) {
		try {
			// initial/final check to see if we got our target to 0
			if ( index >= intArr.length )
				return (target == 0);
			
			// counter variable to keep track how many values ahead you are looking
			int i = 1;
			
			// first checks if we are still looking inside the array
			// then each time checks if the next value is the same as the curr value
			while( (index+i) < intArr.length && intArr[index] == intArr[index+i] )
				i++;
			
			// catch to check if we found the answer
			// first loop recursively calls subtracting the target to see if we find
			if ( groupSumClump(index+i, intArr, target-(i*intArr[index])) )
				return true;
			
			// this loop is almost like an iterator, continuing on the check but ignroing each additional index
			if ( groupSumClump(index+i, intArr, target) )
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void main(String[] args) {
		RecursionPrac RPobj = new RecursionPrac();

		
		// Test Group 1
		int index = 0;
		//int[] intArr =  new int[] {2, 4, 8};
		//Integer targetMain = 10;
		
		// Test Group 2
		//int[] intArr = new int[] {1, 2, 4, 8, 1};
		//Integer targetMain = 14;
		
		// Test Group 3
		//int[] intArr = new int[] {2, 4, 4, 8};
		//Integer targetMain = 14;
		
		// Test Group 4
		//int[] intArr = new int[] {1, 2, 2, 2, 5, 2};
		//Integer targetMain = 3;
		
		// Test Group 5
		int[] intArr = new int[] {1, 2, 2, 2, 2, 5};
		Integer targetMain = 7;

		
		if ( RPobj.groupSumClump(index, intArr, targetMain) )
			System.out.println("true");
		else
			System.out.println("false");
		

	}

}
