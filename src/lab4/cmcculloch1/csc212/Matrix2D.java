package lab4.cmcculloch1.csc212;

public class Matrix2D extends Matrix implements MatrixMath{
	public Matrix2D() {
		super(3);
		this.work = new double[3][3];
		this.identity();
	}
	
	public void translate(Point p, Point t)	// p is translated by t
	{
		this.initWorkTranslate(t);
		this.multiply(p);
	}

	public void scale(Point p, Point s)			// p is scaled by s
	{
		this.initWorkScale(s);
		this.multiply(p);
	}

	public void rotx(Point p, double r)			// p is rotated on x axis by r
	{
		this.initWorkRotx(r);	// r must be in radians
		this.multiply(p);
	}

	public void roty(Point p, double r)			// p is rotated on y axis by r
	{
		this.initWorkRoty(r);	// r must be in radians
		this.multiply(p);
	}

	public void rotz(Point p, double r)			// p is rotated on z axis by r
	{
		this.initWorkRotz(r);	// r must be in radians
		this.multiply(p);
	}

	@Override
	public void initWorkTranslate(Point t)
	{
		// init work matrix for translation
		double[] f = new double[2];
		f = t.get();
		this.identity();
		this.work[0][2] = f[0];
		this.work[1][2] = f[1];
	}

	@Override
	public void initWorkScale(Point s)
	{
		// init work matrix for scaling
		double[] f = new double[2];
		f = s.get();
		this.identity();
		this.work[0][0] = f[0];
		this.work[1][1] = f[1];
	}

	@Override
	public void initWorkRotx(double r)
	{
		System.out.println("Invalid operation for 2D Matrix.");
	}
	
	@Override
	public void initWorkRoty(double r)
	{
		System.out.println("Invalid operation for 2D Matrix.");
	}

	@Override
	public void initWorkRotz(double r)
	{
		// init work matrix for z axis rotation (even though it's 2D)
		this.identity();
		this.work[0][0] = Math.cos(r);
		this.work[0][1] = -Math.sin(r);
		this.work[1][0] = Math.sin(r);
		this.work[1][1] = Math.cos(r);
	}
}
