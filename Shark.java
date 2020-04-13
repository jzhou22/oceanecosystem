package oceanecosystem;

import acm.util.RandomGenerator;

public class Shark extends Fish{
	
	public Shark(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		speed=rgen.nextInt(5,10);
	}

	public void reproduce() {
		
		
	}
}
