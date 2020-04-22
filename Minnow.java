package oceanecosystem;





import java.awt.Color;

import acm.util.RandomGenerator;

public class Minnow extends Fish{
	RandomGenerator rgen = RandomGenerator.getInstance();
	public Minnow(Location l, World w) {
		super(l,w);
		myLifeSpan = 100;
		myColor = Color.RED;
		speed=rgen.nextInt(1,5);
		
	}
	public Minnow(Location l, World w, int s) {
		super(l,w);
		myLifeSpan = 100;
		myColor = Color.RED;
		speed=rgen.nextInt(s-1,s+3);
		
	}
	
	public Location hunt() {
			
	}
	
	//eats kelp if it touches it
	public void eat() {
		int eat = rgen.nextInt(1, 2);
		if (eat == 1) {
			for(LifeForm food : myWorld.getCreatureList()) {
				if(food.getMyLocation().getX()== myLocation.getX() && food.getMyLocation().getY()== myLocation.getY() && food.getType()=="Kelp" && fed==false) {
					food.kill();
					fed=true;
				}
			}
		}
	}
	public void reproduce() {
		if (myAge == 1 && fed==true) {
			fed=false;
			int newX = (int)(myLocation.getX()+(rgen.nextInt(-5,5)));
			int newY = (int)(myLocation.getY()+(rgen.nextInt(-5,5))); 
			myWorld.getCreatureList().add(new Minnow(new Location(newX,newY), myWorld, speed));
		}
		
		
<<<<<<< HEAD
	}

	
					
	

=======
	}	
>>>>>>> e68cd582a5d96ebe397cb90df40ddabcffe86e6b
	
	public String getType() {
		return "Minnow";
	}
}
