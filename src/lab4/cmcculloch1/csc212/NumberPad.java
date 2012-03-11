package lab4.cmcculloch1.csc212;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NumberPad extends JPanel {

    private JButton[] button;
	private JTextArea textArea;
	private JTextArea textBox;
	private String[] work = new String[3];	// Working strings for variables
	//var = -1 if nothing has been entered yet (or all has been deleted)
	private int var = -1;		// Keep track of which variable gets input
	private int maxVar = 2;
	public NumberPad() {
		button = new JButton[21];
		String[] privS = {"<", "Clear", ">", "7", "8", "9", "4", "5", "6", "1",
						"2", "3", "0", ".", "+/-", "Trans", "Scale", "Compute",
						"RotX", "RotY", "RotZ",
						};
		setLayout( new GridLayout(7, 3));
		for(int i = 0; i < 21; i++) {
			button[i] = new JButton(privS[i]);
			if(i < 3) button[i].setForeground(Color.black);
			else if(i < 15) button[i].setForeground(Color.blue);
			add(button[i]);
			initListener(i);
		}
		button[17].setForeground(Color.red);
		for(int i = 0; i < 3; i++) work[i] = "";
	}
	
	private void initListener(int i) {
		switch(i)
		{
			case 0:	// Delete char button
		    	button[i].addActionListener(new DeleteListener());
			break;
			case 1:	// Clear button
		    	button[i].addActionListener(new ClearListener());
			break;
			case 2:	// Next button
		    	button[i].addActionListener(new NextListener());
			break;
		}
	}
	
	public void setState(String state) {
		if(state == "2D") {
			button[18].setEnabled(false);
			button[19].setEnabled(false);
			maxVar = 2;
		}
		else {
			button[18].setEnabled(true);
			button[19].setEnabled(true);
			maxVar = 3;
		}
	}
	
	public void setTexts(JTextArea textBox, JTextArea textArea) {
		this.textArea = textArea;
		this.textBox = textBox;
	}

	private void debugPrint(String loc) {
		System.out.println("DEBUG inside " + loc);
		System.out.println("var: " + var);
		System.out.println("work[0]: " + work[0]);
		System.out.println("work[1]: " + work[1]);
		System.out.println("work[2]: " + work[2]);
	}

	private String buildText(){
		String[] s = new String[4];
		if(var < 0) return "";	// -1 means nothing entered yet
		s[0] = "( " + work[0] + "|, "; // Don't forget the cheesy cursor!
		if(maxVar == 2) {
			s[1] = "( " + work[0] + ", " + work[1] + "| )"; 
			s[2] = "( " + work[0] + ", " + work[1] + " )"; 
		}
		if(maxVar == 3) {	// Show three coordinates
			s[1] = "( " + work[0] + ", " + work[1] + "|, )";
			s[2] = "( " + work[0] + ", " + work[1] + ", " + work[2] + "| )";
			s[3] = "( " + work[0] + ", " + work[1] + ", " + work[2] + " )";
		}
		return s[var];
	}
	
	// 	Listener for DeleteButton
   	private class DeleteListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var >= maxVar) var = maxVar - 1; // Deleting when all entered?
  			else if(var > -1) {	// Deleting something in string array?
  				// var = -1 if we haven't entered anything yet
  				if(work[var].isEmpty()){	// String empty?
	  				if(var > -1) var--;	// Decrement variable counter if valid
	  			}
	  			else {	// String not empty.
	  				// Shrink string by one character
	  				work[var] = work[var].substring(0, work[var].length() - 1);
	  			}
  			}
  			textBox.setText(buildText());
  	  		debugPrint("DeleteListener");
   		}
   	}

   	// 	Listener for ClearButton
   	private class ClearListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
   			textArea.setText("");
   			textBox.setText("");
   			var = 0;
   			for(int i = 0; i < 3; i++) work[i] = "";
   	  		debugPrint("ClearListener");
   		}
   	}

   	// 	Listener for NextButton
   	private class NextListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				// Next, it is possible to go to next value with nothing entered
  				// so, automatically "nudge" the first value to something valid.
  				if(var == -1) var = 0;	// 0.0 will automatically be entered.
  				if(work[var].length() == 0) work[var] = "0.0";
  				var++;
  	  			textBox.setText(buildText());
  			}
  			else
  			{
  				// Disable all number buttons because there is nothing else
  				// that should be entered.
  				
  			}
  			debugPrint("NextListener");
   		}
   	}
}
