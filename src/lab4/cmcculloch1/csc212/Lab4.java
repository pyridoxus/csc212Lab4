package lab4.cmcculloch1.csc212;

import javax.swing.JFrame;

public class Lab4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Application frame
        JFrame frame = new JFrame("Transformation Calculator");
        frame.setLocation(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        // Control panel
        frame.getContentPane().add(new ControlPanel());
       
        // Size frame and make visible
        frame.pack();
        frame.setVisible(true);
	}

}
