
public class Point {
	private float x, y;
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void changeCoords(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
}
