/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this interface is allow classes that implement it to use the methods
 * that this interface provides. Also, this provides a form of polymorphism.
 */

//QueueADT Interface Header
public interface QueueADT <T> {
	
	/*Purpose: This method adds an element to the back of the queue
	 * @param element This is the element being added to the queue
	 */
	public void enqueue(T element);
	
	/*Purpose: This method takes the first element of the queue off
	 * @return This returns the element taken off
	 */
	public T dequeue();
	
	/*Purpose: This method takes gets the first element in the queue
	 * @return This returns the first element in the queue
	 */
	public T peekFront();
	
	/*Purpose: This method gets the size of the queue
	 * @return This returns the size of the queue in an integer value
	 */
	public int size();
	
	/*Purpose: This method checks to see if the queue is empty
	 * @return This returns a boolean value of whether or not the queue is empty
	 */
	public boolean isEmpty();
	
	/*Purpose: This method gets all of the information in the queue
	 * @return This returns all of the information in the queue in a string value
	 */
	public String toString();
	
}
