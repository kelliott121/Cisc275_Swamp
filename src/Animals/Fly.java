package Animals;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.FlyingBug;
import MVCorganization.Health;
import MVCorganization.Species;

public class Fly extends FlyingBug implements Species{
	public static int number = 0;
	
	public Fly(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 250;
		hp = new Health(750);
		speed = 2;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Fly";
		setPredators();
		setPrey();
		gestateTime = 10;

	}
	
	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Fly(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public int getTerm(){
		return this.gestateTime/10;
	}
	
	public void die(){
		super.die();
		number--;
	}

	public void setPrey(){
		prey.add("Heron");
		prey.add("Duck");
		prey.add("Possum");
		prey.add("Moccassin");
		prey.add("NutriaRat");
		prey.add("Raccoon");
	}
	

	
	public void setPredators(){
		predators.add("Frog");		
	}
}
