package oceanecosystem;

import java.util.ArrayList;

import acm.util.RandomGenerator;

public class Kelp extends Plant {
	
	public Kelp(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	
	public void reproduce() {
		RandomGenerator rgen = new RandomGenerator();
		//We can fiddle with the rate of reproduction-right now its a 50% chance
		int reproduce=rgen.nextInt(1,2);
		if(reproduce==1) {
			int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Kelp(new Location(newX,newY), myWorld));
		}
	}

}