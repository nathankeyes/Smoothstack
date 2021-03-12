package AssignmentFour;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description Write a program to create deadlock between two threads, two main solutions:
 * 				1. switch order of acquiring resources (switch x and y order for one of the threads)
 * 				2. timeout when one acquires the resources and can't get both
 */

public class DeadlockEx {
	
	public static void main(String[] args) {
		System.gc();
		
		Integer x = 1;
		Integer y = 2;
		
		System.out.println("Start of Example");
		
		Runnable t1 = new Runnable() {
			
			// overriting the standard libraries run function
			@Override
			public void run() {
				try {
					synchronized (x) {
						Thread.sleep(100);

						synchronized (y) {
							System.out.println("Thread 1 has full control");
						}
					}
					
				}
				catch ( Exception e ) {
					
				}
				
			}
		};
		
		
		Runnable t2 = new Runnable() {
			
			// overriting the standard libraries run function
			@Override
			public void run() {
				try {
					synchronized (y) {
						Thread.sleep(100);
						synchronized (x) {
							System.out.println("Thread 2 has full control");
						}
					}
					
				}
				catch ( Exception e ) {
					
				}
				
			}
		};
		
		new Thread(t1).start();
		new Thread(t2).start();
		
		System.out.println("End of program");
		
		
	}

}
