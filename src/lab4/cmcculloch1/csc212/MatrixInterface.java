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

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixInterface {
	private int dim;
	private Point p;
	private Point x;
	private Matrix m;
	private ArrayList<Matrix> array = new ArrayList<Matrix>();
	
	public MatrixInterface() {
		String[] s = {"DIM", "2"}; 
		command(s);
	}

	public int getDim() {
		return dim;
	}

	public void setOperationVector(Point p) {
		x = p;
	}
	
	private double[] cvtStringsToFloats(String[] s) {
		// This function ignores the first string in the array
		// because the string should come straight from the GUI.
		double[] f = new double[this.dim];
		f[0] = Double.parseDouble(s[1]);
		f[1] = Double.parseDouble(s[2]);
		if(this.dim == 3) { 
			f[2] = Double.parseDouble(s[3]);
		}
		return f;
	}
	
	private String splitP(){
		// If the user requests that the point is kept current, then this
		// function returns the point in string form for the NumberPad object
		// to use.
		double[] d = p.get();
		String s = "POINT" + "_" + Double.toString(d[0]) + "_" + 
				Double.toString(d[1]) + "_";
		if(p.getSize() == 3) {
			s += Double.toString(d[2]);
		}
		return s;
	}
	
	public String command(String[] s) {
		// Important function of the interface class.
		// Convert the strings in the parameter array into the matrices needed
		// to be pushed onto the stack. This function also dictates to the
		// rest of the matrix code when to pre-multiply.
		// First element in array is a string that instructs the interface
		// what to do.
		// The other elements are values to be placed into the matrix.
		String retMsg = "BAD COMMAND";
		if(s[0] == "DIM") {
			this.dim = Integer.parseInt(s[1]);
			if(dim == 2)
			{
				p = new Point2D(0, 0);
				x = new Point2D(0, 0);
				retMsg = s[0]; // Confirm completion
			}
			if(dim == 3)
			{
				p = new Point3D(0, 0, 0);
				x = new Point3D(0, 0, 0);
				retMsg = s[0]; // Confirm completion
			}
			array.clear();
		}
		if(dim == 2) m = new Matrix2D();	// Always new matrix
		if(dim == 3) m = new Matrix3D();	// Always new matrix
		if(s[0] == "INIT"){
			p.set(cvtStringsToFloats(s));
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "TRANS") {
			x.set(cvtStringsToFloats(s));
			m.initWorkTranslate(x);
			array.add(m);
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "SCALE") {
			x.set(cvtStringsToFloats(s));
			m.initWorkScale(x);
			array.add(m);
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "ROTX") {
			m.initWorkRotx(m.degToRad(Double.parseDouble(s[1])));
			array.add(m);
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "ROTY") {
			m.initWorkRoty(m.degToRad(Double.parseDouble(s[1])));
			array.add(m);
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "ROTZ") {
			m.initWorkRotz(m.degToRad(Double.parseDouble(s[1])));
			array.add(m);
			retMsg = s[0]; // Confirm completion
		}
		if(s[0] == "CALC") {
			retMsg = "Initial point: " + p + "\n";
			for(Iterator<Matrix> i = array.iterator(); i.hasNext();)
			{
				// m starts this loop as identity, then pre-multiplies
				// all of the matrices in the array
				Matrix t = i.next();
//Next lines print each transformation for debugging
//				System.out.println(t);
//					System.out.println("Transformation " + n++ + ":\n" + t);
				m.multiply(t);
			}
			retMsg += "Composite Transformation:\n" + m + "\n";
			m.multiply(p);	// Get final point transformation
			retMsg += "Final position: " + p + "\n";
		}
		if(s[0] == "POINT") {
			retMsg = splitP();
		}
		return retMsg;
	}
}
