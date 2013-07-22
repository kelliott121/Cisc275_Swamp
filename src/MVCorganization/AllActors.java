package MVCorganization;

import java.util.ArrayList;
import java.util.Iterator;


//plants go in the array of size 0, animals go in all the others
/**
 * 	This class creates an array of all actors that are present in our program
 * 	An actor is any object that will be changed in the swamp thus plants and animals
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 */
public class AllActors{
	public AllActors(int maxSizeIn){
		maxSize=maxSizeIn;
		array = new ArrayList<ArrayList<Actor>>();
		newActors = new ArrayList<Actor>();
		for(int i=0;i<maxSize;i++){
			array.add(i, new ArrayList<Actor>());
		}
	}
	public int maxSize;
	public ArrayList< ArrayList<Actor> > array;
	public static ArrayList<Actor> newActors;
	/**
	 * This method adds an actor to the array list by the size of the actor 
	 * @param actor This is any plant or animal that will be used in the simulation that will be added
	 */
	public void actorAdd(Actor actor){
//		if(actor instanceof Living)
			array.get(actor.size).add(actor); //remember, plants have size 0
		
//		else //if actor instance of dirt.
//			perform appropriate add
	}
	/**
	 * This method removes an actor from the array 
	 * This is normally applied when an actor dies		
	 * @param a This is the actor that will be removed
	 */
	public void removeActor(Actor a){
		array.get(a.size).remove(a);
	}
	/**
	 * This produces the number of animals currently in play in the swamp
	 * @return the number of current active animals
	 */
	public int numAnimals(){
		int count=0;
		for (int i = 1;i<maxSize;i++){
			for(Actor a: array.get(i)){
				count++;
			}
		}
		return count;
	}
//	public int numPlants(){
//		int count = 0;
//		for(Actor a: array.get(0)){
//			if (a instanceof Plant)
//				count++;
//		}
//		}
	/**
	 * This updates the information stored in the array for each plant and animal and will add and remove actors
	 * as they are created and die
	 */
	public void update(){
		for(Actor a : array.get(0)){
			if(a instanceof Plant){
				((Plant)a).updatePlantState();
				if(((Plant)a).isFlowering){
					Plant seed = ((Plant)a).reproduceWrapper();
					if((a.x != seed.x) && (a.y != seed.y))
						newActors.add(seed);
				}
			}
		}
		Iterator<Actor> iter = array.get(0).iterator();
			while(iter.hasNext()){
				Plant a = (Plant)iter.next();
				if(((Plant)a).hp.getCurr() < 0)
					iter.remove();
			}
		
		for (int i=1; i<maxSize;i++){
			Iterator<Actor> it = array.get(i).iterator();
			Animal a;
			//for(Actor a : actors.array.get(i)){
			while(it.hasNext()){
				a = (Animal) it.next();
				//check hunger, or horniness, or whatever.  Right now, just eat();
				// and other possibilites (flee, move) cascade from it
				
				//System.out.println(a.name + " is at hp: " + a.hp.getCurr());

				a.updateAnimalState();
				if(!a.corpse){
					if(a.priority == Animal.FLEE){
						//b = a.closestScary(actors);
						a.flee(a.closestScary());
					}
					else if(a.priority == Animal.EAT){
						//b = a.closestEdible(actors);
						//System.out.println(a.name + " priority is eat");
						a.eat((Living)a.closestEdible());
					}
//					else if (a.priority == Global.POOP{
//						actors.add(a.poop());
//					}
					else if (a.priority == Animal.MATE && a.male){
						a.mate(a.closestMateable());
					}
//					else if(a.priority == Global.REST){
//						//call some rest function (if not fleeing, it's a safe place)
//					}
					else
						a.moveRandom();
			
					//Should eventually be moved to Actor in a getCurrentImage function
					if (a.picNum < Animal.frameCount - 1)
						a.picNum++;
					else
						a.picNum = 0;
				}
				else if (a.hp.getCurr() <= 0){
					it.remove();
					array.remove(a);
				}
			}
			for (Actor c:newActors)
				this.actorAdd(c);
			
			newActors.clear();
		}
		//putting corpses into the smallest size array (corpses are like plants!)
//		// removing fully decayed corpses
		/*Actor c;
		//plant and corpse list - removing what's gone
		Iterator<Actor> iter = actors.array.get(0).iterator();
		while(iter.hasNext()){
			c = iter.next();
			if (((Living)c).hp.getCurr() <= 0){
					iter.remove();
			}
		}
			//for living animals - moving the dead to corpse list
		for(int k = 1; k<actors.maxSize;k++){
			Iterator<Actor> it = (actors.array.get(k)).iterator();
			while (it.hasNext()){
				c = it.next();
				if(((Animal)c).corpse){
					actors.array.get(0).add(c);
					it.remove();
				}
			}	
		}*/
	//return actors;
	} //end update function


}
