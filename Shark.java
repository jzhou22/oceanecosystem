package oceanecosystem;

import acm.util.RandomGenerator;
import acm.program.*;
import acm.util.*;
import java.awt.Color;

import acm.graphics.*;

public class Shark extends Fish {

	public Shark(Location l, World w) {
		super(l, w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		myColor = Color.BLUE;
		speed = rgen.nextInt(3, 8);

	}

	public void reproduce() {
		if (myAge == 4) {
			
		}

	}

	public double getSpeed() {
		return speed;
	}

	public String getType() {
		return "Shark";

	}

	public boolean isNearPrey() {

		for (LifeForm prey : myWorld.getCreatureList()) {
			if (getMyLocation()== prey.getMyLocation() && prey.getType() == "Stingray") {
				return true;
			} else if (getMyLocation()== prey.getMyLocation() && prey.getType() == "Minnow") {
				return true;
			}
		}
		return false;

	}

}
