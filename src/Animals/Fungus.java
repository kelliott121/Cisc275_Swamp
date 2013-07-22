package Animals;


import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Plant;
import MVCorganization.Seed;

public class Fungus extends Plant implements Seed{


	public Fungus(int xx, int yy, boolean seed){
		isSeed = seed;
		isFlowering = false;
		seedRange = 50;
		seedTime = 15;
		flowerTime = 1000;
		size = 0;
		hp = new Health(500);
		name = new String("Fungus");
		x = xx;
		y = yy;
		z = Animal.onGround;
	}
	
	@Override
	public Plant reproduce(int x, int y){
		return new Fungus(x, y, true);
	}
	
	
}