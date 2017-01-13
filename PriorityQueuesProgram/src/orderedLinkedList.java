/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to hold a ordered linked list
 * which holds elements in order of priority.
 */

//orderedLinkedList class header
public class orderedLinkedList<T extends Comparable<T>> implements PriorityQueueADT <T>{

	//Declaring private instance variables
	private ListNode Head;//Head of linked list
		
	//Constructor method to initialize private instance variables
	public orderedLinkedList(){
		Head = null;
	}
	
	/*Purpose: This checks if the priority queue is empty
	 * @return This returns a boolean value of whether or not the priority queue is empty
	 */
	public boolean isEmpty() {
		return Head == null;
	}

	/*Purpose: This adds an element to the priority queue in order of priority
	 * @param Element This is the element added to the priority queue
	 */
	public void add(T Element) {
		if(Head == null)
			Head = new ListNode(Element,null);
		else{
			ListNode Temp = Head, Previous = null;
			while (Temp != null) {
				if (((Comparable<T>) Element).compareTo((T) Temp.getValue()) < 0) {
					if(Temp == Head)
						Head = new ListNode(Element,Temp);
					else
						Previous.setNext(new ListNode(Element,Temp));
					return;
				}
				Previous = Temp;
				Temp = Temp.getNext();
			}
			Previous.setNext(new ListNode(Element,null));
		}
	}

	/*Purpose: This removes an element with the highest priority off the priority queue
	 * @return Returns the element taken off
	 */
	public T removeMin() {
		if(isEmpty())
			throw new IllegalArgumentException("The Priority Queue is Empty!");
		ListNode Min = Head;
		Head = Head.getNext();
		return (T) Min.getValue();
	}

	/*Purpose: This shows the element with the highest priority in the priority queue
	 * @return Returns the element with the highest priority
	 */
	public T peekMin() {
		if(isEmpty())
			throw new IllegalArgumentException("The Priority Queue is Empty!");
		return (T) Head.getValue();
	}

}
