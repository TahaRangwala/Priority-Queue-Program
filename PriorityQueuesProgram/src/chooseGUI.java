/*Name: Taha Rangwala
 * Date: January 6, 2017
 * Purpose: The purpose of this class is to allow the user to use a friendly interface to
 * choose which program they want, the heart program or the schedule program.
 */

import BreezySwing.*;//allows more window objects

import javax.swing.*;//allows more window objects

import java.awt.Color;//allows for more colors

//chooseGUI class header
public class chooseGUI extends GBFrame{

	//Declaring window objects
	private JRadioButton Random, Order;
	private JButton Heart, Schedule;
	private ButtonGroup Group;
	
	//Constructor method to initialize window objects
	public chooseGUI(){
		Group = new ButtonGroup();
		Random = addRadioButton("Random Linked List",1,1,1,1);
		Order = addRadioButton("Ordered Linked List",1,2,1,1);
		Group.add(Random);
		Group.add(Order);
		Random.setSelected(true);
		Heart = addButton("Heart",2,1,1,1);
		Schedule = addButton("Schedule",2,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Heart){//opens heart program
			heartGUI theGUI;
			if(Random.isSelected())
				theGUI = new heartGUI(this, new randomLinkedList());
			else
				theGUI = new heartGUI(this, new orderedLinkedList());
			setVisible(false);
			theGUI.setVisible(true);
		}
		else if(buttonObj == Schedule){//opens schedule program
			scheduleGUI theGUI;
			if(Random.isSelected())
				theGUI = new scheduleGUI(this, new randomLinkedList());
			else
				theGUI = new scheduleGUI(this, new orderedLinkedList());
			setVisible(false);
			theGUI.setVisible(true);
		}
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		chooseGUI theChooseGUI = new chooseGUI();
		theChooseGUI.setSize(300,100);//size of the GUI interface
		theChooseGUI.setTitle("Choose Type of Program");//title of GUI interface
		theChooseGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theChooseGUI.setVisible(true);//visibility of interface
		theChooseGUI.setLocationRelativeTo(null);//Location is in center of screen
		theChooseGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
