package MVCorganization;
/**
 * This is the bird abstract class allows the animal to move to the point of the given direction and sets
 * speed depending on medium it is in 
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public abstract class Bird extends Animal implements Classification{

	/**
	 * Causes the bird to move in a give direction
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
		
		//this one's level will have to be updated based on choices, since
		//  it can go anywhere
	}
	/**
	 * Sets speeds dependent on the medium the bird is in 
	 */
	public int getSpeed(){
		//double speedMod = (double)hp.getCurr()/(double)hp.getMax();
		double speedMod = 1;
		if (this.z == Animal.inAir)
			speedMod *= 3;
		else if (this.z == Animal.onWater)
			speedMod /= 2;
		
		if (threatened == false)
			return (int) (speed*speedMod);
		else
			return (int) (2*speed*speedMod);
	}
}
