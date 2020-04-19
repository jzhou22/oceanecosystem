package oceanecosystem;

import java.awt.Color;

import acm.util.RandomGenerator;

public class Clam extends LifeForm {

	public Clam(Location l, World w) {
		super(l, w);
		myLifeSpan = 10;
		myColor = Color.CYAN;
	}

	// eats kelp in a 5x5 radius
	public void eat() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				int eat = rgen.nextInt(1, 2);
				if (eat == 1) {
					for(LifeForm food : myWorld.getCreatureList()) {
						if(food.getMyLocation().getX()== x && food.getMyLocation().getY()== y) {
							food.kill();	
						}
					}
					
				}
			}
		}
	}

	public void reproduce() {
		RandomGenerator loc = RandomGenerator.getInstance();
		if (myAge == 1) {
			int newX = (int)(myLocation.getX()+(loc.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(loc.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Clam(new Location(newX,newY), myWorld));
		}

	}

	public String getType() {
		return "Clam";
	}
}
