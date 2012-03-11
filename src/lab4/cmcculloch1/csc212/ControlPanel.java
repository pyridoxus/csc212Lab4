package lab4.cmcculloch1.csc212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private String[] dimension = {"2D", "3D"};
    private JLabel createLabel;
    private JComboBox dimensionBox;
    private JButton computeButton;
    private JButton quitButton;
    private NumberPad numberPad;
	public ControlPanel() {
		int d = 0;	// Used for ensuring sync'd objects at startup
		// Shape creation label and combo box
		createLabel = new JLabel("Select Dimension");
		add(createLabel);   
		dimensionBox = new JComboBox(dimension);
		dimensionBox.setSelectedIndex(d);	// Just to ensure sync'd objects
		dimensionBox.addActionListener(new DimensionBoxListener());
		add(dimensionBox);
	 
        // Compute areas button
        computeButton = new JButton("Compute areas");
        add(computeButton);

        // Number Pad
        numberPad = new NumberPad();
        numberPad.setState(dimension[d]);	// Just to ensure sync'd objects
        add(numberPad);
        
        // Quit button
        quitButton = new JButton("Quit");
        add(quitButton);
	}

	// Listener for createBox
	private class DimensionBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numberPad.setState(dimensionBox.getSelectedItem().toString());
		}
	}
}
