package oceanecosystem;

import acm.util.RandomGenerator;

public class Minnow extends Fish{
	
	public Minnow(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		speed=rgen.nextInt(1,5);
		println("hi");
	}

	public void reproduce() {
		
		
	}
}
