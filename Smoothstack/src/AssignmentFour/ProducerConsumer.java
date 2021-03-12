package AssignmentFour;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited  3/12/21
 * @Description Write a program with one thread (producer) taht produces items (ints). Another thread (consumer) consumes items.
 * 				For communication pruposes both threads have acesss to a bounded buffer which is basically an array
 * 
 * 				side note, tried to do everything in main like Pramod, however cannot use notify since it cannot be initialized for both
 * 				another note: switched from synchronizing on resource to synchronizing on thread, since it wouldn't recognize either thread as
 * 				owning resource when notifying the other and causing an exception. Does not seem to cause race conditions. but would be worth
 * 				looking into more
 */

public class ProducerConsumer {
	
	// create buffer of specific size
	int [] resourceBuffer = new int[7];
	int i = 0;
	
	
	// to change variables inside inner class
	public static int increment (int i) {
		return i++;
	}
	
	public static int decrement(int i) {
		return i--;
	}
	
	public void producer() {
		int num = 1;
		boolean running = true;
		
		try {
			while (running) {
				synchronized (this) {
					// don't put stuff if its full or if something is already there
					while ( i == 6  || (resourceBuffer[i] != 0) )
						wait();
					
					//put stuff into buffer!
					System.out.println("I put: " + num + "@[" + i + "]");
					resourceBuffer[i++] = num++;
						
					// let the other thread know you put something into the buffer
					notify();
					
					//slows down the thread to see whats happening
					Thread.sleep(100);
				}
			}
		}
		catch  (Exception e){
			e.printStackTrace();
			running = false;
		}
	}
	
	public void consumer() {
		boolean running = true;
		try {
			while (running) {
				synchronized (this) {
					while ( i == 0 )
						wait();
					
					//take stuff! want to look at previous value cus current i should be zero
					System.out.println("I took: " + resourceBuffer[i - 1] + "@[" + (i - 1) + "]");
					resourceBuffer[i - 1] = 0;
					i--;
					
					// lets the other thread know you took something out
					notify();
					
					// slows down the thread to see whats happening
					Thread.sleep(100);
				}
			
			}
		}
		catch  (Exception e){
			e.printStackTrace();
			running = false;
		}	
	}
	
	public static void main(String[] args) {
		System.gc();
		
		System.out.println("Start of program");
		
		ProducerConsumer obj = new ProducerConsumer();
		
		
		Runnable producer = new Runnable() {
			// overriting the standard libraries run function
			@Override
			public void run() {
				try {
					obj.producer();	
				}
				catch ( Exception e ) {
					e.printStackTrace();			
				}			
			}
		};
		
		Runnable consumer = new Runnable() {
			// overriting the standard libraries run function
			@Override
			public void run() {				
				try {
					obj.consumer();
				}
				catch ( Exception e ) {
					e.printStackTrace();		
				}			
			}	
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
		//new Thread(producer).join(1000);
		//new Thread(consumer).join(1000);
		
		System.out.println("End of program");

	}

}
