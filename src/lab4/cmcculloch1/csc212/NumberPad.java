package lab4.cmcculloch1.csc212;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPad extends JPanel {

    private JButton[] button;
	public NumberPad() {
		button = new JButton[18];
		String s;
		String[] privS = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0",
						".", "+/-", "Trans", "Scale", "Compute",
						"RotX", "RotY", "RotZ",
						};
		setLayout( new GridLayout(6, 3));
		for(int i = 0; i < 18; i++) {
			s = privS[i];
			button[i] = new JButton(s);
			if(i < 12) button[i].setForeground(Color.blue);
			add(button[i]);
		}
		button[14].setForeground(Color.red);
	}
	
	public void setState(String state) {
		if(state == "2D") {
			button[15].setEnabled(false);
			button[16].setEnabled(false);
		}
		else {
			button[15].setEnabled(true);
			button[16].setEnabled(true);
		}
	}
}
