package oceanecosystem;




import java.util.ArrayList;

import acm.util.RandomGenerator;

public class World {
	/*
	 * hello did this go to the repository
	 */
	
	
	private int width;
	private int height;
	private ArrayList<LifeForm> creatureList;
	private RandomGenerator rgen = new RandomGenerator();
	
	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}
	
	public void letTimePass(){
		
		makeNewCreatures();
//		eatThings();
		creaturesGetOlder();
		purgeTheDead();		
//		moveGeneral();
	}
	// general movement code that can be applied to every creature at once
	public void moveGeneral(){
		int currentSizeOfCreatureList = getCreatureList().size();
		int xPosition;
		int yPosition;
		
			for(int i=0; i< currentSizeOfCreatureList; i++) {
				xPosition = creatureList.get(i).getMyLocation().getX();
				yPosition = creatureList.get(i).getMyLocation().getY();
				
				//random generator for movement anywhere between certain bounds
				xPosition += rgen.nextInt(-3,3);
				yPosition += rgen.nextInt(-3,3);
				creatureList.get(i).setMyLocation(new Location (xPosition, yPosition));
				
			}
	}
	
	public void makeNewCreatures() {
		
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is "+currentSizeOfCreatureList);
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
			creatureList.get(i).eat();
		}
	}
	
	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}	
	}
	
	public void creaturesGetOlder(){
		for( LifeForm l:creatureList){
			l.age(1);
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
}
