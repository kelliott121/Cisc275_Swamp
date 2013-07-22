package Animals;

import java.util.Random;


import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Bird;
import MVCorganization.Health;
import MVCorganization.Species;

public class Duck extends Bird implements Species{
	public static int number = 0;
	
	public Duck(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		staysInAll=true;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 10;
		hp = new Health(800);
		speed = 5;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Duck";
		setPredators();
		setPrey();

		
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Duck(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}

	
	public void setPrey(){
		prey.add("Perch");
		prey.add("Slug");
	//	prey.add("BABY FISH")
	}
	
	public void setPredators(){
		predators.add("Alligator");
		predators.add("SnappingTurtle");		
	}
}
