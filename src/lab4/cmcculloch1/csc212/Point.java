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
