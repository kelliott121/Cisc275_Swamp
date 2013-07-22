package MVCorganization;
/**
 *  This Class allows fish to move in our model
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public abstract class Fish extends Animal implements Classification{
	/**
	 * allows fish to move in our model
	 */
	public void move(){
		super.move();
		if(goesInWater){
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
	}
	
}