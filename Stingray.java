package oceanecosystem;






import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public class Stingray extends Fish{
	RandomGenerator rgen = RandomGenerator.getInstance();

	public Stingray(Location l, World w) {
		super(l,w);
		myLifeSpan = 100;
		myColor = Color.GRAY;
		speed=rgen.nextInt(3,8);
	}
	
	public Stingray(Location l, World w, int s) {
		super(l,w);
		myLifeSpan = 100;
		myColor = Color.GRAY;
		speed=rgen.nextInt(s-3,s+3);
	}
	
	public Location hunt(ArrayList<LifeForm> creatureList) {
		Location targetLoc = null;
		boolean evading=false;
		for(LifeForm target : creatureList) {
			if(target.getType()=="Shark") {
				if(evading==false) {
					if(myLocation.distance(target.getMyLocation())<=15) {
						evading=true;
						int xDiff=myLocation.getX()-target.getMyLocation().getX();
						int yDiff=myLocation.getY()-target.getMyLocation().getY();
						targetLoc=new Location(myLocation.getX()+xDiff, myLocation.getY()+yDiff);
					}
				}
				else{
					if(myLocation.distance(target.getMyLocation())<myLocation.distance(targetLoc)) {
						int xDiff=myLocation.getX()-target.getMyLocation().getX();
						int yDiff=myLocation.getY()-target.getMyLocation().getY();
						targetLoc=new Location(myLocation.getX()+xDiff, myLocation.getY()+yDiff);
					}
				}
			}
			if(evading==false) {
				if(target.getType()=="Minnow" || target.getType()=="Clam") {
					if(targetLoc==null && target.getMyLocation().distance(myLocation)<=10) {
						targetLoc=target.getMyLocation();
					}
					else if(target.getMyLocation().distance(myLocation)<targetLoc.distance(myLocation)) {
						targetLoc=target.getMyLocation();
					}
				}
			}
		}
		if(targetLoc==null) {
			targetLoc=new Location(myLocation.getX()+(rgen.nextInt(-10, 10)), myLocation.getY()+(rgen.nextInt(-10, 10)));
		}
		return targetLoc;
	}
	
	//eats fish or clams if it touches it
		public void eat() {
			int eat = rgen.nextInt(1, 2);
			if (eat == 1) {
				for(LifeForm food : myWorld.getCreatureList()) {
					if(food.getMyLocation().getX()== myLocation.getX() && food.getMyLocation().getY()== myLocation.getY() && fed==false) {
						if(food.getType()=="Clam"||food.getType()=="Minnow") {
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
			if (newX >= 0 && newX <= 50 && newY >= 0 && newY <= 50){
				myWorld.getCreatureList().add(new Stingray(new Location(newX,newY), myWorld, speed));
			}
		}
		
		
	}
	
	public String getType() {
		return "Stingray";
	}
}
