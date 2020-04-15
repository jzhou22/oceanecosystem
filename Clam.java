package oceanecosystem;

import acm.util.RandomGenerator;

public class Clam extends LifeForm{
	
	public Clam(Location l, World w) {
		super(l,w);
		myLifeSpan = 10;
	}
	
	//eats kelp in a 5x5 radius
	public void eat() {
		for(int x=0; x<5; x++) {
			for(int y=0; y<5; y++) {
				
			}
		}
	}
	
	public void reproduce() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		
	}
}
