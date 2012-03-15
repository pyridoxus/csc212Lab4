package lab4.cmcculloch1.csc212;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpDialog extends JPanel {
	private JTextArea textArea;
	public HelpDialog(String fFileName) {
		setLayout( new GridLayout(1, 1));
		textArea = new JTextArea();
		textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		add(textArea);
		StringBuilder text = new StringBuilder();
	    String NL = System.getProperty("line.separator");
	    Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(fFileName));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Help file does not exist!",
                    "Missing File", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}
	    try {
	      while (scanner.hasNextLine()){
	        text.append(scanner.nextLine() + NL);
	      }
	    }
	    finally{
	      scanner.close();
	    }
	    textArea.append(text.toString());
	}
}
