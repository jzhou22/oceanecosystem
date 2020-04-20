package oceanecosystem;




import java.awt.Color;

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
		if (myAge == 1 && fed==true) {
			fed=false;
			int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Stingray(new Location(newX,newY), myWorld, speed));
		}
		
		
	}
	
	public String getType() {
		return "Stingray";
	}
}
