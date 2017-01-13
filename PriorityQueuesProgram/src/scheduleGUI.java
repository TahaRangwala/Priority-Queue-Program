/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to allow the user to use the schedule program interface
 * and perform tasks by using input fields, output fields, and buttons.
 */

import BreezySwing.*;//allows for more window objects

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more colors

//scheduleGUI class header
public class scheduleGUI extends GBDialog{

	//Declaring private instance variables
	private PriorityQueueADT mainQueue;//Priority queue object
	//Declaring window objects
	private JLabel nameLabel, dateLabel;
	private JTextField nameField;
	private IntegerField monthField,dayField, yearField;
	private JTextArea outputArea;
	private JButton Add, Next, Exit;
	
	/*Purpose: Constructor method to initialize private instance variables and window objects
	 * @param F This is the frame object sent in
	 * @param mainQueue This is the type of priority queue the user has chosen
	 */
	public scheduleGUI(JFrame F, PriorityQueueADT mainQueue){
		super(F);
		this.mainQueue = mainQueue;
		setSize(380,300);
		setTitle("Taha's Schedule Program");
		setLookAndFeel("MOTIF");
		getContentPane().setBackground(new Color(169,229,255));
		setLocationRelativeTo(null);
		nameLabel = addLabel("Name",1,1,1,1);
		nameField = addTextField("",1,2,1,1);
		dateLabel = addLabel("Date (mm/dd/yyyy)",2,1,1,1);
		monthField = addIntegerField(1,2,2,1,1);
		dayField = addIntegerField(1,2,3,1,1);
		yearField = addIntegerField(1,2,4,1,1);
		monthField.setText("");
		dayField.setText("");
		yearField.setText("");
		Add = addButton("Add Event",3,1,1,1);
		Next = addButton("Next Event",3,3,1,1);
		outputArea = addTextArea("",4,1,4,1);
		Exit = addButton("Exit",5,2,1,1);
		nameField.grabFocus();
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Add){//add event
			if(checkNumber()){
				try{
					Event.checkEvent(nameField.getText(), new Date(yearField.getNumber(),monthField.getNumber(),dayField.getNumber()));
					mainQueue.add(new Event(nameField.getText(), new Date(yearField.getNumber(),monthField.getNumber(),dayField.getNumber())));
					nameField.grabFocus();
					nameField.selectAll();
				}
				catch(IllegalArgumentException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure The Numbers Are Valid Integers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == Next){//next event
			try{
				outputArea.setText(mainQueue.removeMin().toString());
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			this.dispose();//closes the program
	}
	
	/*Purpose: This checks to make sure number fields hold valid integers
	 * @return This returns a boolean value on whether or not the number fields hold valid integers
	 */
	private boolean checkNumber(){
		return monthField.isValidNumber() && dayField.isValidNumber() && yearField.isValidNumber();
	}
	
}
