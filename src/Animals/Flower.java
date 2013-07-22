package Animals;


import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Plant;
import MVCorganization.Seed;

public class Flower extends Plant implements Seed{

	
	public Flower(int xx, int yy, boolean seed){
		isSeed = seed;
		isFlowering = false;
		seedRange = 200;
		seedTime = 250;
		flowerTime = 500;
		size = 0;
		hp = new Health(500);
		name = new String("Flower");
		x = xx;
		y = yy;
		z = Animal.onGround;
	}
	
	@Override
	public Plant reproduce(int x, int y){
		return new Flower(x, y, true);
	}
	
	
}