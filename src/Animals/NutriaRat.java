package Animals;

import java.util.Random;
import MVCorganization.*;

public class NutriaRat extends Mammal implements Species{
	public static int number = 0;
	
	public NutriaRat(int direction, boolean isMale, int zz, int xx, int yy) {
		
		//stamina = stam;
		number++;
		numAnimals++;
		attackRange = 10;
		sightRange = 10000;
		damage = 20;
		hp = new Health(2000);
		speed = 5;
		size = 2;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "NutriaRat";
		setPredators();
		setPrey();

	}
	
	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new NutriaRat(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
/*
	public void move(){
		super.move();
		System.out.println("Dir: " + dir);
		System.out.println("In Bounds: " + staysInAll);
		System.out.println("Priority: " + priority);
	}
	*/
	public void setPrey(){
		prey.add("SmallPlant");
		
	}
	
	public void setPredators(){
		predators.add("Alligator");
	}

}


