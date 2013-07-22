package Animals;


import java.util.Random;
import MVCorganization.*;


public class Mouse extends Mammal implements Species{
	public static int number = 0;
	
	public Mouse(int direction, boolean isMale, int zz, int xx, int yy) {
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
		name= "Mouse";
		setPredators();
		setPrey();
		
		
	}
	
	
	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Mouse(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}


	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("SmallPlant");
		prey.add("Algae");
		prey.add("Flower");
	}
	
	public void setPredators(){
		predators.add("Possum");
		predators.add("Moccassin");
		predators.add("Raccoon");
		
	}
	

	}


