package Animals;

import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.CrawlingBug;
import MVCorganization.Health;
import MVCorganization.Species;

public class Slug extends CrawlingBug implements Species{
	public static int number = 0;
	
	public Slug(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 500;
		hp = new Health(1000);
		speed = 5;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Slug";
		setPredators();
		setPrey();

	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Slug(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}

	public void die(){
		super.die();
		number--;
	}

	
	public void setPrey(){
		prey.add("Algae");
		prey.add("SmallPlant");
	}
	
	public void setPredators(){
		predators.add("Duck");
		predators.add("Egret");
	}
}
