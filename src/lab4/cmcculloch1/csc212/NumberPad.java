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
	public NumberPad() {
		button = new JButton[21];
		String s;
		String[] privS = {"<", "Clear", ">", "7", "8", "9", "4", "5", "6", "1",
						"2", "3", "0", ".", "+/-", "Trans", "Scale", "Compute",
						"RotX", "RotY", "RotZ",
						};
		setLayout( new GridLayout(7, 3));
		for(int i = 0; i < 21; i++) {
			s = privS[i];
			button[i] = new JButton(s);
			if(i < 3) button[i].setForeground(Color.black);
			else if(i < 15) button[i].setForeground(Color.blue);
			add(button[i]);
			switch(i)
			{
				case 1:	// Clear button
			    	button[i].addActionListener(new ClearListener());
				break;
			}
		}
		button[17].setForeground(Color.red);
	}
	
	public void setState(String state) {
		if(state == "2D") {
			button[18].setEnabled(false);
			button[19].setEnabled(false);
		}
		else {
			button[18].setEnabled(true);
			button[19].setEnabled(true);
		}
	}
	
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	// 	Listener for dimensionBox
   	private class ClearListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
   			textArea.setText("");
   		}
   	}
}
