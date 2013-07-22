package Animals;


import java.util.Random;
import MVCorganization.*;

public class Raccoon extends Mammal implements Species{
	public static int number = 0;
	
	public Raccoon(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		damage = 30;
		attackRange = 15;
		sightRange = 10000;
		hp = new Health(1000);
		speed = 15;
		size = 3;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Raccoon";
		setPredators();
		setPrey();
		
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Raccoon(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("Egret");
		prey.add("Mouse");
	}
	
	public void setPredators(){
		predators.add("Alligator");
	}

	}
