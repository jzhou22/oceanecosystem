package oceanecosystem;




import java.awt.Color;

import acm.util.RandomGenerator;

public class Minnow extends Fish{
	
	public Minnow(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 100;
		myColor = Color.RED;
		speed=rgen.nextInt(1,5);
		
	}

	public void reproduce() {
		RandomGenerator loc = RandomGenerator.getInstance();
		if (myAge == 1) {
			int newX = (int)(myLocation.getX()+(loc.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(loc.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Minnow(new Location(newX,newY), myWorld));
		}
		
		
	}
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
	
	
	public String getType() {
		return "Minnow";
	}
}
