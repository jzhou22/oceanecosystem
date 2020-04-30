package oceanecosystem;



public class Location {
	
	private int x;
	private int y;
	
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int distance(Location l) {
		int xDistance=Math.abs(x-l.getX());
		int yDistance=Math.abs(y-l.getY());
		return (int) Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2));
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
}
