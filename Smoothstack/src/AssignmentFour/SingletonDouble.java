package AssignmentFour;

/**
 * @author Nathan Keyes
 * @DateCreated 3/12/21
 * @LastEdited 3/12/21
 * @Description Implement Singleton with double checked locking
 */

public class SingletonDouble {

	volatile public static SingletonDouble instance = null;

	private SingletonDouble() {
	}

	public static SingletonDouble getInstance() {

		// do an initial if check to see if we even need to lock up with synch (first
		// check)
		if (instance == null) {
			// now do the same process, with the original check being the second check
			synchronized (instance) {
				if (instance == null)
					instance = new SingletonDouble();
			}
		}

		return instance;
	}

	public static void main(String[] args) {

		/*
		 * // standard way (shown in Pramod's tutorial) synchronized (instance) { if (
		 * instance == null ) instance = new SingletonDouble(); }
		 */

	}

}
