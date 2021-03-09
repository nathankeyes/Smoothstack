
package WeekOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/8/21
 * @LastEdited  3/8/21
 * @Description Copying ascii art, specified for assignment
 */
public class AsciiArt {
	
	void designOne(int rowNum) {
		
		// for loop for controlling how many lines of asterics
		for ( int i = 0; i < rowNum; i++ ) {
				
			// reset to current line number and print additional asterics for additional lines
			int j = i;
			while ( j >= 0 ) {
				System.out.print("*");
				j--;
			}
			
			System.out.println("");
		}
		
		return;
	}
	
	void designTwo(int rowNum) {
		
		// for loop for controlling how many lines of asterics
		for ( int i = 0; i < rowNum; i++ ) {
			
			// reset to max number of lines minus our current line number to decrease number of prints
			int j = rowNum - i;
			
			while ( j > 0 ) {
				System.out.print("*");
				j--;
			}
			
			System.out.println("");
		}
		
		return;
	}
	
	void designThree(int rowNum) {
		
		//indent starts as one less than the number of rows
		int indent = rowNum - 1;
		
		for ( int i = 1; i <= rowNum; i++ ) {
			
			// first print your indent
			int tempIndent = indent;
			while ( tempIndent > 0 ) {
				System.out.print(" ");
				tempIndent--;
			}
			indent--;
			
			System.out.print("*");
			
			int j = i;
			while ( j > 1 ) {
				System.out.print("**");
				j--;
			}
			
			System.out.println("");
		}
		
		return;
	}
	
	void designFour(int rowNum) {
		//indent starts at zero and iterates until one less than number of rows
		
		for ( int i = 0; i < rowNum; i++ ) {
			//first print your indent
			int tempIndent = i;
			while ( tempIndent > 0 ) {
				System.out.print(" ");
				tempIndent--;
			}
			
			System.out.print("*");
			
			int j = rowNum - i;
			
			while ( j > 1 ) {
				System.out.print("**");
				j--;
			}
			
			System.out.println("");
		}
		
		return;
	}
	
	public static void main(String[] args) {
		
		int rows = 4;
		
		AsciiArt art = new AsciiArt();
		
		// art.designOne(rows);
		// art.designTwo(rows);
		// art.designThree(rows);
		art.designFour(rows);
		
		
		return;
	}
}
