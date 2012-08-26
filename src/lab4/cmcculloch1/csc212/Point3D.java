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

import java.util.Scanner;
import java.util.StringTokenizer;

public class Point3D extends Point {
	public Point3D(double x, double y, double z) {
		super(4);		// Setup as a 3D point (with homogeneous coordinate)
		this.set(x, y, z);
	}
		
	public void userSet(String description) {
		System.out.print("Enter " + description + " in the form x,y,z: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer stok = new StringTokenizer(str,",");
		this.p[0] = Double.parseDouble(stok.nextToken());
		this.p[1] = Double.parseDouble(stok.nextToken());
		this.p[2] = Double.parseDouble(stok.nextToken());
		this.p[3] = 1.0;	// homogeneous
	}

	@Override
	public String toString() {
		String str = "(" + this.p[0] + ", ";
		str = str + this.p[1] + ", ";
		str = str + this.p[2] + ")\n";
		return str;
	}
		
	public void set(double x, double y, double z) {
		this.p[0] = x;
		this.p[1] = y;
		this.p[2] = z;
		this.p[3] = 1.0;	// homogeneous
	}
}
