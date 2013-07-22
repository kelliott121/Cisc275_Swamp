package MVCorganization;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;

import Animals.*;
//import Animals.Butterfly;
/**
 * This class contains all interactions that animals are capable of doing
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 */
public abstract class Animal extends Living{
	final static int FLEE = 0;
	final static int EAT = 1;
	final static int POOP = 2;
	protected final static int MATE = 3;
	final static int REST = 4;
	
	public final static int underWater = 0;
	public final static int onWater = 1;
	public final static int onGround = 2;
	public final static int inAir = 3;
	
	public final int dayLength = 24000;

	public static int numAnimals = 0;
	
	public int gestateCount = 0;
	public int gestateTime = 100;
	
	public int age = 0;
	protected int damage; //how much the animal can hurt another animal per frame
	protected int attackRange; //how far an animal can reach
	public boolean threatened = false;
	public boolean male;
	public int stamina;
	public int timeSincePoo = 0;
	public int actionCount = 0;
	public int priority; //this might need to be moved to Active things
	public BufferedImage deadImage; //NOTE!!!: Plants still need dead images as well
	//With the generic corpse we won't need a dead image but rather a generator for a new corpse
	//With the animal's dead health
	public boolean corpse = false;

	public int turnCount;
	public int turnTime = 3;
	public int dir; //enum-globals
	public int sightRange;
	
	
	final static int N = 0;
	final static int NE = 1;
	final static int NW = 2;
	final static int S = 3;
	final static int SE = 4;
	final static int SW = 5;
	final static int frameCount = 12;
	
	public int speed;
	
