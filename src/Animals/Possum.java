package Animals;


import java.util.Random;
import MVCorganization.*;

public class Possum extends Mammal implements Species{
	public static int number = 0;
	
	public Possum(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 15;
		sightRange = 10000;
		damage = 25;
		hp = new Health(350);
		speed = 10;
		size = 5;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Possum";
		setPredators();
		setPrey();
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Possum(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("Frog");
		prey.add("Mouse");
	}
	
	public void setPredators(){
		predators.add("Alligator");
	}

	}
