package Animals;

import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Plant;
import MVCorganization.Seed;

public class Algae extends Plant implements Seed{

	public Algae(int xx, int yy, boolean seed){
		isSeed = seed;
		isFlowering = false;
		seedRange = 60;
		seedTime = 2;
		flowerTime = 1000;
		size = 0;
		hp = new Health(500);
		name = new String("Algae");
		x = xx;
		y = yy;
		z = Animal.onWater;
	}
	//TODO decide where and how to implement boundary checking for plant reproduction
	//boundary checking is available to plants through Actor
	@Override
	public Plant reproduce(int x, int y){
		return new Algae(x, y, true);
	}
	
	@Override
	public boolean canPlace(){
		if(staysInAll && goesInWater && !hitsObstacle){
			return true;
		}
		else return false;
	}
	
}
