package Animals;


import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Reptile;
import MVCorganization.Species;

public class Frog extends Reptile implements Species{
	public static int number = 0;
	
	public Frog(int direction, boolean isMale, int zz, int xx, int yy) {
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
		name= "Frog";
		setPredators();
		setPrey();
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Frog(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}

	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("Fly");
		prey.add("Mosquito");
		prey.add("Grasshopper");
		prey.add("Cricket");
	}
	
	public void setPredators(){
		predators.add("Possum");
		predators.add("Moccassin");
		predators.add("Heron");
		predators.add("SnappingTurtle");
		predators.add("Egret");
		
	}
}
