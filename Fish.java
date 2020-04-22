package oceanecosystem;




import java.awt.Color;

public abstract class Fish extends LifeForm{
	protected int speed;
	protected boolean fed;
	public Fish(Location loc, World w) {
		super(loc, w);
	}
	
	public void move(Location loc) {
		if(loc.getX()>myLocation.getX()) {
			if(loc.getY()>myLocation.getY()) {
				//x+ y+
				if(trueDistance(loc.getX()-getMyLocation().getX(),loc.getY()-getMyLocation().getY())<speed) {
					myLocation=loc;
				}
				
			}
			else {
				//x+ y-
				if(trueDistance(loc.getX()-getMyLocation().getX(),getMyLocation().getY()-loc.getY())<speed) {
					myLocation=loc;
				}
			}
		}
		else if(loc.getY()>myLocation.getY()) {
			//x- y+
			if(trueDistance(getMyLocation().getX()-loc.getX(),loc.getY()-getMyLocation().getY())<speed) {
				myLocation=loc;
			}
		}
		else {
			//x- y-
			if(trueDistance(getMyLocation().getX()-loc.getX(),getMyLocation().getY()-loc.getY())<speed) {
				myLocation=loc;
			}
		}
		
		
	}
	public abstract Location hunt();
	public double trueDistance(int x, int y) {
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	public double getSpeed() {
		return speed;
	}
	
	
}
