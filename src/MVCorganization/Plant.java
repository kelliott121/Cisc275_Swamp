package MVCorganization;

import java.awt.Rectangle;
import java.util.Random;


//this class is really just a wrapper for other plants.
//it'll be handy for checking instanceof though.
/**
 * This class allows plants to exhibit different behaviors from animals but is still a living actor
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 * 
 */
public abstract class Plant extends Living{
	public boolean isSeed;
	public boolean isFlowering;
	protected int seedTime;
	protected int flowerTime;
	protected int seedRange;
	/**
	 * overrides the toString method
	 */
	public String toString(){
	return new String(	"Name: " + name + "\n" +
			"Health: " + (hp.getCurr() - hp.getDeathThresh()) + "/" + (hp.getMax() - hp.getDeathThresh()));
	}
	
	//override in subclasses to reproduce
	/**
	 * Updates the status of the plants and sets priorities
	 */
	public void updatePlantState(){
		age();
		if(isSeed && (count > seedTime)){
				isSeed = false;
				count = 0;
		}
		else if(count > flowerTime){ //set this to false once it reproduces
				isFlowering = true;
				count = 0;
		}
	}
	
	
	/**
	 * function to check whether a plant can place a seed at a certain location
	 * 
	 * @param dir integer direction
	 * @param distance integer distance
	 */
	private Rectangle getPlacementBounds(int dir, int distance){
		hitsObstacle = false;
		Rectangle curr = getRectangle();
		
		switch(dir){
			case Animal.N:
				curr.translate(0, - distance);
				checkBounds(curr);
				break;
			case Animal.S:
				curr.translate(0, + distance);
				checkBounds(curr);
				break;
			case Animal.NE:
				curr.translate((int)(.866*distance), -(int)(.5*distance));
				checkBounds(curr);
				break;
			case Animal.NW:
				curr.translate(-(int)(.866*distance), -(int)(.5*distance));
				checkBounds(curr);
				break;
			case Animal.SE:
				curr.translate((int)(.866*distance), (int)(.5*distance));
				checkBounds(curr);
				break;
			case Animal.SW:
				curr.translate(-(int)(.866*distance), (int)(.5*distance));
				checkBounds(curr);
				break;
		}
		return curr;
	} //end getPlacementBounds
	/**
	 * Checks if plant can have a seed in the area
	 * @return 
	 */
	public boolean canPlace(){
		if(staysInAll && !goesInWater && !hitsObstacle){
			return true;
		}
		else return false;
	}
	/**
	 * Places seed in a certain area 
	 * @return the area if it is able to place otherwise null
	 */
	private Rectangle placeSeed(){
		isFlowering = false;
		boolean canPut = false;
		int chances = 4;
		Random r = new Random();
		
		//these will be randomly generated in the loop
		int direction;
		int distance;
		Rectangle a = this.getRectangle();
		
		while(!canPut && chances > 0){
			chances--;
			direction = r.nextInt(6);
			distance = (seedRange/2) + r.nextInt(seedRange/2);
			a = getPlacementBounds(direction, distance);
			canPut = canPlace(); //a is the current rectangle considered in the bools
		}
		return a; //if the seedPlacement failed, location won't change.
	}
	
	//THIS MUST BE OVERWRITTEN IN EVERY SUBCLASS
	/**
	 * Creates a reproduction function
	 */
	protected Plant reproduce(int x, int y){
		return null;
	}
	/**
	 * Creates a warpper for plants to use to reproduce
	 * @return
	 */
	public Plant reproduceWrapper(){
		Rectangle rect = placeSeed();
		Rectangle checkNotSame = getRectangle();
		if(rect != checkNotSame)
			return this.reproduce(rect.x, rect.y);
		else
			return this;
	}
	
}
