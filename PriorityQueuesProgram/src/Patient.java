/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to hold all the information for each patient
 * including the patient's name and priority.
 */

import BreezySwing.Format;//allows for more formatting options

//Patient class header
public class Patient implements Comparable <Patient>{//implements Comparable

	//Declaring private instance variables
	public String Name;//Name of patient
	public int Priority;//Priority of patient
	
	/*Purpose: Constructor method to initialize private instance variables
	 * @param Name Name of the patient
	 * @param Priority Priority of the patient
	 */
	public Patient(String Name, int Priority){
		this.Name = Name;
		this.Priority = Priority;
	}
	
	/*Purpose: This method gets the name of the patient
	 * @return Returns a string value of the name of the patient
	 */
	public String getName(){ 
		return Name;
	}
	
	/*Purpose: This method gets the priority of the patient
	 * @return Returns an integer value of the priority of the patient
	 */
	public int getPriority(){
		return Priority;
	}
	
	/*Purpose: This method compares two priorities of different patients
	 * @param O This is the patient being compared to the current patient
	 * @return Returns an integer value designating which patient has the highest priority
	 */
	public int compareTo(Patient P){
		if(P instanceof Patient)
			return Priority - P.getPriority(); 
		throw new IllegalArgumentException("This Is Not A Patient!");
	}
	
	/*Purpose: This method gets all the information of the patient
	 * @return Returns a string value of all of the information of the patient
	 */
	public String toString(){
		String Output = Format.justify('l', "Name", 15) + Format.justify('l', "Priority",15) + '\n';
		return Output + Format.justify('l', Name, 15) + Format.justify('l', "" + Priority,15) + '\n';
	}
	
	/*Purpose: This method error checks the name and priority of a patient
	 * @param Name Name of the patient
	 * @param Priority Priority of the patient
	 */
	public static void checkPatient(String Name, int Priority){
		if(Name.trim().equals(""))
			throw new IllegalArgumentException("Make Sure To Input A Patient's Name!");
		else if(Priority < 0 || Priority > 3)
			throw new IllegalArgumentException("Make Sure To Input A Correct Priority!");
	}
	
}
