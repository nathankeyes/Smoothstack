package WeekOne;

import java.util.Scanner;

/**
 * @author Nathan Keyes
 * @DateCreated 3/10/21
 * @LastEdited 3/10/21
 * @Description Take multiple values from command line and who the result of
 *              adding all of them
 */
public class Summation {

	public double sumTheNums(double[] numArray) {

		double sum = 0;

		for (int i = 0; i < numArray.length; i++)
			sum += numArray[i];

		return sum;
	}

	public double[] inputArray(int maxInput) {

		// choosing to do doubles, want to allow decimals for summation
		double[] numsToSum = new double[maxInput];

		// this is called try-with-resources
		// auto-closes the resource at the end of the statement
		try (Scanner scan = new Scanner(System.in)) {

			for (int i = 0; i < maxInput; i++) {
				System.out.println("Enter a num to sum: ");

				// ----- input error catching -----
				// if not number (will catch other ASCII and NULL)
				if (scan.hasNextDouble()) {
					numsToSum[i] = scan.nextDouble();
				} else {
					System.out.println("Sorry, thats not a number, try again");

					// sets to look for next input, instead of constantly looking at previous input
					// with hasNext()
					scan.nextLine();
					i--;
					continue;
				}

			}
		}

		return numsToSum;
	}

	public static void main(String[] args) {

		int maxInput = 5; // can be set to whatever max input we want
		double finalSum = 0;
		double[] numsToSum = new double[maxInput];

		Summation sum = new Summation();

		numsToSum = sum.inputArray(maxInput);

		finalSum = sum.sumTheNums(numsToSum);

		System.out.print("Final Summation: " + finalSum);

	}

}
