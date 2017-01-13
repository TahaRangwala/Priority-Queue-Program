/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to hold a random linked list
 * which holds elements in a random order.
 */

//randomLinkedList class header
public class randomLinkedList<T extends Comparable<T>> implements PriorityQueueADT<T> {

	//Declaring private instance variables
	private ListNode Head;//Head of linked list
	
	//Constructor method to initialize private instance variables
	public randomLinkedList(){
		Head = null;
	}

	/*Purpose: This checks if the priority queue is empty
	 * @return This returns a boolean value of whether or not the priority queue is empty
	 */
	public boolean isEmpty() {
		return Head == null;
	}

	/*Purpose: This adds an element to the priority queue randomly
	 * @param Element This is the element added to the priority queue
	 */
	public void add(T Element) {
		if (Head == null)
			Head = new ListNode <T>(Element, null);
		else {
			ListNode <T>Temp = Head;
			while (Temp.getNext() != null) {
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode <T>(Element, null));
		}
	}

	/*Purpose: This removes an element with the highest priority off the priority queue
	 * @return Returns the element taken off
	 */
	public T removeMin() {
		if (isEmpty())
			throw new IllegalArgumentException("The Priority Queue is Empty!");
		T minElement = peekMin();
		ListNode <T> Temp = Head, Previous = null;
		if(minElement == Head.getValue()){
			Head = Head.getNext();
			return minElement;
		}
		else{
			while(Temp != null){
				if(minElement.compareTo(Temp.getValue()) == 0){
					Previous.setNext(Temp.getNext());
					return minElement;
				}
				Previous = Temp;
				Temp = Temp.getNext();
			}
		}
		return minElement;
	}

	/*Purpose: This shows the element with the highest priority in the priority queue
	 * @return Returns the element with the highest priority
	 */
	public T peekMin() {
		if (isEmpty())
			throw new IllegalArgumentException("The Priority Queue is Empty!");
		ListNode minElement = Head;
		if (Head.getNext() == null)
			return (T) Head.getValue();
		else{
			ListNode Temp = Head.getNext();
			while (Temp != null) {
				if(((Comparable<T>) minElement.getValue()).compareTo((T) Temp.getValue()) > 0)
					minElement = Temp;
				Temp = Temp.getNext();
			}
		}
		return (T) minElement.getValue();
	}

}
