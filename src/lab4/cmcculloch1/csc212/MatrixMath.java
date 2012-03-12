package lab4.cmcculloch1.csc212;

public interface MatrixMath {
	public void translate(Point p, Point t);	// p is translated by t
	public void scale(Point p, Point s);		// p is scaled by s
	public void rotx(Point p, double r);		// p is rotated on x axis by r
	public void roty(Point p, double r);		// p is rotated on y axis by r
	public void rotz(Point p, double r);		// p is rotated on z axis by r
	public void initWorkTranslate(Point t);
	public void initWorkScale(Point s);
	public void initWorkRotx(double r);
	public void initWorkRoty(double r);
	public abstract void initWorkRotz(double r);
}
