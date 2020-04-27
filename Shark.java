package oceanecosystem;




import acm.util.RandomGenerator;
import acm.program.*;
import acm.util.*;
import java.awt.Color;

import acm.graphics.*;

public class Shark extends Fish {
	RandomGenerator rgen = RandomGenerator.getInstance();
	public Shark(Location l, World w) {
		super(l, w);
		myLifeSpan = 100;
		myColor = Color.BLUE;
		speed = rgen.nextInt(5, 10);

	}
	
	public Shark(Location l, World w, int s) {
		super(l, w);
		myLifeSpan = 100;
		myColor = Color.BLUE;
		speed = rgen.nextInt(s-3, s+3);

	}
	
	public Location hunt() {
			return null;
	}
	
	//eats fish or stingrays if it touches it
	public void eat() {
		int eat = rgen.nextInt(1, 2);
		if (eat == 1) {
			for(LifeForm food : myWorld.getCreatureList()) {
				if(food.getMyLocation().getX()== myLocation.getX() && food.getMyLocation().getY()== myLocation.getY() && fed==false) {
					if(food.getType()=="Stingray"||food.getType()=="Minnow") {
						food.kill();
						fed=true;
					}
				}
			}
		}
	}
	
	public void reproduce() {
		if (myAge >= 1 && fed==true) {
			fed=false;
			int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Shark(new Location(newX,newY), myWorld, speed));
		}

	}

	public String getType() {
		return "Shark";
	}

	public boolean isNearPrey() {

		for (LifeForm prey : myWorld.getCreatureList()) {
			if (getMyLocation() == prey.getMyLocation() && prey.getType() == "Stingray") {
				return true;
			} else if (getMyLocation() == prey.getMyLocation() && prey.getType() == "Minnow") {
				return true;
			}
		}
		return false;
	}

}
