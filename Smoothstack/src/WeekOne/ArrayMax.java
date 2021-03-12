package WeekOne;

/**
 * @author Nathan Keyes
 * @DateCreated 3/10/21
 * @LastEdited 3/10/21
 * @Description Construct a 2D array and find the max number, and show it's
 *              position in array
 */

public class ArrayMax {

	public void findMax(int[][] array) {

		int max = array[0][0];
		int indexOne = 0;
		int indexTwo = 0;

		// loop through 2D array, saving new max value every time it's found
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];

					// chose to do two int values to save index because creating another 2D array
					// would be a large memory usage
					// for single index in double array
					indexOne = i;
					indexTwo = j;
				}
			}
		}

		System.out.println("Largest value found: " + max);
		System.out.println("Index: " + indexOne + "," + indexTwo);

		return;
	}

	public static void main(String[] args) {

		// create 2D array, just hard coding for assignment (speicified this is okay)
		int[][] twoDArray = new int[5][5];
		int sumValue = 1;

		ArrayMax obj = new ArrayMax();

		// populate 2D array; final index (4,4) should have largest number
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				twoDArray[i][j] = sumValue++;

		obj.findMax(twoDArray);

	}

}
