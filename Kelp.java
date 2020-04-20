package oceanecosystem;




import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public class Kelp extends Plant {
	
	public Kelp(Location l, World w) {
		super(l,w);
<<<<<<< HEAD
		myLifeSpan = 5;
		myColor = Color.GREEN;
=======
		myLifeSpan = 3;
>>>>>>> af25ca823e4f18544cf58e293d81e74218d48313
	}
	
	public void reproduce() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		//We can fiddle with the rate of reproduction-right now its a 50% chance
		int reproduce=rgen.nextInt(1,3);
		if(reproduce==1) {
			int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Kelp(new Location(newX,newY), myWorld));
		}
	}

	public String getType() {
		return "Kelp";
	}
}
