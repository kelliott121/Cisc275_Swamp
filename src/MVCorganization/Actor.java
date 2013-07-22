package MVCorganization;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//TODO LIST
//add territory featurs such as last food position and last mate position
//add head readjustment with turning or any movement
//acount for "NONE" direction case in move
//1,000,000 other things that we didn't notice was fucked up with our code


//parameters: Direction dir, int speed, int size, boolean male, z, x, y, int sightRange, 
//            Collection<Actors> lineOfSight, BufferedImage picture
/**
 * This class allows for actions that the actors can take and interactions with the environment
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 */
public class Actor implements Comparable<Object>{
	public static AllActors actors;
	//USE FOR LOWEST LEVEL CLASSES
	public int size;
	public static short dayCount = -8192;
	
	public boolean staysInAll; //these will be used in the overwritten
	public boolean goesInWater;		// move function for each animal
	public boolean hitsObstacle;
	/**
	 * This method checks for obstacles by checking if the animal is in the bounds or going to hit the given bound
	 * @param newLoc This is the location of the current actor
	 */
	public void checkBounds(Rectangle newLoc){
		staysInAll = Background.allBounds.contains(newLoc);
		goesInWater = Background.waterBounds.contains(newLoc);
		for(Polygon a : Background.obstacles){
			if(a.intersects(newLoc))
				hitsObstacle = true;
		}
	}
	//LOCATION MANAGEMENT ATTRIBUTES*****************
	//all locations are pixel locations.  DecisionEngine will be aware of
	// the map boundaries
	public int z; //animal level
	//for middle of animal (virtually- actually top left of animal)
						//(this means we consider gridsize - length)
	public int x, y;
	//for front of animal, (make relative to middle coordinates)
		//these must be updated with direction changes
	/*
	 * public int xFront, yFront;
	 */
	/**
	 * This method obtains the rectangle around the current actor
	 * @return The method returns a rectangle with the x,y coordinates and the width and height of the current actor's picture
	 */
	public Rectangle getRectangle(){
		return new Rectangle(x, y, picture.getWidth(), picture.getHeight());
	}
	//if nothing in line of sight is edible, returns null

	public String name = new String();
	public String status;
	//SPRITE MANAGEMENT ATTRIBUTES***************
	public int frameCount = 12; //the number of pictures in each sequence
    public int picNum = 0; // the current picture in the sequence
    public int xLength = 165;
    public int yLength = 165;
    //These will be defined in specific animals' constructors
    //dirt has no image (but it does interact with plants)
    
    //Images are stored in the repository, except for the current image
    public BufferedImage picture = null;
    public BufferedImage lastPicture = null;
  
    //********************************************SPRITE**
    
	public void updateActorState() {
		// TODO Auto-generated method stub
		//this function needs to be overwritten in animal and plant
	}

	/**
	 * This method overrides the compareTo method
	 * @param o This takes in an object of any kind to be compared
	 * @return A value from -1 to 1 depending on the size of what is being compared and how
	 */
	@Override
	public int compareTo(Object o) {
		Actor a = (Actor)o;
		if (a == null || z < a.z)
			return -1;
		else if (z > a.z)
			return 1;
		else if (size < a.size)
			return -1;
		else if (size > a.size)
			return 1;
		else
			return 0;
	}
	/**
	 * This method finds the center of a given picture
	 * @return A point that correlates to the center of the picture
	 */
	public Point getCenter(){
		return new Point(x + picture.getWidth()/2, y + picture.getHeight()/2);
	}
    
    //remember that interactions are frame by frame, for us
    // example: something has to attack something and kill it before it can eat it
    //          each attack is one frame
    
    
    //if prey is a corpse, eat it. Otherwise, (a) get close enough to hurt it 
  									     // (b) hurt it until it's a corpse.
    //NOTE***: WE MUST READJUST HEAD COORDINATES SO IT CAN EAT THE PREY
	

	}
	/*//again, incorporates the whole sequence
	public void mate(Actor mate){
		
	}
	
	public void evolve(){
		
	}
	
	public void protects(Actor protectee){
		
	}
	*/
    


