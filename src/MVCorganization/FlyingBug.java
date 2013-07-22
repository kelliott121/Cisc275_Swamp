package MVCorganization;
/**
 *  This is the bird abstract class allows the animal to move in our model to the point of the given direction and sets
 * speed depending on medium it is in 
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public abstract class FlyingBug extends Bug implements Classification{
	/**
	 * Allows flying bugs to move in model
	 * 
	 */
	public void move(){
		super.move();
		if(staysInAll){
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
			z = inAir;
	} //move function ends
	/**
	 * Changes the speed of bug given the medium it is in 
	 */
	public int getSpeed(){
		//double speedMod = (double)hp.getCurr()/(double)hp.getMax();
		double speedMod = 1;
		if (this.z == this.inAir)
			speedMod *= 3;
		
		if (threatened == false)
			return (int) (speed*speedMod);
		else
			return (int) (2*speed*speedMod);
	}
}