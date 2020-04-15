package oceanecosystem;

import acm.util.RandomGenerator;

public class Shark extends Fish{
	
	public Shark(Location l, World w) {
		super(l,w);
		myLifeSpan = 10;
		speed=rgen.nextInt(3,8);
			 
		 }
		
	}

	public void reproduce(Shark x) {
		if(x.getAge() = 4){
			
			
	}
	
	public void double getSpeed(){
		return speed;	
	}	
	
	public boolean isNearPrey(Lifeform x){
		
		if(getElementAt(x.getMyLocation().getX(), x.getMyLocation().getY())= null ){
		return false;	
		}
			else if(getElementAt(x.getMyLocation().getX(), x.getMyLocation().getY())= ){
				return true;
			}
			else if(getElementAt(x.getMyLocation().getX(), x.getMyLocation().getY())= ){
				return true;
			}
			else{
				return false;
	}
		   
	
		
}
