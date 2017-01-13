/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to use an Linked list queue which implements the QueueADT interface
 * which allows it to use the methods of a queue
 */

//LinkedListQueue class header
public class LinkedListQueue<T> implements QueueADT <T>{

	//Declaring private instance variables
	private ListNode Head;//the head of the queue
	
	//Constructor method to initialize private instance variables
	public LinkedListQueue(){
		Head = null;
	}
	
	/*Purpose: This method adds an element to the back of the queue
	 * @param element This is the element being added to the queue
	 */
	public void enqueue(T element) {
		if (Head != null) {
			ListNode Temp = Head;
			while (Temp.getNext() != null)
				Temp = Temp.getNext();
			Temp.setNext(new ListNode(element, null));
		}
		else
			Head = new ListNode(element, null);
	}
	
	/*Purpose: This method takes the first element of the queue off
	 * @return This returns the element taken off
	 */
	public T dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		ListNode tempHead = Head;
		Head = Head.getNext();
		return (T)tempHead.getValue();
	}

	/*Purpose: This method takes gets the first element in the queue
	 * @return This returns the first element in the queue
	 */
	public T peekFront() {
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		return (T)Head.getValue();
	}

	/*Purpose: This method gets the size of the queue
	 * @return This returns the size of the queue in an integer value
	 */
	public int size() {
		ListNode Temp = Head;
		int Size = 0;
		while(Temp != null){
			Size++;
			Temp = Temp.getNext();
		}
		return Size;
	}

	/*Purpose: This method checks to see if the queue is empty
	 * @return This returns a boolean value of whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return size() <= 0;
	}
	
	/*Purpose: This method gets all of the information in the queue
	 * @return This returns all of the information in the queue in a string value
	 */
	public String toString(){
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		ListNode Temp = Head;
		String Output = "";
		while(Temp != null){
			Output += Temp.getValue().toString();
			Temp = Temp.getNext();
		}
		return Output;
	}

}
