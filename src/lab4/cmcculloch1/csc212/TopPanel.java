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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {

    private JComboBox dimensionBox;
    private JLabel dimensionLabel;
    private JButton helpButton;
    private NumberPad numberPad;
    private Dimensions dim = new Dimensions();
    
    public TopPanel(int init){
        // Help button
        helpButton = new JButton("Help");
    	helpButton.addActionListener(new HelpButtonListener());
        
		// Shape dimension label and combo box
		dimensionLabel = new JLabel("Select Dimension");
	 
		// Dimension combo box
    	dimensionBox = new JComboBox(dim.getAll());
    	dimensionBox.setSelectedIndex(init);	// Just to ensure sync'd objects
    	dimensionBox.addActionListener(new DimensionBoxListener());

    	add(dimensionLabel);
    	add(dimensionBox);
        add(helpButton);
    }
    
    public void setNumberPad(NumberPad n){
    	numberPad = n;
    }

    // 	Listener for dimensionBox
   	private class DimensionBoxListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
   			numberPad.setState(dimensionBox.getSelectedItem().toString());
   		}
   	}

    // 	Listener for helpButton
   	private class HelpButtonListener implements ActionListener {
  		@Override
   		public void actionPerformed(ActionEvent e) {
  			HelpFrame help = new HelpFrame();
  	        help.setVisible(true);
   		}
   	}
}
