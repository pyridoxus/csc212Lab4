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
		}
		initListeners();
		button[17].setForeground(Color.red);
		for(int i = 0; i < 3; i++) work[i] = "";
		functionButtons(false);
	}
	
	private void initListeners() {
    	button[0].addActionListener(new DeleteListener()); // Delete char
    	button[1].addActionListener(new ClearListener()); // Clear button
    	button[2].addActionListener(new NextListener()); // Next button
		button[3].addActionListener(new Listener7()); // Number button
		button[4].addActionListener(new Listener8()); // Number button
		button[5].addActionListener(new Listener9()); // Number button
		button[6].addActionListener(new Listener4()); // Number button
		button[7].addActionListener(new Listener5()); // Number button
		button[8].addActionListener(new Listener6()); // Number button
		button[9].addActionListener(new Listener1()); // Number button
		button[10].addActionListener(new Listener2()); // Number button
		button[11].addActionListener(new Listener3()); // Number button
		button[12].addActionListener(new Listener0()); // Number button
		button[13].addActionListener(new ListenerDot()); //Decimal point
		button[14].addActionListener(new ListenerNegate()); // Negate
	}
	
	public void setState(String state) {
		// Stack and working variables are cleared every time the state changes.
		clear();
		if(state == "2D") maxVar = 2;
		else maxVar = 3;
		functionButtons(false);
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
		if(var == maxVar) functionButtons(true);
		else functionButtons(false);
		return s[var];
	}
	
	private void functionButtons(boolean set) {
		for(int i = 15; i < 21; i++) {
			// Cannot do x or y axis rotation in 2D mode, so disable buttons
			if((i == 18 || i == 19) && (var == 2)) button[i].setEnabled(false); 
			else button[i].setEnabled(set);
		}
	}
	
	private void clear() {
		textArea.setText("");
		textBox.setText("");
		var = 0;
		for(int i = 0; i < 3; i++) work[i] = "";
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
  			clear();
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

   	// 	Listener for 0 Button
   	private class Listener0 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "0";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener0");
   		}
   	}

   	// 	Listener for 1 Button
   	private class Listener1 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "1";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener1");
   		}
   	}

   	// 	Listener for 2 Button
   	private class Listener2 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "2";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener2");
   		}
   	}

   	// 	Listener for 3 Button
   	private class Listener3 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "3";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener3");
   		}
   	}

   	// 	Listener for 4 Button
   	private class Listener4 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "4";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener4");
   		}
   	}

   	// 	Listener for 5 Button
   	private class Listener5 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "5";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener5");
   		}
   	}

   	// 	Listener for 6 Button
   	private class Listener6 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "6";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener6");
   		}
   	}

   	// 	Listener for 7 Button
   	private class Listener7 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "7";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener7");
   		}
   	}

   	// 	Listener for 8 Button
   	private class Listener8 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "8";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener8");
   		}
   	}

   	// 	Listener for 9 Button
   	private class Listener9 implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += "9";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("Listener9");
   		}
   	}

   	// 	Listener for Dot Button
   	private class ListenerDot implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				work[var] += ".";
  	  			textBox.setText(buildText());
  			}
  			debugPrint("ListenerDot");
   		}
   	}

   	// 	Listener for Negate Button
   	private class ListenerNegate implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			if(var < maxVar) {	// All entered?
  				if(var == -1) var = 0;	// Something is being entered.
  				if(work.length > 0){
  					if(work[var].contains("-")) {
  						work[var] = work[var].substring(1, work[var].length());
  					}
  					else {
  						work[var] = "-" + work[var];
  					}
  				}
  				else {
  					work[var] = "-";
  				}
  	  			textBox.setText(buildText());
  			}
  			debugPrint("ListenerNegate");
   		}
   	}
}
