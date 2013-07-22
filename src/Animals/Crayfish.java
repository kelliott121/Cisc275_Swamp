package Animals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.imageio.ImageIO;

import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Fish;
import MVCorganization.Health;
import MVCorganization.Species;

public class Crayfish extends Fish implements Species{
	public static int number = 0;
	
	public Crayfish(int direction, boolean isMale, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		attackRange = 10;
		sightRange = 10000;
		damage = 10;
		hp = new Health(150);
		speed = 5;
		size = 1;
		male = isMale;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "Crayfish";
		setPredators();
		setPrey();

		
	}

	public void makeBaby(){
		Random gen = new Random();
		Actor baby = new Crayfish(gen.nextInt(6), gen.nextBoolean(), z, x, y);
		AllActors.newActors.add(baby);
	}
	
	public void die(){
		super.die();
		number--;
	}
	

	
	public void setPrey(){
		prey.add("Algae");
	}
	
	public void setPredators(){
		predators.add("Aligator");
		predators.add("Heron");
		predators.add("Perch");
		predators.add("Egret");
		
	}
}
