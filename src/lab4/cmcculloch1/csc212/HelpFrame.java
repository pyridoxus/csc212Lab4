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
