package oceanecosystem;

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 500;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(50,50);
		theWorld.getCreatureList().add( new Kelp( new Location(10,6), theWorld ));
		theWorld.getCreatureList().add( new Kelp( new Location(4,6), theWorld ));
		theWorld.getCreatureList().add( new Kelp( new Location(6,7), theWorld ));
		theWorld.getCreatureList().add( new Kelp( new Location(2,6), theWorld ));
		theWorld.getCreatureList().add( new Clam(new Location(25,25), theWorld ));
		theWorld.getCreatureList().add( new Minnow(new Location(5,10), theWorld));
		theWorld.getCreatureList().add( new Minnow(new Location(5,11), theWorld));
		theWorld.getCreatureList().add( new Minnow(new Location(5,12), theWorld));
		theWorld.getCreatureList().add( new Minnow(new Location(5,13), theWorld));
		theWorld.getCreatureList().add( new Shark( new Location(50,50), theWorld));
		theWorld.getCreatureList().add( new Stingray( new Location(30,30), theWorld)); 
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		while(theWorld.getCreatureList().size()>0) {
			theWorld.letTimePass();
			pause(500);
			drawWorld();
			
		}
	}	
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
