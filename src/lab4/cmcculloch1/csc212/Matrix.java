package lab4.cmcculloch1.csc212;

public abstract class Matrix {
	
	// State variables
	protected double[][] work;	// Working matrix
	private int size;	// Size of square matrix

	// Constructor
	public Matrix(int size){
		this.size = size;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int a = 0; a < this.size; a++) {
			for(int b = 0; b < this.size; b++) {
				str = str + this.work[a][b];
				if(b < this.size - 1) str = str + " ";
			}
			str = str + "\n";
		}
		return str;
	}
	
	 // p is translated by t
	public abstract void translate(Point p, Point t);
	
	// p is scaled by s
	public abstract void scale(Point p, Point s);
	
	 // p is rotated on x axis by r
	public abstract void rotx(Point p, double r);
	
	 // p is rotated on y axis by r
	public abstract void roty(Point p, double r);
	
	 // p is rotated on z axis by r
	public abstract void rotz(Point p, double r);
	
	 // init work matrix for translation
	public abstract void initWorkTranslate(Point t);
	
	 // init work matrix for scaling
	public abstract void initWorkScale(Point s);
	
	// init work matrix for x axis rotation
	public abstract void initWorkRotx(double r);
	
	// init work matrix for y axis rotation
	public abstract void initWorkRoty(double r);
	
	// init work matrix for z axis rotation
	public abstract void initWorkRotz(double r);
	
	public void multiply(Point p)	// Find product of p and work, put in p
	{
		int row, col;
		double[] f = new double[this.size];
		double[] g = new double[this.size];
		f = p.get();
		for(row = 0; row < this.size; row++)
		{
			g[row] = 0.0;
			for(col = 0; col < this.size; col++)
			{
				g[row] += this.work[row][col] * f[col];
			}
		}
		p.set(g);
	}
	
	// Find product of m and work, put in work
	// This function pre-multiplies ( w' = m x w )
	public void multiply(Matrix m)
	{
		int a, b, c;
		if(this.size != m.getSize())
		{
			System.out.println("multiply: Incompatible matrices");
			return;
		}
		double[][] temp = new double[this.size][this.size];
		b = 0;
		c = 0;
		for(a = 0; a < this.size; a++)
		{
			for(b = 0; b < this.size; b++)
			{
				temp[a][b] = 0.0;
				for(c = 0; c < this.size; c++)
				{
					temp[a][b] +=  m.get(a, c) * this.work[c][b];
				}
			}
		}
		this.work = temp;
	}
	
	protected void identity() {
		for(int a = 0; a < this.size; a++) {
			for(int b = 0; b < this.size; b ++) {
				if(a != b) this.work[a][b] = 0.0;
				else this.work[a][b] = 1.0;
			}
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public double degToRad(double deg) {
		return deg * Math.PI / 180.0;
	}
	
	public double get(int row, int col) {
		return this.work[row][col];
	}
}
