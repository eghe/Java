
public class Polygon {
	Point [] points;
	
	Polygon(int n) {
		points = new Point[n];
	}
	
	public Polygon(float [] coords) {
		this(coords.length / 2);
		for(int i = 0; i < coords.length; i=i+2) {
			this.points[i / 2] = new Point(coords[i], coords[i + 1]);
		}
	}
	
	public void printCoordinates() {
		System.out.println("-----");
		for(int i = 0; i < points.length; i++) {
			points[i].print();
		}
	}
	
	public static void main(String [] str) {
		float [] coords = {1, 2, 3, 4, 5, 6};
		Polygon p = new Polygon(coords);
		
		p.printCoordinates();
	}
}
