package oceanecosystem;



import java.awt.Color;

public abstract class Fish extends LifeForm{
	protected int speed;
	protected boolean fed;
	public Fish(Location loc, World w) {
		super(loc, w);
	}
	
	public double getSpeed() {
		return speed;
	}
	
	
}
