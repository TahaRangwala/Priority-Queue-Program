/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: this stores all the information for each date a book was borrowed including the year, month, and
 * day
 */

//Date class header
public class Date implements Comparable <Date>{//this implements the comparable interface
	
	//Declaring private instance variables
	private int Year;//year of date
	private int Month;//month of date
	private int Day;//day of date
	
	//constructor method to initialize the year, month, and day
	public Date(int Y, int M, int D){
		Year = Y;
		Month = M;
		Day = D;
	}
	
	/*Purpose: allows the user to access the year of a date
	 * @return returns the year of a date
	 */
	public int getYear(){
		return Year;
	}
	
	/*Purpose: allows the user to access the month of a date
	 * @return returns the month of a date
	 */
	public int getMonth(){
		return Month;
	}
	
	/*Purpose: allows the user to access the day of a date
	 * @return returns the day of a date
	 */
	public int getDay(){
		return Day;
	}
	
	/*Purpose: this calculate the minimum date that a book could have been borrowed before it is late
	 * by using the current date as a reference
	 * @parm Current this is the current date the user has inpued
	 * @return this returns a date that is the minimum date that a user could have borrowed a book without it being late
	 */
	public Date getTwoWeeksBefore(Date Current){
		int Y = Current.getYear(), M = Current.getMonth(), D = Current.getDay();
		for(int i = 0; i < 14; i++){
			if(M == 1 && D == 1){
				M = 12;
				Y--;
				D = 31;
			}
			else if(D == 1){
				M--;
				D = getDaysInMonth(M,Y);
			}
			else D--;	
		}
		return new Date(Y,M,D);
	}
	
	/*Purpose: the purpose of this is to calculate the maximum number of days that a
	 * certain month has as shown below
	 * @parm M this is the month the user is checking
	 * @parm Y this is used in order to use the leap year method for the month February
	 * @return this return the amount of days in the month the user has given
	 */
	private int getDaysInMonth(int M, int Y){
		if(M == 4 || M == 6 || M == 9 || M == 11)
			return 30;
		else if(M == 2 && LeapYear(Y))
			return 29;
		else if(M == 2 && LeapYear(Y) == false)
			return 28;
		else return 31;
	}
	
	/*Purpose: the purpose is to check if a date comes before or after another date
	 * @parm C this is the date that is being checked to see if it is before or after another dae
	 * @return this returns an integer value of positive or negative number to let the program know whether
	 * or not the date comes before or after another date
	 */
	public int compareTo(Date D){
		if(D instanceof Date){
			if(Year != (D.getYear()))
				return Year - D.getYear();
			else if(Month !=  D.getMonth())
				return Month - D.getMonth();
			else if(Day != (D.getDay()))
					return Day - D.getDay();
			else return 0;
		}
		throw new IllegalArgumentException("This Is Not A Date!");
	}
	
	/*Purpose: this calculates whether a year is a leap year or not
	 * @parm Y the year the is being checked to see if it is a leap year or not
	 * @return this returns a boolean value of whether or not the year is a leap year or not
	 */
	public boolean LeapYear(int Y){
		if((Y % 4 == 0) && (Y % 100 != 0) || (Y % 400 == 0))
			return true;
		else return false;
	}
	
	/*Purpose: this outputs all the dates information in a table format
	 * @return this returns a string value of the dates information
	 */
	public String toString(){
		return Month + "/" + Day + "/" + Year;
	}
	
	/*Purpose: this does error checking for the dates so no errors occur in the program
	 * @param D This is the date being checked
	 */
	public static void checkDateInputs(Date D){
		if(D.getDay() > D.getDaysInMonth(D.getMonth(),D.getYear()) && D.getMonth() != 2)
				throw new IllegalArgumentException("There are not that many days in this month!");
		if(D.getYear() <= 0 || D.getMonth() <= 0 || D.getDay() <= 0)
			throw new IllegalArgumentException("All dates must have positive integer values!");
		if(D.getMonth() == 2 && D.getDay() == 29 && D.LeapYear(D.getYear()) == false)
			throw new IllegalArgumentException("This year is not a leap year!");
	}
	
}
