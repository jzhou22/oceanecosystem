package oceanecosystem;

import acm.util.RandomGenerator;

public class Shark extends Fish{
	
	public Shark(Location l, World w, double s) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		
		
	}

	public void reproduce() {
		
		
	}
}
