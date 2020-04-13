package oceanecosystem;

import java.awt.Color;

public abstract class Fish extends LifeForm{
	protected int speed;
	public Fish(Location loc, World w) {
		super(loc, w);
	}
	
}
