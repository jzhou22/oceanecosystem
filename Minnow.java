package oceanecosystem;

import acm.util.RandomGenerator;

public class Minnow extends Fish{
	
	public Minnow(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		myColor = Color.RED;
		speed=rgen.nextInt(1,5);
		
	}

	public void reproduce() {
		
		
	}
}
