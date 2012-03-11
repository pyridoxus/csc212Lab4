package lab4.cmcculloch1.csc212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel {

    private Dimensions dim = new Dimensions();
    private NumberPad numberPad;
    private TopPanel topPanel;
    private JTextArea textArea;

    public ControlPanel() {
		int d = 0;	// Used for ensuring sync'd objects at startup
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		 
        // Number Pad
        numberPad = new NumberPad();
        numberPad.setState(dim.getDimension(d));// Just to ensure sync'd objects
        
        // Top Button Panel
        topPanel = new TopPanel(d);	// Just to ensure sync'd objects
        // This would work more efficiently if I had time to learn about
        // GroupLayout. Then, I wouldn't have to pass numberPad anywhere...
        topPanel.setNumberPad(numberPad);
        
        add(topPanel);
        add(scrollPane);
        add(numberPad);
	}

}
