package Animals;

import java.util.Random;

import MVCorganization.Actor;
import MVCorganization.AllActors;
import MVCorganization.Animal;
import MVCorganization.Health;
import MVCorganization.Mammal;
import MVCorganization.Species;

public class TeeeHarvs extends Mammal implements Species{

public static int number = 0;
	
	public TeeeHarvs(int direction, int zz, int xx, int yy) {
		number++;
		numAnimals++;
		//stamina = stam;
		damage = 400;
		attackRange = 15;
		sightRange = 10000;
		hp = new Health(9001);
		speed = 10;
		size = 6;
		male = true;
		threatened = false;
		dir = direction;
		x = xx;
		y = yy;
		z = zz;
		name= "TeeeHarvs";
		setPredators();
		setPrey();
		
	}

	@Override
	public void updateAnimalState(){
		super.updateAnimalState();
		status = "ROFL_stomping";
	}
	
	@Override
	public void updateActorState(){
		super.updateActorState();
		status = "rofl_STOMPING";
	}
	
	public void mate(Animal a){
		if(a == null){
			moveRandom();
			//return null;
		}
		else{
			int dist = this.distance(a);
			if (dist > (attackRange)){
				chase(a);
				//System.out.println(name + " chasing " + b.name);
				status = new String("Pursuing " + a.name);
				}
			else{
				status = new String("Mating with " + a.name);
			
				Random gen = new Random();
			
				Actor baby = new TeeeHarvs(gen.nextInt(7), z, x, y);
				AllActors.newActors.add(baby);
			}
		}
	}
	
	public void die(){
		super.die();
		number--;
	}
	
	public void setPrey(){
		//om nom nom
		prey.add("Alligator");
		prey.add("Worm");
		prey.add("Tadpole");
		prey.add("SnappingTurtle");
		prey.add("Slug");
		prey.add("Salamander");
		prey.add("Raccoon");
		prey.add("Perch");
		prey.add("NutriaRat");
		prey.add("Mouse");
		prey.add("Mosquito");
		prey.add("Heron");
		prey.add("Grasshopper");
		prey.add("Fungus");
		prey.add("Frog");
		prey.add("Fly");
		prey.add("Flower");
		prey.add("Egret");
		prey.add("Duck");
		prey.add("Dragonfly");
		prey.add("Cricket");
		prey.add("Crayfish");
		prey.add("Catfish");
		prey.add("Butterfly");
		prey.add("Bee");
		prey.add("Alligator");
		
	}
	
	public void setPredators(){
		//nope
	}

	}
