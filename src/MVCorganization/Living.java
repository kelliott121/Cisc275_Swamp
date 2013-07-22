package MVCorganization;
/**
 * Creates an abstract class of living to differentiate the behaviours of a living actor vs a dead on
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public abstract class Living extends Actor{
	
	
	public int count;
	public int lifeStage;
	public int evolveThresh;
	public Health hp;

	
	/**
	 * increases age 
	 * @return a value representing age
	 */
	public int age(){
		count++;
		return count;
	}
	
	/**
	 * increases lifeStage
	 * @return returns a value that corresponds to lifeStage
	 */
	public int evolve(){
		lifeStage++;
		return lifeStage;
	}
	

	public void toChild(int speed, int size, boolean male) {
		// TODO Auto-generated method stub
		// Need to determine the method to do this
	}
	
	
	


}
