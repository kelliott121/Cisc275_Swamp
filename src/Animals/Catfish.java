package Animals;

import java.util.Random;

import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Fish;
import MVCorganization.Health;
import MVCorganization.Species;

public class Catfish extends Fish implements Species{
	public static int number = 0;
	public Catfish(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 100;
		hp = new Health(1000);
		speed = 5;
		size = 2;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Perch";
		setPredators();
		setPrey();

	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Catfish(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	
	public void setPrey(){
		prey.add("Crayfish");
		prey.add("Tadpole");
		prey.add("Algae");
	}
	
	public void setPredators(){
		predators.add("Heron");
		predators.add("Alligator");
		predators.add("Duck");
		
	}
}