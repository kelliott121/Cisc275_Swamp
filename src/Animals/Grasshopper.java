package Animals;


import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.FlyingBug;
import MVCorganization.Health;
import MVCorganization.Species;

public class Grasshopper extends FlyingBug implements Species{
	public static int number = 0;
	
	public Grasshopper(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 30;
		hp = new Health(500);
		speed = 5;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Grasshopper";
		setPredators();
		setPrey();

	}

	
	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Grasshopper(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("SmallPlant");
	}
	
	public void setPredators(){
		predators.add("Frog");		
	}
}
