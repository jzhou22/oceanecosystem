package oceanecosystem;

import java.awt.Color;

import acm.util.RandomGenerator;

public class Clam extends LifeForm {
	protected boolean fed;
	protected int reach;
	RandomGenerator rgen = RandomGenerator.getInstance();
	public Clam(Location l, World w) {
		super(l, w);
		myLifeSpan = 20;
		myColor = Color.CYAN;
		reach= rgen.nextInt(5,10);
	}
	public Clam(Location l, World w, int r) {
		super(l, w);
		myLifeSpan = 20;
		myColor = Color.CYAN;
		reach= rgen.nextInt(r-2,r+2);
	}

	// eats kelp in a radius if it is not fed
	public void eat() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		for (int x = 0; x < reach; x++) {
			for (int y = 0; y < reach; y++) {
				int eat = rgen.nextInt(1, 2);
				if (eat == 1) {
					for(LifeForm food : myWorld.getCreatureList()) {
						if(food.getMyLocation().getX()== x && food.getMyLocation().getY()== y && food.getType()=="Kelp" && fed==false) {
							food.kill();
							fed=true;
						}
					}
				}
			}
		}
	}

	public void reproduce() {
		RandomGenerator loc = RandomGenerator.getInstance();
		if (myAge >= 1 && fed==true) {
			fed=false;
			while(true) {
				int newX = (int)(myLocation.getX()+(loc.nextInt(-5,5)));
				int newY = (int)(myLocation.getY()+(loc.nextInt(-5,5))); 
				if (newX >= 0 && newX <= 50 && newY >= 0 && newY <= 50){
					myWorld.getCreatureList().add(new Clam(new Location(newX,newY), myWorld, reach));
					break;
				}
			}
			
		}

	}

	public String getType() {
		return "Clam";
	}
}
