package oceanecosystem;

import acm.util.RandomGenerator;

public class Clam extends LifeForm{
	
	public Clam(Location l, World w) {
		super(l,w);
		
		myLifeSpan = 10;
	}

	public void reproduce() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		
	}
}
