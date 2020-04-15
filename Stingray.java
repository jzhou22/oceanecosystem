package oceanecosystem;

import acm.util.RandomGenerator;

public class Stingray extends Fish{
	
	public Stingray(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		myColor = Color.gray;
		speed=rgen.nextInt(3,8);
	}

	public void reproduce() {
		
		
	}
}
