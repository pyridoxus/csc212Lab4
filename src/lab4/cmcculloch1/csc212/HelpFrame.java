package lab4.cmcculloch1.csc212;

import javax.swing.JFrame;

public class HelpFrame extends JFrame {
	
	public HelpFrame() {
		super("Transformation Calculator Help");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
        // Help Dialog
        getContentPane().add(new HelpDialog("src/help.txt"));
       
        // Size frame
        pack();
	}
}
