package oceanecosystem;


import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(20,20);
		theWorld.getCreatureList().add( new Kelp( new Location(3,6), theWorld ));
		theWorld.getCreatureList().add( new Kelp( new Location(4,6), theWorld ));
		theWorld.getCreatureList().add( new Clam(new Location(5,8), theWorld ));
		theWorld.getCreatureList().add( new Minnow(new Location(6,2), theWorld));
		theWorld.getCreatureList().add( new Shark( new Location(7,5), theWorld));
		theWorld.getCreatureList().add( new Stingray( new Location(2,9), theWorld)); 
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