	public Collection<String> prey = new ArrayList<String>();
	public Collection<String> predators= new ArrayList<String>();
	/**
	 * This method overrides the toString method
	 * @return a string
	 */
	@Override
	public String toString(){
		String gender;
		if (male)
			gender = new String("Male");
		else
			gender = new String("Female");
		
		String prior = null;
		
		if (corpse)
			prior = "Dead";
		else
			switch (priority){
			case FLEE:
				if (threatened)
					prior = new String("Flee");
				else
					prior = new String("Avoid");
				break;
			case EAT:
				prior = new String("Food");
				break;
			case POOP:
				prior = new String("Defecate");
				break;
			case MATE:
				prior = new String("Make Babies");
				break;
			case REST:
				prior = new String("Sleep");
				break;
		}
			
		return new String(	"Name: " + name + "\n" +
							"Gender: " + gender + "\n" +
							"Health: " + (hp.getCurr() - hp.getDeathThresh()) + "/" + (hp.getMax() - hp.getDeathThresh()) + "\n" +
							"Priority: " + prior + "\n" +
							"Status: " + status + "\n" +
							"Age: " + age
		);
	}
	/**
	 * This method prints the number of  all animals as well as each animal
	 * @return a string with the number all animals as well as each animal
	 */
	public static String printStats(){
		
		return new String("Living Animals: " + numAnimals + "\n\n" +
				"Alligators: " + Alligator.number + "\t" +
				"Crayfish: " + Crayfish.number + "\n" +
				"Crickets: " + Cricket.number + "\t\t" +
				"Dragonflies: " + Dragonfly.number + "\n" +
				"Ducks: " + Duck.number + "\t\t" +
				"Egrets: " + Egret.number + "\n" +
				"Flies: " + Fly.number + "\t\t" +
				"Frogs: " + Frog.number + "\n" +
				"Grasshoppers: " + Grasshopper.number + "\t" +
				"Herons: " + Heron.number + "\n" +
				"Moccassins: " + Moccassin.number + "\t" +
				"Mice: " + Mouse.number + "\n" +
				"Nutria Rats: " + NutriaRat.number + "\t" +
				"Perch: " + Perch.number + "\n" +
				"Possum: " + Possum.number + "\t\t" +
				"Raccoons: " + Raccoon.number + "\n" +
				"Salamander: " + Salamander.number + "\t" +
				"Slug: " + Slug.number + "\n" +
				"Snapping Turtles: " + SnappingTurtle.number + "\t" +
				"Tadpoles: " + Tadpole.number + "\n" +
				"Worms: " + Worm.number + "\t\t" +
				"Catfish: " + Catfish.number + "\t\t" +
				"Bees: " + Bee.number// + "\t\t" +
				//"Butterflies" + Butterfly.number + "\t\t"
				);
	}
	/**
	 * Creates a vector of strings
	 * @return the vector of stats
	 */
	public static Vector<String> toVector(){	
		Vector<String> stats = new Vector<String>();
		stats.add("Living Animals: " + numAnimals + "   ");
		stats.add("Alligators: " + Alligator.number);
		stats.add("Bees: " + Bee.number);
		stats.add("Butterflies" + Butterfly.number);
		stats.add("Ducks: " + Duck.number);
		stats.add("Flies: " + Fly.number);
		stats.add("Frogs: " + Frog.number);
		stats.add("Herons: " + Heron.number);
		stats.add("Moccassins: " + Moccassin.number);
		stats.add("Mice: " + Mouse.number);
		stats.add("Nutria Rats: " + NutriaRat.number);
		stats.add("Perch: " + Perch.number);
		stats.add("Possums: " + Possum.number);
		stats.add("Raccoons: " + Raccoon.number);
		stats.add("Newts: " + Salamander.number);
		stats.add("Slug: " + Slug.number);
		stats.add("Turtles: " + SnappingTurtle.number);
		stats.add("Tadpoles: " + Tadpole.number);
		stats.add("Catfish: " + Catfish.number);
		
		return stats;
}
	/**
	 * Finds closest item that calling actor can eat
	 * @return closest edible item
	 */
	public Actor closestEdible(){
		Collection<Actor> lineOfSight = new ArrayList<Actor>();
		for (int i = this.size; i >= 0; i--){
			Collection<Actor> tempSize = actors.array.get(i);
			for (Actor a:tempSize){
				if (a != this && prey.contains(a.name) && distance(a) < sightRange)
					lineOfSight.add(a);
			}
		}
		Actor choice = null;
		if(!lineOfSight.isEmpty()){
			for (Actor a:lineOfSight){
				if (distance(choice) > distance(a)){
					choice = a;
				}
			}
		}
		return choice;
	}
	/**
	 * Finds the closest actor that will eat the calling actor
	 * @return the closest predator of the calling actor
	 */
	public Actor closestScary(){
		Collection<Actor> lineOfSight = new ArrayList<Actor>();
		for (int i = this.size; i<actors.maxSize; i++){
			Collection<Actor> tempSize = actors.array.get(i);
			for (Actor a:tempSize){
				if (a.x != this.x && a.y != this.y && predators.contains(a.name) && distance(a) < sightRange)
					lineOfSight.add(a);
			}
		}
		Actor choice = null;
		if(!lineOfSight.isEmpty()){
			for (Actor a:lineOfSight){
				if (distance(choice) > distance(a)){
					choice = a;
				}
			}
		}
		return choice;
	}
	/**
	 * Finds the closest similar actor of the opposite gender
	 * @return closest animal that actor can mate with 
	 */
	public Animal closestMateable(){
		Collection<Animal> lineOfSight = new ArrayList<Animal>();
		ArrayList<Actor> tempSize = actors.array.get(size);
		for (Actor a:tempSize){
			if (a.x != this.x && a.y != this.y && a.name.equals(this.name) && distance(a) < sightRange && !((Animal)a).male && ((Animal)a).priority == MATE && !((Animal)a).corpse && ((Animal)a).gestateCount == 0)
				lineOfSight.add((Animal)a);
		}
		
		Animal choice = null;
		if(!lineOfSight.isEmpty()){
			for (Animal a:lineOfSight){
				if (distance(choice) > distance(a)){
					choice = a;
				}
			}
		}
		return choice;
	}
	/**
	 * This method finds the distance between the mouth of a current actor and the center of another 
	 * @param taco actor to find the distance to from the calling actor
	 * @return the distance from current actor to passed actor
	 */
	public int distance(Actor taco){
		if (taco != null && taco.picture != null && this.picture != null)
			//return (int)Math.sqrt((Math.pow((taco.x - this.x), 2) + Math.pow((taco.y - this.y),2)));
			return (int) this.getMouth().distance(((Actor)taco).getCenter());
		else
			return 100000;
	}
	//***************************************LOCATION
	/**
	 * This causes the animal to become corpses
	 */
	public void die(){
		corpse = true;
		picture = lastPicture;
		status = "Decaying";
		numAnimals--;
		}
	/**
	 * This allows the animals to age and loose health
	 * it also updates the priorities based on certain parameters
	 */
	public void updateAnimalState(){
		hp.lose(1); //things gradually get hungry
		//tiredness++; //goes with rest
		//timeSincePoo++;
		age++;
		turnCount--;
		
		if(!corpse){
			//change to corpse Actor.die(); We'll use polymorphism to use specific death methods
			//for now, there's a corpse bool
			if (hp.getCurr() < hp.getDeathThresh()){
				die();
			}
			
			if (gestateCount > 0)
				if (--gestateCount == 0)
					makeBaby();
					
		
			//update priorities
			if(threatened){
				priority = FLEE;
			}
			else if(hp.getCurr() < hp.getHungerThresh()){
				priority = EAT;
			}
			else if(hp.getCurr() > hp.getReproThresh()){
				priority = MATE;
			}
			else if(timeSincePoo > dayLength/2){
				priority = POOP; //can't be used until there's an action to reset timeSincePoo
			}
	//		else if(tiredness > dayLength){  //can't be used until there's an action to reset tiredness
	//			priority = REST;
	//		}
			else{
				priority = FLEE; //not a bad default, I think
			}
		}
	}
	//*****************************************HEALTH**
	/**
	 * This gets the point where the mouth of the current animal is
	 * @return the point where the mouth is on the animal dependent on the direction the animal is facing 
	 * 
	 */
	public Point getMouth(){	
		switch (dir){
		case N:
			return new Point(x + picture.getWidth()/2, y);
		case NE:
			return new Point(x + picture.getWidth(), y);
		case SE:
			return new Point(x + picture.getWidth(), y + picture.getHeight());
		case S:
			return new Point(x + picture.getWidth()/2, y + picture.getHeight());
		case SW:
			return new Point(x, y + picture.getHeight());
		case NW:
			return new Point(x, y);
		}
		return null;
	}
	/**
	 * This will cause the calling actor to eat a living actor
	 * also incorporates a battle aspect
	 * @param b The living actor that will be eaten
	 */
	public void eat(Living b){
		if(b == null)
			moveRandom();
		else{
			int dist = this.distance(b);
			//System.out.println(name + " is " + dist + " from " + b.name);
			if (dist > (b.picture.getWidth()/2)){
				chase(b);
				//System.out.println(name + " chasing " + b.name);
				status = new String("Hunting " + b.name);
				}
			else{
				//System.out.println(name + " eating " + b.name);
				status = new String("Eating " + b.name);
				b.hp.lose(damage);
				if(b instanceof Animal){
					((Animal)b).threatened = true;
					if(((Animal)b).corpse)
						this.hp.gain(damage);
				}
				else //b is an instance of Plant
					this.hp.gain(damage);
			}
		}
	}
	/**
	 * Changes the direction of the calling actor
	 * @param rightWay an integer corresponding to a certain cardinal or intermediate direction
	 */
	public void changeDir(int rightWay){
		if (rightWay == dir || turnCount > 0)
			return;
		
		switch(rightWay){
		case N:
			if (dir == NW || dir == NE)
				dir = N;
			else if (dir == SE)
				dir = NE;
			else if (dir == SW)
				dir = NW;
			else if (dir == S)
				dir = SW;
		break;
		case NE:
			if (dir == N || dir == SE)
				dir = NE;
			else if (dir == NW)
				dir = N;
			else if (dir == S)
				dir = SE;
			else if (dir == SW)
				dir = NW;
		break;
		case SE:
			if (dir == NE || dir == S)
				dir = SE;
			else if (dir == N)
				dir = NE;
			else if (dir == SW)
				dir = S;
			else if (dir == NW)
				dir = N;
		break;
		case S:
			if (dir == SW || dir == SE)
				dir = S;
			else if (dir == NE)
				dir = SE;
			else if (dir == NW)
				dir = SW;
			else if (dir == N)
				dir = NE;
		break;
		case SW:
			if (dir == NW || dir == S)
				dir = SW;
			else if (dir == N)
				dir = NW;
			else if (dir == SE)
				dir = S;
			else if (dir == NE)
				dir = SE;
		break;
		case NW:
			if (dir == SW || dir == N)
				dir = NW;
			else if (dir == NE)
				dir = N;
			else if (dir == S)
				dir = SW;
			else if (dir == SE)
				dir = S;
		break;
		}
		turnCount = turnTime;
	}
	/**
	 * Sets the direction that the actor wishes to go
	 * @param a actor that is the target of calling actor
	 * @return a direction
	 */
	public int goalDir(Actor a){
		Point myMid = this.getMouth();
		Point goalMid = a.getCenter();
		
		if (a.name == this.name && goalMid.x == myMid.x && goalMid.y == myMid.y)
			return dir;
		
		if ((goalMid.y - myMid.y) > 0){
			if (goalMid.x - myMid.x < 0)
				return SW;
			else if (goalMid.x - myMid.x > 0)
				return SE;
			else
				return S;
		}
		else{
			if (goalMid.x - myMid.x < 0)
				return NW;
			else if (goalMid.x - myMid.x > 0)
				return NE;
			else
				return N;
		}
	}
	/**
	 * Changes the direction to the exact opposite of the one the calling actor is currently facing
	 * @param dir integer corresponding to the current direction
	 * @return a new direction opposite of the passed one
	 */
	public int oppositeDir(int dir){
		switch(dir){
		case N:
			return S;
		case NE:
			return SW;
		case NW:
			return SE;
		case SE:
			return NW;
		case SW:
			return NE;
		default:
			return N;
		}
	}
	/**
	 * Causes the calling actor to chase the passed actor
	 * @param a the actor that will be chased by the calling actor
	 */
	public void chase(Actor a){
		if(a == null)
			moveRandom();
		else{
			changeDir(goalDir(a));
			move();
		}
	
	}
	/**
	 * Causes the calling actor to run away from the passed actor
	 * @param a the actor that the calling actor will flee from
	 */
	public void flee(Actor a){
		if(a != null){
			changeDir(oppositeDir(goalDir(a)));
			move();
		}
		else
			moveRandom();
	}
	/**
	 * Causes the calling actor to move in a given direction
	 */
	public void move(){
		hitsObstacle = false;

		if (picture != null){
		Rectangle curr = getRectangle();
		
			switch(dir){
				case N:
					curr.translate(0, -getSpeed());
					checkBounds(curr);
					break;
				case S:
					curr.translate(0, getSpeed());
					checkBounds(curr);
					break;
				case NE:
					curr.translate((int)(.866*getSpeed()), -(int)(.5*getSpeed()));
					checkBounds(curr);
					break;
				case NW:
					curr.translate(-(int)(.866*getSpeed()), -(int)(.5*getSpeed()));
					checkBounds(curr);
					break;
				case SE:
					curr.translate((int)(.866*getSpeed()), (int)(.5*getSpeed()));
					checkBounds(curr);
					break;
				case SW:
					curr.translate(-(int)(.866*getSpeed()), (int)(.5*getSpeed()));
					checkBounds(curr);
					break;
			}
		}
	}
	/**
	 * Causes the calling actor to move in a random direction also will cause the animal to rest from time to time
	 * thus not moving at all
	 */
	public void moveRandom(){
		//Might be more efficient to give the animal a Random attribute
		Random r = new Random();
		if(0 == r.nextInt(20)){
			//changeDir(oppositeDir(this));
			
			changeDir(r.nextInt(7));
		}
		if (1 == r.nextInt(30))
			rest();
		move();
	}
	/**
	 * Resting animals gain 1 hp this keeps the animals from dying off too quickly
	 */
	public void rest(){
		hp.gain(1);
	}
	/**
	 * Obtains the speed that the animal is currently moving also alters speed dependent on priority
	 * @return speed at which the animals should move 
	 */
	public int getSpeed(){
		//double speedMod = (double)hp.getCurr()/(double)hp.getMax();
		double speedMod = 1;
		if (threatened == false)
			return (int) (speed*speedMod);
		else
			return (int) (2*speed*speedMod);
	}
	/**
	 * 
	 */
	public void makeBaby(){
	}
	/**
	 * Causes animal to seek out a mate and chase it
	 * @param a the animal that the calling actor will mate with
	 */
 	public void mate(Animal a) {
		if(a == null){
			moveRandom();
		}
		else{
			int dist = this.distance(a);
			if (dist > (attackRange)){
				chase(a);
				//System.out.println(name + " chasing " + b.name);
				status = new String("Pursuing " + a.name);
				}
			else{
				status = new String("Mating with " + a.name);
				gestateCount = gestateTime;
			}
		}
	}
}
