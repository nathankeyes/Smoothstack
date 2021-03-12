package WeekOne;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Nathan Keyes
 * @DateCreated 3/9/21
 * @LastEdited 3/9/21
 * @Description user guesses a number between 1-100, must get within +-10 of
 *              rand number
 */
public class NumGuesser {

	void guesser(int randNum) {

		// ----- Taking in the input -----
		System.out.println("Input a number between 1 and 100: ");

		Scanner scan = new Scanner(System.in);

		int userNum;

		for (int count = 0; count < 5; count++) {

			// ------ taking in user number -----
			// check to see if num is int
			if (!scan.hasNextInt()) {
				System.out.println("Input is not an integer, try start over");
				return;
			}

			userNum = scan.nextInt();

			// check to see if its in correct range
			if (userNum < 0 || userNum > 100) {
				System.out.print("Input number is out of range, try again");
				return;
			}

			// ----- check to see if user num +-10 -----
			if ((userNum >= (randNum - 10)) && (userNum <= (randNum + 10))) {
				// if in correct range
				System.out.println("Good job!");
				return;
			} else if (count == 4) {
				System.out.println("No good, thanks for playing");
				return;
			} else {
				System.out.println("Try again, you have " + (4 - count) + " tries left");
			}

		}

		return;
	}

	public static void main(String[] args) {

		// ----- Generating random number -----
		Random rand = new Random();
		int intRand = (rand.nextInt(99) + 1);

		// System.out.println("Random Number= " + intRand);

		// ----- guessing method -----
		NumGuesser guess = new NumGuesser();
		guess.guesser(intRand);

		return;
	}

}
