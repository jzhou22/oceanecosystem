package oceanecosystem;




import acm.util.RandomGenerator;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.*;

public class Shark extends Fish {
	RandomGenerator rgen = RandomGenerator.getInstance();
	public Shark(Location l, World w) {
		super(l, w);
		myLifeSpan = 50;
		myColor = Color.BLUE;
		speed = rgen.nextInt(5, 10);

	}
	
	public Shark(Location l, World w, int s) {
		super(l, w);
		myLifeSpan = 50;
		myColor = Color.BLUE;
		speed = rgen.nextInt(s-3, s+3);

	}
	
	public Location hunt(ArrayList<LifeForm> creatureList) {
		Location targetLoc = null;
			for(LifeForm target : creatureList) {
				if(target.getType()=="Minnow" || target.getType()=="Stingray") {
					if(targetLoc==null) {
						if(target.getMyLocation().distance(myLocation)<=15) {
							targetLoc=target.getMyLocation();
						}
					}
					else if(target.getMyLocation().distance(myLocation)<targetLoc.distance(myLocation)) {
						targetLoc=target.getMyLocation();
					}
				}
			}
			if(targetLoc==null) {
				targetLoc=new Location(myLocation.getX()+(rgen.nextInt(-10, 10)), myLocation.getY()+(rgen.nextInt(-10, 10)));
			}
			return targetLoc;
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
			while(true) {
				int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
				int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
				if (newX >= 0 && newX <= 50 && newY >= 0 && newY <= 50){
					myWorld.getCreatureList().add(new Shark(new Location(newX,newY), myWorld, speed));
					break;
				}
			}
			
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
