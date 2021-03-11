package AssignmentThree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/11/21
 * @LastEdited  3/11/21
 * @Description Write an example that counts the number of times a particular character, such as 'e', appears in a file
 * 					- character can be specified at the command line 
 * 					- path to text file can be hardcoded
 */

public class charCounter {
	
	public int countEm(char x, String filePath) throws IOException {
		
		FileInputStream stream = null;
		int count = 0;
			
		try {
			stream = new FileInputStream(filePath);
			int c;
			
			while ( (c = stream.read()) != -1 ) 
				if ( ((char)c) == x)
					count++;		
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			if ( stream != null )
				stream.close();
		}
		
		return count;
	}
	
	public char WhatWeLookinFor() throws IOException {
		String lookinForString;
		char lookinForChar;
		
		try ( Scanner scan = new Scanner(System.in) ) {
			
			System.out.print("what char we looking for: ");
	
			lookinForString = scan.next();
			lookinForChar = lookinForString.charAt(0);
			int asciiValue = (int) lookinForChar;
			
			// if a string
			if ( lookinForString.length() > 1 ) {
				System.out.println("Input a single character, not a string");
				return 0;
			}
			else {
				// check if valid ascii value
				if ( (asciiValue > 64 && asciiValue < 91) || (asciiValue > 96 && asciiValue < 123) )
					return lookinForChar;
				else {
					System.out.println("Not a valid character");
					return 0;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public static void main(String[] args) throws IOException {
		charCounter countObj = new charCounter();
		int countMain = 0;
		char x;
		
		// hard coded file path
		String filePath = "C:\\Users\\natha\\git\\Smoothstack\\Smoothstack\\src\\AssignmentThree\\Test folder 1\\test file 1";
		
		
		x = countObj.WhatWeLookinFor();
		
		countMain = countObj.countEm(x, filePath);
		
		System.out.print("Number of " + x + ":" + countMain);
		

	}

}
