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
