package oceanecosystem;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Fish extends LifeForm{
	protected int speed;
	protected boolean fed;
	public Fish(Location loc, World w) {
		super(loc, w);
	}
	
	public void move(Location loc) {
		if(loc.getX()>myLocation.getX()) {
			if(loc.getY()>myLocation.getY()) {
				//x+ y+
				if(trueDistance(loc.getX()-myLocation.getX(),loc.getY()-myLocation.getY())<speed) {
					myLocation=loc;
				}
				else {
					double xMoves=(loc.getX()-myLocation.getX());
					double yMoves=(loc.getY()-myLocation.getY());
					double moveK= (xMoves+yMoves)/speed;
					for(int i=0; i<speed; i++) {
						if(xMoves>yMoves) {
							myLocation.setX(myLocation.getX()+1);
							xMoves-=moveK;
						}
						else {
							myLocation.setY(myLocation.getX()+1);
							yMoves-=moveK;
						}
					}
				}
			}
			else {
				//x+ y-
				if(trueDistance(loc.getX()-myLocation.getX(),myLocation.getY()-loc.getY())<speed) {
					myLocation=loc;
				}
				else {
					double xMoves=(loc.getX()-myLocation.getX());
					double yMoves=(myLocation.getY()-loc.getY());
					double moveK= (xMoves+yMoves)/speed;
					for(int i=0; i<speed; i++) {
						if(xMoves>yMoves) {
							myLocation.setX(myLocation.getX()+1);
							xMoves-=moveK;
						}
						else {
							myLocation.setY(myLocation.getX()-1);
							yMoves-=moveK;
						}
					}
				}
			}
		}
		else if(loc.getY()>myLocation.getY()) {
			//x- y+
			if(trueDistance(myLocation.getX()-loc.getX(),loc.getY()-myLocation.getY())<speed) {
				myLocation=loc;
			}
			else {
				double xMoves=(myLocation.getX()-loc.getX());
				double yMoves=(loc.getY()-myLocation.getY());
				double moveK= (xMoves+yMoves)/speed;
				for(int i=0; i<speed; i++) {
					if(xMoves>yMoves) {
						myLocation.setX(myLocation.getX()-1);
						xMoves-=moveK;
					}
					else {
						myLocation.setY(myLocation.getX()+1);
						yMoves-=moveK;
					}
				}
			}
		}
		else {
			//x- y-
			if(trueDistance(getMyLocation().getX()-loc.getX(),getMyLocation().getY()-loc.getY())<speed) {
				myLocation=loc;
			}
			else {
				double xMoves=(myLocation.getX()-loc.getX());
				double yMoves=(myLocation.getY()-loc.getY());
				double moveK= (xMoves+yMoves)/speed;
				for(int i=0; i<speed; i++) {
					if(xMoves>yMoves) {
						myLocation.setX(myLocation.getX()-1);
						xMoves-=moveK;
					}
					else {
						myLocation.setY(myLocation.getX()-1);
						yMoves-=moveK;
					}
				}
			}
		}
		
		
	}
	public abstract Location hunt(ArrayList<LifeForm> creatureList);
	public double trueDistance(int x, int y) {
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	public double getSpeed() {
		return speed;
	}
	
	
}
