package MVCorganization;
/**
 * This class allows reptiles to exhibit specific behavior in the model
*  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
*/
public abstract class Reptile extends Animal implements Classification{
	/**
	 * Causes the actor to move according to obstacles
	 */
	public void move(){
		super.move();
		
		if(staysInAll && !hitsObstacle){
			if(dir ==  N){
				y = y-getSpeed();
			}
			if(dir ==  S){
				y = y+getSpeed();
			}
			if(dir ==  NE){
				x = x + (int)(.866*getSpeed());
				y = y - (int)(.5*getSpeed());
			}
			if(dir ==  NW){
				x = x - (int)(.866*getSpeed());
				y = y - (int)(.5*getSpeed());
			}
			if(dir ==  SE){
				x = x + (int)(.866*getSpeed());
				y = y + (int)(.5*getSpeed());
			}
			if(dir ==  SW){
				x = x - (int)(.866*getSpeed());
				y = y + (int)(.5*getSpeed());			
			}
		}
		else
			changeDir(oppositeDir(this.dir));
		
		if(goesInWater)
			z = onWater;
		else
			z = onGround; //because they'll walk in shallow water
		
	} //end move function
	
	
	
	
}