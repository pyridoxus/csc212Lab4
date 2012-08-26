//This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
