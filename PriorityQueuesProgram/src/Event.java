/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to hold all the information for
 * each event including the event's name and date
 */

import BreezySwing.Format;//allows for more formatting options

//Event class header
public class Event implements Comparable <Event>{//implements comparable

	//Declaring private instance variables
	public String Name;//Name of event
	public Comparable theDate;//Date of event
	
	/*Purpose: Constructor method to initialize private instance variables
	 * @param Name Name of event
	 * @param theDate Date of event
	 */
	public Event(String Name, Date theDate){
		this.Name = Name;
		this.theDate = theDate;
	}
	
	/*Purpose: This method gets the name of the event
	 * @return Returns a string value of the name of the event
	 */
	public String getName(){
		return Name;
	}
	
	/*Purpose: This method gets the date of the event
	 * @return Returns the date of the event
	 */
	public Comparable getDate(){
		return theDate;
	}
	
	/*Purpose: This method compares two dates of different events
	 * @param O This is the event being compared to the current event
	 * @return Returns an integer value designating which event has the highest priority
	 */
	public int compareTo(Event E){
		if(E instanceof Event)
			return theDate.compareTo(E.getDate());
		throw new IllegalArgumentException("This Is Not An Event!");
	}
	
	/*Purpose: This method gets all the information of the event
	 * @return Returns a string value of all the information of the event
	 */
	public String toString(){
		String Output = Format.justify('l', "Name", 15) + Format.justify('l', "Date",15) + '\n';
		return Output + Format.justify('l', Name, 15) + Format.justify('l', theDate.toString(),15) + '\n';
	}
	
	/*Purpose: This method error checks the name and date of an event
	 * @param Name Name of event
	 * @param theDate Date of event
	 */
	public static void checkEvent(String Name, Date theDate){
		if(Name.trim().equals(""))
			throw new IllegalArgumentException("Make Sure To Input The Event's Name!");
		Date.checkDateInputs(theDate);
	}
	
}
