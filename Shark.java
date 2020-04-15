package oceanecosystem;

import acm.util.RandomGenerator;

import java.awt.Color;

import acm.graphics.*;
public class Shark extends Fish{
	
	public Shark(Location l, World w) {
		super(l,w);
		RandomGenerator rgen = RandomGenerator.getInstance();
		myLifeSpan = 10;
		myColor = Color.BLUE;
		speed=rgen.nextInt(3,8);
			 
		 
		
	}

	public void reproduce() {
		if(myAge == 4){
		}
			
	}
	
	public double getSpeed(){
		return speed;	
	}	
	
	public boolean isNearPrey(){
		
		if(getElementAt(myLocation.getX(), myLocation.getY())== null ){
		return false;	
		}
		else if(getElementAt(myLocation.getX(), myLocation.getY())==null ){
			return true;
		}
		else if(getElementAt(myLocation.getX(), myLocation.getY())==null ){
			return true;
		}
		else{
			return false;
		}
	}	
	
	public String getType() {
		return "Shark";
	}
}
