package oceanecosystem;



import java.awt.Color;

import acm.util.RandomGenerator;

public class Stingray extends Fish{
	
	public Stingray(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 100;
		myColor = Color.GRAY;
		speed=rgen.nextInt(3,8);
	}

	public void reproduce() {
		RandomGenerator loc = RandomGenerator.getInstance();
		if (myAge == 1) {
			int newX = (int)(myLocation.getX()+(loc.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(loc.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Stingray(new Location(newX,newY), myWorld));
		}
		
		
	}
	
	public String getType() {
		return "Stingray";
	}
}
