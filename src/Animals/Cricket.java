package Animals;


import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.CrawlingBug;
import MVCorganization.Health;
import MVCorganization.Species;

public class Cricket extends CrawlingBug implements Species{
	public static int number = 0;
	
	public Cricket(int direction, boolean isMale, int zz, int xx, int yy) {
		staysInAll=true;
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 10;
		hp = new Health(150);
		speed = 5;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Cricket";
		setPredators();
		setPrey();

		
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Cricket(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	

	
	public void setPrey(){
		prey.add("SmallPlant");
		prey.add("Fungi");
	}
	
	public void setPredators(){
		predators.add("Frog");
		predators.add("Salamander");
		
	}
}
