package lab4.cmcculloch1.csc212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

    private Dimensions dim = new Dimensions();
    private NumberPad numberPad;
    private TopPanel topPanel;

    public ControlPanel() {
		int d = 0;	// Used for ensuring sync'd objects at startup
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		 
        // Number Pad
        numberPad = new NumberPad();
        numberPad.setState(dim.getDimension(d));// Just to ensure sync'd objects
        
        // Top Button Panel
        topPanel = new TopPanel(d);	// Just to ensure sync'd objects
        topPanel.setNumberPad(numberPad);
        
        add(topPanel);
        add(numberPad);
	}

}
