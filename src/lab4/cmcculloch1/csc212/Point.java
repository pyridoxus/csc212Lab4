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

public abstract class Point {
	int size;
	protected double p[];
	public Point(int size) {
		this.size = size;	// size also contains length of homogeneous
		this.p = new double[size];
		for(int a = 0; a < size; a++) this.p[a] = 0.0;
	}
	
	public int getSize() {
		return this.size - 1;	// Return whether it's 2D or 3D
	}
	
	public double[] get() {
		return p;
	}

	public void set(double[] q) {
		int a;
		// If q is too short, then throw error
		// If q is too long, then only use the first elements to satisfy
		// setting the point for 2D or 3D.
		if(q.length < this.size - 1)
		{
			System.out.println("Parameter is incorrect size.");
			return;
		}
		// Ignore the homogeneous coordinate when setting the point
		for(a = 0; a < this.size - 1; a++) this.p[a] = q[a];
		p[a] = 1.0;	// Set the homogeneous coordinate
	}
	
	public abstract void userSet(String description);

}
