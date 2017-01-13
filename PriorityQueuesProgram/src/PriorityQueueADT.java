/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this interface is allow classes that implement it to use the methods
 * that this interface provides. Also, this provides a form of polymorphism.
 */

//PriorityQueueADT interface header
public interface PriorityQueueADT<T> {

	/*Purpose: This checks if the priority queue is empty
	 * @return This returns a boolean value of whether or not the priority queue is empty
	 */
	public boolean isEmpty();
	
	/*Purpose: This adds an element to the priority queue
	 * @param Element This is the element added to the priority queue
	 */
	public void add(T Element);
	
	/*Purpose: This removes an element with the highest priority off the priority queue
	 * @return Returns the element taken off
	 */
	public T removeMin();
	
	/*Purpose: This shows the element with the highest priority in the priority queue
	 * @return Returns the element with the highest priority
	 */
	public T peekMin();
	
}
