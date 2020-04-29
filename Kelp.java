package oceanecosystem;

import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public class Kelp extends Plant {
	
	public Kelp(Location l, World w) {
		super(l,w);
		myLifeSpan = 5;
		myColor = Color.GREEN;
	}
	
	public void reproduce() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		//We can fiddle with the rate of reproduction-right now its a 50% chance
		int reproduce=rgen.nextInt(1,5);
		if(reproduce==1) {
			while(true) {
				int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
				int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
				if (newX >= 0 && newX <= 50 && newY >= 0 && newY <= 50){
					myWorld.getCreatureList().add(new Kelp(new Location(newX,newY), myWorld));
					break;
				}
			}
			
		}
	}
	
	public void eat() {
		
	}

	public String getType() {
		return "Kelp";
	}
}
