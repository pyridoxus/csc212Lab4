package lab4.cmcculloch1.csc212;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu {

	Scanner scan = new Scanner(System.in);
	String str = "";
	StringTokenizer stok;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p, x;
		Matrix m;
		ArrayList<Matrix> array = new ArrayList<Matrix>();
		Scanner scan = new Scanner(System.in);
		String str = "1";
		Menu menu = new Menu();
		int n, u, quit, dim = 0;
		while((dim != 2) && (dim != 3))
		{
			System.out.print("Enter dimension size (2 or 3): ");
			str = scan.nextLine();
			dim = Integer.parseInt(str);
		}
		if(dim == 2)
		{
			p = new Point2D(0, 0);
			x = new Point2D(0, 0);
		}
		else
		{
			p = new Point3D(0, 0, 0);
			x = new Point3D(0, 0, 0);
		}
		
		p.userSet("initial position");
		System.out.print(p);
		quit = 1;	// Quit flag
		n = 0;	// Index used for outputting to console
		while(quit == 1)
		{
			u = menu.doMenu(++n);
			if(dim == 2) m = new Matrix2D();
			else m = new Matrix3D();
			switch(u)
			{
				case 1:
					x.userSet("translation");
					m.initWorkTranslate(x);
				break;
				case 2:
					x.userSet("scale");
					m.initWorkScale(x);
				break;
				case 3:
					// If entering this selection for 2D matrices, the matrix
					// added to the array defaults to the identity matrix, and
					// an error message is displayed on the console.
					m.initWorkRotx(m.degToRad(menu.rotate("x")));
				break;
				case 4:
					// If entering this selection for 2D matrices, the matrix
					// added to the array defaults to the identity matrix, and
					// an error message is displayed on the console.
					m.initWorkRoty(m.degToRad(menu.rotate("y")));
				break;
				case 5:
					m.initWorkRotz(m.degToRad(menu.rotate("z")));
				break;
				case 6:
					System.out.println("Initial point: " + p);
					n = 1;
					for(Iterator<Matrix> i = array.iterator(); i.hasNext();)
					{
						// m starts this loop as identity, then pre-multiplies
						// all of the matrices in the array
						Matrix t = i.next();
// Next line prints each transformation for debugging
//						System.out.println("Transformation " + n++ + ":\n" + t);
						m.multiply(t);
					}
					System.out.println("Composite Transformation:\n" + m);
					m.multiply(p);	// Get final point transformation
					System.out.println("Final position: " + p);
					n = 0;	// Reset for inputting additional matrices
				break;
				case 7:
					quit = 0;	// All done
				break;
			}
			if(u != 6) // Only add to array if m is valid
			{
				array.add(m);
			}
		}
	}

	public int doMenu(int n)
	{
		int m;
		do
		{
			if(n == 0)
			{
				System.out.println("--------------------------------");
				System.out.println("Welcome to Transformation System");
				System.out.println("--------------------------------");
				System.out.println("Please choose a transformation");
			}
			else
			{
				System.out.println("Enter selection for transformation " + n);
			}
			System.out.println("1) Translate");
			System.out.println("2) Scale");
			System.out.println("3) Rotate around X");
			System.out.println("4) Rotate around Y");
			System.out.println("5) Rotate around Z");
			System.out.println("6) Calculate");
			System.out.println("7) Exit Program");
			System.out.println("Enter selection: ");
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			m = Integer.parseInt(str);
		} while(m < 1 || m > 7);
		return m;
	}
	
	public double rotate(String s)
	{
		System.out.print("Enter +/- degrees about " + s + " axis: ");
		str = scan.nextLine();
		return Double.parseDouble(str);
	}
}
