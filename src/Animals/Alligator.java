package Animals;

import java.util.Random;

import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Reptile;
import MVCorganization.Species;

public class Alligator extends Reptile implements Species{
	public static int number = 0;
	
	public Alligator(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		staysInAll=true;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 100;
		hp = new Health(1500);
		speed = 5;
		size = 6;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Alligator";
		setPredators();
		setPrey();

	}
	
	public void makeBaby(){
		Random gen = new Random();
			Actor baby = new Alligator(gen.nextInt(6), gen.nextBoolean(), 2, x, y);
			AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}


	public void setPrey(){
		prey.add("Heron");
		prey.add("Perch");
		prey.add("Crayfish");
		prey.add("Duck");
		prey.add("Possum");
		prey.add("Moccassin");
		prey.add("NutriaRat");
		prey.add("Raccoon");
	}
	
	public void setPredators(){
	predators.add("TeeeHarvs");
	}
}
