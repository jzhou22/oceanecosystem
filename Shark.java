package oceanecosystem;

import acm.util.RandomGenerator;

public class Shark extends Fish{
	
	public Shark(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		 vx = rgen.nextDouble(1.0, 3.0);
		 if (rgen.nextBoolean(0.5)){
    		 vx = -vx;
		 }
		vy = rgen.NextDouble(1.0,3.0);
		if(rgen.nextBoolean(0.5)){
			vy = -vy;
		}
		
	}

	public void reproduce() {
		
		
	}
}
