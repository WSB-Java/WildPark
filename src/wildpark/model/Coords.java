/**
 * @author Xtry333
 */
package wildpark.model;

public class Coords {
	public int x;
	public int y;
	
	Coords(int _x, int _y) {
		this.x= _x;
		this.y = _y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override public String toString() {
		return "X: " + this.x + ", Y: " + this.y;
	}
	
}
