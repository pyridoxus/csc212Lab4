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
