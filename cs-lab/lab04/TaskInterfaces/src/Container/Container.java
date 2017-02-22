public interface Container {
	/*
	 * Exracts a task from the container
	 * Returns the extracted task
	 */
	Task pop();
	
	/*
	 * Adds a task to the containet
	 */
	Task push(Task t);
	
	/*
	 * Returns the number of the elements in the container
	 */
	int size();
	
	/*
	 * Returns the max number of elements
	 */
	int capacity();
	
	/*
	 * Checks if the container is empty
	 * returns true if the container is empty
	 */
	boolean isEmpty();
	
	/*
	 * Transfer the data from a Container to anther container
	 */
	void transferFrom(Container c);
}
