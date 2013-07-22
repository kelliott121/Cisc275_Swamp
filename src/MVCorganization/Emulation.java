package MVCorganization;

import java.awt.Polygon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Animals.*;


/**
 * This is the class that runs the entire simulation. All initial information is taken in from this point. 
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public class Emulation {
	/**
	 * The main of our simulation 
	 * @param args
	 */
	public static void main(String[] args){
		
			Gui gui = new Gui();
			Actor.actors = new AllActors(7);
			
			StartScreen frame = new StartScreen();
		
		while(!StartScreen.terminate){ //nothing else happens until button-press
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		frame.closeStartScreen();
		int[] array = {10, 6, 30, 10, 0, 0, 0, 10, 0, 50, 25, 10, 5, 0, 0, 0, 20, 5, 10, 0, 10, 20,50, 30, 0, 40, 0};
		Scanner sc;
		try {
			sc = new Scanner(new File("lastNumbers.txt"));
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
		
			array = new int[numbers.length];
			for(int i=0;i<numbers.length;i++)
				array[i] = Integer.parseInt(numbers[i]);
		} catch (FileNotFoundException e) {
		}
		
			int numAlgae = array[0];
			int numAlligator = array[1];
			int numBee = array[2];	
			int numCatfish = array[3];
			int numCrayfish = array[4];	
			int numCricket = array[5];
			int numDragonfly = array[6];
			int numDuck = array[7];
			int numEgret = array[8];
			int numFlower = array[9];
			int numFly = array[10];
			int numFrog = array[11];
			int numFungus = array[12];
			int numGrasshopper = array[13];
			int numHeron = array[14];
			int numMoccassin = array[15];
			int numMouse = array[16];
			int numNutriaRat = array[17];
			int numPerch = array[18];
			int numPossum = array[19];
			int numRaccoon = array[20];
			int numSalamander = array[21];
			int numSlug = array[22];
			int numSmallPlant = array[23];
			int numSnappingTurtle = array[24];
			int numTadpole = array[25];
			int numWorm = array[26];
			
			
			Random gen = new Random();
			
			
		int[] xyPoints;
		for (int i = 0; i < numAlgae; i++){
			xyPoints = randomPointsInWater();
			Actor.actors.actorAdd(new Algae(xyPoints[0], xyPoints[1], false));
		}
		for (int i = 0; i < numAlligator; i++)
			Actor.actors.actorAdd(new Alligator(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numBee; i++)
			Actor.actors.actorAdd(new Bee(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numCatfish; i++){
			xyPoints = randomPointsInWater();
			Actor.actors.actorAdd(new Catfish(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, xyPoints[0], xyPoints[1]));
		}	
		for (int i = 0; i < numCrayfish; i++){
			xyPoints = randomPointsInWater();
			Actor.actors.actorAdd(new Crayfish(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numCricket; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Cricket(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numDragonfly; i++)
			Actor.actors.actorAdd(new Dragonfly(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numDuck; i++)
			Actor.actors.actorAdd(new Duck(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numEgret; i++)
			Actor.actors.actorAdd(new Egret(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numFlower; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Flower(xyPoints[0], xyPoints[1], false));
		}
		for (int i = 0; i < numFly; i++)
			Actor.actors.actorAdd(new Fly(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numFrog; i++)
			Actor.actors.actorAdd(new Frog(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numFungus; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Fungus(xyPoints[0], xyPoints[1], false));
		}
		for (int i = 0; i < numGrasshopper; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Grasshopper(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numHeron; i++)
			Actor.actors.actorAdd(new Heron(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numMoccassin; i++)
			Actor.actors.actorAdd(new Moccassin(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numMouse; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Mouse(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numNutriaRat; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new NutriaRat(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numPerch; i++){
			xyPoints = randomPointsInWater();
			Actor.actors.actorAdd(new Perch(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numPossum; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Possum(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numRaccoon; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Raccoon(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numSalamander; i++)
			Actor.actors.actorAdd(new Salamander(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numSlug; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Slug(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numSmallPlant; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new SmallPlant(xyPoints[0], xyPoints[1], false));
		}
		for (int i = 0; i < numSnappingTurtle; i++)
			Actor.actors.actorAdd(new SnappingTurtle(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		for (int i = 0; i < numTadpole; i++){
			xyPoints = randomPointsInWater();
			Actor.actors.actorAdd(new Tadpole(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, xyPoints[0], xyPoints[1]));
		}
		for (int i = 0; i < numWorm; i++){
			xyPoints = randomPointsOnLand();
			Actor.actors.actorAdd(new Worm(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, xyPoints[0], xyPoints[1]));
		}
		
			/*
			Actor.actors.actorAdd(new NutriaRat(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Raccoon(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Fly(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Alligator(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Tadpole(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, 500, 500 - 10*i));
			Actor.actors.actorAdd(new Perch(gen.nextInt(6), gen.nextBoolean(), Animal.underWater, 450, 450 - 10*i));
			Actor.actors.actorAdd(new Frog(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Salamander(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			//Actor.actors.actorAdd(new Grasshopper(gen.nextInt(7), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Mouse(gen.nextInt(6), gen.nextBoolean(), Animal.onGround, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
			Actor.actors.actorAdd(new Duck(gen.nextInt(6), gen.nextBoolean(), Animal.inAir, gen.nextInt(Gui.mapWidth-200), gen.nextInt(Gui.mapHeight-200)));
		
		
		Actor.actors.actorAdd(new Fungus(300, 300, false));
		Actor.actors.actorAdd(new Algae(500, 500, false));
		Actor.actors.actorAdd(new SmallPlant(700, 700, false));
		Actor.actors.actorAdd(new Flower(100, 500, false));
		*/
		

		    
		    
        //gui.statusPane.setText("Living Animals: " + actors.numAnimals() );*/
		int delay = 0;
	
		while(true){
			//System.out.println("Simulation playing");
			gui.update(Actor.actors);
			//Actor.actors = engine.update(Actor.actors);
			Actor.actors.update();
			if (gui.speed != 0)
				delay = (75-Gui.paintDelay)/gui.speed;
			else
				while(gui.speed == 0)
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			if (delay < 0)
				delay = 1;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * function to find starting points for land animals
	 * @return an array of [x y] points
	 */
	public static int[] randomPointsOnLand(){
		int x,y;
		int step=0;
		boolean first=false;
		boolean second=false;
		Random gen = new Random();
			x = gen.nextInt(Gui.mapWidth-200);
			y = gen.nextInt(Gui.mapHeight-200);
			for(Polygon a: Background.obstacles){
				if (step==0){
					first=a.contains(x,y);
					step++;
				}
				else if (step==1){
					second=a.contains(x,y);
					step=0;
				}
			}
			while (Background.waterBounds.contains(x, y)||first||second){
				x = gen.nextInt(Gui.mapWidth-200);
				y = gen.nextInt(Gui.mapHeight-200);
				for(Polygon a: Background.obstacles){
					//System.out.println("Background Check!");
					if (step==0){
						first=a.contains(x,y);
						step++;
					}
					else if (step==1){
						second=a.contains(x,y);
						step=0;
					}
				}
			}
		
		int[] out = {x, y};
		return out;
	}
	
	/**
	 * function to find starting points for water animals
	 * @return an array of [x y] points
	 */
	public static int[] randomPointsInWater(){
		int x,y;
		int step=0;
		boolean first=false;
		boolean second=false;
		Random gen = new Random();
			x = gen.nextInt(Gui.mapWidth-200);
			y = gen.nextInt(Gui.mapHeight-200);
			for(Polygon a: Background.obstacles){
				if (step==0){
					first=a.contains(x,y);
					step++;
				}
				else if (step==1){
					second=a.contains(x,y);
					step=0;
				}
			}
		
			while (!Background.waterBounds.contains(x, y)|| first || second){
				
				x = gen.nextInt(Gui.mapWidth-200);
				y = gen.nextInt(Gui.mapHeight-200);
				for(Polygon a: Background.obstacles){
					if (step==0){
						first=a.contains(x,y);
						step++;
					}
					else if (step==1){
						second=a.contains(x,y);
						step=0;
					}
				}
			}
		
		int[] out = {x, y};
		return out;
	}
}
