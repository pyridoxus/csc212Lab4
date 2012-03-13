package lab4.cmcculloch1.csc212;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel {

    private Dimensions dim = new Dimensions();
    private NumberPad numberPad;
    private TopPanel topPanel;
    private JTextArea textArea;
    private JTextArea textBox;

    public ControlPanel() {
		int d = 0;	// Used for ensuring sync'd objects at startup
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Large text area to contain history of actions.
		textArea = new JTextArea(10, 80);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		Font font = new Font("Monospaced", Font.PLAIN, 12);
        textArea.setFont(font);
        textArea.setForeground(Color.blue);
		 
        // Text area for actively entered text (via buttons).
		textBox = new JTextArea(1, 20);
		textBox.setEditable(false);
        textBox.setFont(font);
        textBox.setForeground(Color.blue);

        // Number Pad
        numberPad = new NumberPad();
        numberPad.setTexts(textBox, textArea); // This line must be before next
        numberPad.setState(dim.getDimension(d));// Just to ensure sync'd objects
        
        // Top Button Panel
        topPanel = new TopPanel(d);	// Just to ensure sync'd objects
        // This would work more efficiently if I had time to learn about
        // GroupLayout. Then, I wouldn't have to pass numberPad anywhere...
        topPanel.setNumberPad(numberPad);
        
        add(topPanel);
        add(scrollPane);
        add(textBox);
        add(numberPad);
	}

}
