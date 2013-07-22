package Animals;

import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Plant;
import MVCorganization.Seed;

public class SmallPlant extends Plant implements Seed{


	public SmallPlant(int xx, int yy, boolean seed){
		isSeed = seed;
		isFlowering = false;
		seedRange = 90;
		seedTime = 200;
		flowerTime = 300;
		size = 0;
		hp = new Health(100);
		name = new String("SmallPlant");
		x = xx;
		y = yy;
		z = Animal.onGround;
	}
	
	@Override
	public Plant reproduce(int x, int y){
		return new SmallPlant(x, y, true);
	}
	
}
