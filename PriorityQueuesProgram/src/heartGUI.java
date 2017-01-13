/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to allow the user to use the heart program interface
 * and perform tasks by using input fields, output fields, and buttons.
 */
import BreezySwing.*;//allows for more window objects

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more colors

//heartGUI class header
public class heartGUI extends GBDialog{

	//Declaring private instance variables
	private PriorityQueueADT mainQueue;//Priority queue object
	private QueueADT denyQueue;//Normal queue object
	//Declaring window objects
	private JLabel nameLabel, priorityLabel;
	private JTextField nameField;
	private IntegerField priorityField;
	private JButton Add, Next, Accept, Deny, Exit;
	private JTextArea outputArea;
	
	/*Purpose: Constructor method to initialize private instance variables and window objects
	 * @param F This is the frame object sent in
	 * @param mainQueue This is the type of priority queue the user has chosen
	 */
	public heartGUI(JFrame F, PriorityQueueADT mainQueue){
		super(F);
		this.mainQueue = mainQueue;
		denyQueue = new LinkedListQueue();
		setSize(380,300);
		setTitle("Taha's Heart Transplant Program");
		setLookAndFeel("MOTIF");
		getContentPane().setBackground(new Color(169,229,255));
		setLocationRelativeTo(null);
		nameLabel = addLabel("Name",1,1,1,1);
		nameField = addTextField("",1,2,1,1);
		priorityLabel = addLabel("Priority Number",2,1,1,1);
		priorityField = addIntegerField(1,2,2,1,1);
		Add = addButton("Add Patient",3,1,1,1);
		Next = addButton("Next Patient",3,2,1,1);
		outputArea = addTextArea("",4,1,2,1);
		Accept = addButton("Accept",5,1,1,1);
		Deny = addButton("Deny",5,2,1,1);
		Exit = addButton("Exit",6,2,1,1);
		priorityField.setText("");
		Accept.setEnabled(false);
		Deny.setEnabled(false);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Add){//add patient
			if(checkNumber()){
				try{
					Patient.checkPatient(nameField.getText(), priorityField.getNumber());
					mainQueue.add(new Patient(nameField.getText(),  priorityField.getNumber()));
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
		else if(buttonObj == Next){//next patient
			try{
				outputArea.setText(mainQueue.peekMin().toString());
				Next.setEnabled(false);
				Accept.setEnabled(true);
				Deny.setEnabled(true);
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Accept){//accept transplant
			try{
				mainQueue.removeMin();
				if(!denyQueue.isEmpty())
					mainQueue.add(denyQueue.dequeue());
				JOptionPane.showMessageDialog(new JFrame(),"This Person Accepted The Transplant!", "Information", JOptionPane.INFORMATION_MESSAGE);
				Next.setEnabled(true);
				Accept.setEnabled(false);
				Deny.setEnabled(false);
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Deny){//deny transplant
			try{
				denyQueue.enqueue(mainQueue.removeMin());
				JOptionPane.showMessageDialog(new JFrame(),"This Person Denied The Transplant!", "Information", JOptionPane.INFORMATION_MESSAGE);
				Next.setEnabled(true);
				Accept.setEnabled(false);
				Deny.setEnabled(false);
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
		return priorityField.isValidNumber();
	}
	
}
