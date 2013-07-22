package MVCorganization;
/**
 *  This class allows mammals to exhibit specific behavior in the model
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public abstract class Mammal extends Animal implements Classification{
	
	public void move(){
		super.move();
		
		if(staysInAll && !goesInWater && !hitsObstacle){
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
	/**
	 * Changes speed depending on the situation
	 */
	public int getSpeed(){
		//double speedMod = (double)hp.getCurr()/(double)hp.getMax();
		double speedMod = 1;
		
		if (this.z == this.onWater)
			speedMod /= 3;
		
		if (threatened == false)
			return (int) (speed*speedMod);
		else
			return (int) (2*speed*speedMod);
	}
}