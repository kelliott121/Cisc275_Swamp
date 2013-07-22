package Animals;


import java.util.Random;
import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Bird;
import MVCorganization.Health;
import MVCorganization.Species;

public class Heron extends Bird implements Species{
	public static int number = 0;
	
	public Heron(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 10;
		hp = new Health(150);
		speed = 10;
		size = 5;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Heron";
		setPredators();
		setPrey();

	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Heron(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		prey.add("SnappingTurtle");
		prey.add("Perch");
		prey.add("Frog");
		prey.add("Crayfish");
	}
	
	public void setPredators(){
		predators.add("Alligator");
		
	}
}
