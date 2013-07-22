package MVCorganization;
/**
 * This clas allows the actors have their health set
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public class Health {

	private int max;
	private int curr;
	private int deathThresh;
	private int reproThresh;
	private int hungerThresh;
	/**
	 * This sets the initial values for the health of the actor
	 * @param maxH this is the maximum health of the actor
	 */
	public Health(int maxH){
		max = maxH;
		curr = max - 1;
		setDeathThresh(max/5);
		setReproThresh(4*max/5);
		setHungerThresh(3*max/5);
		
	}
	
	/**
	 * Function takes an int amount, and subtracts that amount from
	 * the current health.
	 * @param amountHP
	 */
	public void lose(int amountHP){
		curr = curr - amountHP;
	}
	/**
	 * Function takes an int amount, and adds that amount to
	 * the current health.  Current can't exceed maximum.
	 * @param amountHP
	 */
	public void gain(int amountHP){
		if(curr + amountHP >= max)
			curr = max;
		else
			curr = curr + amountHP;		
	}

	/**
	 * Sets a threshold in terms of hp for the actor to die
	 * @param deathThresh the deathThresh to set
	 */
	public void setDeathThresh(int deathThresh) {
		this.deathThresh = deathThresh;
	}

	/**
	 * gets the thresh hold at which the actor dies
	 * @return the deathThresh
	 */
	public int getDeathThresh() {
		return deathThresh;
	}

	/**
	 * Sets the threshold for when the actor will mate
	 * @param reproThresh the reproThresh to set
	 */
	public void setReproThresh(int reproThresh) {
		this.reproThresh = reproThresh;
	}

	/**
	 * gets the threshold for when the actor will mate
	 * @return the reproThresh
	 */
	public int getReproThresh() {
		return reproThresh;
	}

	/**
	 * Sets the threshold for when the actor will become hungry
	 * @param hungerThresh the hungerThresh to set
	 */
	public void setHungerThresh(int hungerThresh) {
		this.hungerThresh = hungerThresh;
	}

	/**
	 * gets the threshold for when the actor becomes hungry
	 * @return the hungerThresh
	 */
	public int getHungerThresh() {
		return hungerThresh;
	}


	/**
	 * Gets the current health value of the actor
	 * @return the current health
	 */
	public int getCurr() {
		return curr;
	}	

	/**
	 * gets the value of the maximum health of the actor
	 * @return the maximum health
	 */
	public int getMax() {
		return max;
	}	
	
	
}
