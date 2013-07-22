package MVCorganization;


import Animals.*;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This repository class loads and re-sizes all animal and plant images, and then
 * stores those images.
 * It includes a function of syntax: getPic(Animal) for each
 * type of Animal, which will quickly retrieve the appropriate image.  
 * @method loadPics()
 * 
 * @method getPic([specific type of animal]);
 * 
 * @author curtis
 *
 * 
 */

public class ImageRepo{
	private static int frameCount = Animal.frameCount;
	double transSize = 35;
	//[Enum_actorType][Enum_depth][Enum_Direction][frameCount]
	//every single actor picture
	BufferedImage storage[][][][][];
	final int zoomCount = 4; //the number of zooming possibilities to be accounted-for
	String[][][] FileNames;
	String[] plantFileNames;
	BufferedImage plantStorage[][];
	
	int[] animalSizes = {6, 5, 1, 2, 1, 1, 3, 2, 1, 1, 3, 1, 1, 2, 6, 5, 5};
	
	private int numActors = 18; //update this!!!
	
	private int enum_Alligator = 0;
	private int enum_Duck = 1;
	private int enum_Fly = 2;
	private int enum_Frog = 3;
	private int enum_Mouse = 4;
	private int enum_NutriaRat = 5;
	private int enum_Perch = 6;
	private int enum_Raccoon = 7;
	private int enum_Salamander = 8;
	private int enum_Slug = 9;
	private int enum_SnappingTurtle = 10;
	private int enum_Tadpole = 11;
	private int enum_Bee = 12;
	private int enum_Catfish = 13;
	private int enum_TeeeHarvs = 14;
	private int enum_Heron = 15;
	private int enum_Possum = 16;
		
		//pictures we don't have yet - remember to increment numActors when you add them

	private int enum_Crayfish = 17;
	private int enum_Cricket = 18;
	private int enum_Dragonfly = 19;
	private int enum_Egret = 20;	
	private int enum_Moccassin = 21;		
	private int enum_Worm = 22;
	private int enum_Grasshopper =23;
	/**
	 * Creates a new directory for the resizing of the pictures and associates each picture with a direction and animal/plant
	 */
	
	public ImageRepo(){
		File dir1 = new File("smallPics");
		if(!dir1.isDirectory())
			dir1.mkdir();
		transformSetup();


		
		
		FileNames = new String[numActors][3][6];
		
		//These are small enough that it's easier to just load them
		//                         in the constructor.
		//load plants
		plantStorage = new BufferedImage[5][4];
		plantFileNames = new String[5];
		plantFileNames[0] = new String("seed.png");
		plantFileNames[1] = new String("algae.png");
		plantFileNames[2] = new String("flower.png");
		plantFileNames[3] = new String("fungus.png");
		plantFileNames[4] = new String("smallPlant.png");
		for(int i = 0; i<5; i++){
			try{
			plantStorage[i][3] = ImageIO.read(new File(plantFileNames[i]));
			}catch(IOException e){
				e.printStackTrace();
			}
			plantStorage[i][3] = plantShrinkOp.filter(plantStorage[i][3], null);

			plantStorage[i][2] = scalingOp3.filter(plantStorage[i][3], null);
			plantStorage[i][1] = scalingOp2.filter(plantStorage[i][3], null);
			plantStorage[i][0] = scalingOp1.filter(plantStorage[i][3], null);
		}
		
		
		
		//alligator on land
		FileNames[enum_Alligator][1][Animal.N] = "Alligator_walk_N.png"; 
		FileNames[enum_Alligator][1][Animal.NE] = "Alligator_walk_N.png"; 
		FileNames[enum_Alligator][1][Animal.NW] = "Alligator_walk_N.png"; 
		FileNames[enum_Alligator][1][Animal.S] = "Alligator_walk_S.png"; 
		FileNames[enum_Alligator][1][Animal.SE] = "Alligator_walk_SE.png"; 
		FileNames[enum_Alligator][1][Animal.SW] = "Alligator_walk_SW.png"; 
		//alligator on water
		FileNames[enum_Alligator][0][Animal.N] = "Alligator_swim_S.png";
		FileNames[enum_Alligator][0][Animal.NE] = "Alligator_swim_S.png";
		FileNames[enum_Alligator][0][Animal.NW] = "Alligator_swim_S.png";
		FileNames[enum_Alligator][0][Animal.S] = "Alligator_swim_S.png";
		FileNames[enum_Alligator][0][Animal.SE] = "Alligator_swim_SE.png";
		FileNames[enum_Alligator][0][Animal.SW] = "Alligator_swim_SW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_Alligator][2][i] = null; //no flying images
		
		//Duck, on water
		FileNames[enum_Duck][0][Animal.N] = "duck_flying_N.png";
		FileNames[enum_Duck][0][Animal.NE] = "duck_flying_NE.png";
		FileNames[enum_Duck][0][Animal.NW] = "duck_flying_NW.png";
		FileNames[enum_Duck][0][Animal.S] = "duck_flying_S.png";
		FileNames[enum_Duck][0][Animal.SE] = "duck_flying_SE.png";
		FileNames[enum_Duck][0][Animal.SW] = "duck_flying_SW.png";
		//Duck, on land
		FileNames[enum_Duck][1][Animal.N] = "duck_flying_N.png";
		FileNames[enum_Duck][1][Animal.NE] = "duck_flying_NE.png";
		FileNames[enum_Duck][1][Animal.NW] = "duck_flying_NW.png";
		FileNames[enum_Duck][1][Animal.S] = "duck_flying_S.png";
		FileNames[enum_Duck][1][Animal.SE] = "duck_flying_SE.png";
		FileNames[enum_Duck][1][Animal.SW] = "duck_flying_SW.png";
		//Duck, in air
		FileNames[enum_Duck][2][Animal.N] = "duck_flying_N.png";
		FileNames[enum_Duck][2][Animal.NE] = "duck_flying_NE.png";
		FileNames[enum_Duck][2][Animal.NW] = "duck_flying_NW.png";
		FileNames[enum_Duck][2][Animal.S] = "duck_flying_S.png";
		FileNames[enum_Duck][2][Animal.SE] = "duck_flying_SE.png";
		FileNames[enum_Duck][2][Animal.SW] = "duck_flying_SW.png";
		
		//fly, on land
		FileNames[enum_Fly][1][Animal.N] = "fly_fly_N.png";
		FileNames[enum_Fly][1][Animal.NE] = "fly_fly_NE.png";
		FileNames[enum_Fly][1][Animal.NW] = "fly_fly_NW.png";
		FileNames[enum_Fly][1][Animal.S] = "fly_fly_S.png";
		FileNames[enum_Fly][1][Animal.SE] = "fly_fly_SE.png";
		FileNames[enum_Fly][1][Animal.SW] = "fly_fly_SW.png";
		//fly, in air
		FileNames[enum_Fly][2][Animal.N] = "fly_fly_N.png";
		FileNames[enum_Fly][2][Animal.NE] = "fly_fly_NE.png";
		FileNames[enum_Fly][2][Animal.NW] = "fly_fly_NW.png";
		FileNames[enum_Fly][2][Animal.S] = "fly_fly_S.png";
		FileNames[enum_Fly][2][Animal.SE] = "fly_fly_SE.png";
		FileNames[enum_Fly][2][Animal.SW] = "fly_fly_SW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_Fly][0][i] = null; //no swimming images
		
		//Frog on land
		FileNames[enum_Frog][1][Animal.N] = "bullfrog_N.png"; 
		FileNames[enum_Frog][1][Animal.NE] = "bullfrog_NE.png"; 
		FileNames[enum_Frog][1][Animal.NW] = "bullfrog_NW.png"; 
		FileNames[enum_Frog][1][Animal.S] = "bullfrog_S.png"; 
		FileNames[enum_Frog][1][Animal.SE] = "bullfrog_SE.png"; 
		FileNames[enum_Frog][1][Animal.SW] = "bullfrog_SW.png"; 
		//Frog on water
		FileNames[enum_Frog][0][Animal.N] = "bullfrog_N.png";
		FileNames[enum_Frog][0][Animal.NE] = "bullfrog_NE.png";
		FileNames[enum_Frog][0][Animal.NW] = "bullfrog_NW.png";
		FileNames[enum_Frog][0][Animal.S] = "bullfrog_S.png";
		FileNames[enum_Frog][0][Animal.SE] = "bullfrog_SE.png";
		FileNames[enum_Frog][0][Animal.SW] = "bullfrog_SW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_Frog][2][i] = null; //no flying images

		//Heron on land
		FileNames[enum_Heron][1][Animal.N] = "Heron_walk_N.png"; 
		FileNames[enum_Heron][1][Animal.NE] = "Heron_walk_NE.png"; 
		FileNames[enum_Heron][1][Animal.NW] = "Heron_walk_NW.png"; 
		FileNames[enum_Heron][1][Animal.S] = "Heron_walk_S.png"; 
		FileNames[enum_Heron][1][Animal.SE] = "Heron_walk_SE.png"; 
		FileNames[enum_Heron][1][Animal.SW] = "Heron_walk_SW.png"; 
		//Heron on water
		FileNames[enum_Heron][0][Animal.N] = "Heron_walk_N.png";
		FileNames[enum_Heron][0][Animal.NE] = "Heron_walk_NE.png";
		FileNames[enum_Heron][0][Animal.NW] = "Heron_walk_NW.png";
		FileNames[enum_Heron][0][Animal.S] = "Heron_walk_S.png";
		FileNames[enum_Heron][0][Animal.SE] = "Heron_walk_SE.png";
		FileNames[enum_Heron][0][Animal.SW] = "Heron_walk_SW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_Heron][2][i] = null; //no flying images

		//Mouse on land
		FileNames[enum_Mouse][1][Animal.N] = "mouse_neast.png"; 
		FileNames[enum_Mouse][1][Animal.NE] = "mouse_neast.png"; 
		FileNames[enum_Mouse][1][Animal.NW] = "mouse_nwest.png"; 
		FileNames[enum_Mouse][1][Animal.S] = "mouse_seast.png"; 
		FileNames[enum_Mouse][1][Animal.SE] = "mouse_seast.png"; 
		FileNames[enum_Mouse][1][Animal.SW] = "mouse_swest.png"; 
		//Mouse on water
		FileNames[enum_Mouse][0][Animal.N] = "mouse_neast.png"; 
		FileNames[enum_Mouse][0][Animal.NE] = "mouse_neast.png"; 
		FileNames[enum_Mouse][0][Animal.NW] = "mouse_nwest.png"; 
		FileNames[enum_Mouse][0][Animal.S] = "mouse_seast.png"; 
		FileNames[enum_Mouse][0][Animal.SE] = "mouse_seast.png"; 
		FileNames[enum_Mouse][0][Animal.SW] = "mouse_swest.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_Mouse][2][i] = null; //no flying images
		
		//NutriaRat on land
		FileNames[enum_NutriaRat][1][Animal.N] = "NutriaNESeq.png"; 
		FileNames[enum_NutriaRat][1][Animal.NE] = "NutriaNESeq.png"; 
		FileNames[enum_NutriaRat][1][Animal.NW] = "NutriaNWSeq.png"; 
		FileNames[enum_NutriaRat][1][Animal.S] = "NutriaSESeq.png"; 
		FileNames[enum_NutriaRat][1][Animal.SE] = "NutriaSESeq.png"; 
		FileNames[enum_NutriaRat][1][Animal.SW] = "NutriaNWSeq.png"; 
		//NutriaRat on water
		FileNames[enum_NutriaRat][0][Animal.N] = "NutriaNESeq.png"; 
		FileNames[enum_NutriaRat][0][Animal.NE] = "NutriaNESeq.png"; 
		FileNames[enum_NutriaRat][0][Animal.NW] = "NutriaNWSeq.png"; 
		FileNames[enum_NutriaRat][0][Animal.S] = "NutriaSESeq.png"; 
		FileNames[enum_NutriaRat][0][Animal.SE] = "NutriaSESeq.png"; 
		FileNames[enum_NutriaRat][0][Animal.SW] = "NutriaNWSeq.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_NutriaRat][2][i] = null; //no flying images

		//Perch in water
		FileNames[enum_Perch][0][Animal.N] = "Perch_N.png"; 
		FileNames[enum_Perch][0][Animal.NE] = "Perch_NE.png"; 
		FileNames[enum_Perch][0][Animal.NW] = "Perch_NW.png"; 
		FileNames[enum_Perch][0][Animal.S] = "Perch_S.png"; 
		FileNames[enum_Perch][0][Animal.SE] = "Perch_SE.png"; 
		FileNames[enum_Perch][0][Animal.SW] = "Perch_SW.png"; 
		for(int i = 0; i<6; i++){
			FileNames[enum_Perch][2][i] = null; //no flying images
			FileNames[enum_Perch][1][i] = null; //no walking images
		}
		//Possum on land
		FileNames[enum_Possum][1][Animal.N] = "opossum_N.png"; 
		FileNames[enum_Possum][1][Animal.NE] = "opossum_NE.png"; 
		FileNames[enum_Possum][1][Animal.NW] = "opossum_NW.png"; 
		FileNames[enum_Possum][1][Animal.S] = "opossum_S.png"; 
		FileNames[enum_Possum][1][Animal.SE] = "opossum_SE.png"; 
		FileNames[enum_Possum][1][Animal.SW] = "opossum_SW.png"; 
		//Possum on water
		FileNames[enum_Possum][0][Animal.N] = "opossum_N.png"; 
		FileNames[enum_Possum][0][Animal.NE] = "opossum_NE.png"; 
		FileNames[enum_Possum][0][Animal.NW] = "opossum_NW.png"; 
		FileNames[enum_Possum][0][Animal.S] = "opossum_S.png"; 
		FileNames[enum_Possum][0][Animal.SE] = "opossum_SE.png"; 
		FileNames[enum_Possum][0][Animal.SW] = "opossum_SW.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_Possum][2][i] = null; //no flying images
		
		//Raccoon on land
		FileNames[enum_Raccoon][1][Animal.N] = "opossum_N.png"; 
		FileNames[enum_Raccoon][1][Animal.NE] = "opossum_NE.png"; 
		FileNames[enum_Raccoon][1][Animal.NW] = "opossum_NW.png"; 
		FileNames[enum_Raccoon][1][Animal.S] = "opossum_S.png"; 
		FileNames[enum_Raccoon][1][Animal.SE] = "opossum_SE.png"; 
		FileNames[enum_Raccoon][1][Animal.SW] = "opossum_SW.png"; 
		//Raccoon on water
		FileNames[enum_Raccoon][0][Animal.N] = "opossum_N.png"; 
		FileNames[enum_Raccoon][0][Animal.NE] = "opossum_NE.png"; 
		FileNames[enum_Raccoon][0][Animal.NW] = "opossum_NW.png"; 
		FileNames[enum_Raccoon][0][Animal.S] = "opossum_S.png"; 
		FileNames[enum_Raccoon][0][Animal.SE] = "opossum_SE.png"; 
		FileNames[enum_Raccoon][0][Animal.SW] = "opossum_SW.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_Raccoon][2][i] = null; //no flying images
		
		//Salamander on land
		FileNames[enum_Salamander][1][Animal.N] = "Salamander_N.png"; 
		FileNames[enum_Salamander][1][Animal.NE] = "Salamander_NE.png"; 
		FileNames[enum_Salamander][1][Animal.NW] = "Salamander_NW.png"; 
		FileNames[enum_Salamander][1][Animal.S] = "Salamander_S.png"; 
		FileNames[enum_Salamander][1][Animal.SE] = "Salamander_SE.png"; 
		FileNames[enum_Salamander][1][Animal.SW] = "Salamander_SW.png"; 
		//Salamander on water
		FileNames[enum_Salamander][0][Animal.N] = "Salamander_N.png"; 
		FileNames[enum_Salamander][0][Animal.NE] = "Salamander_NE.png"; 
		FileNames[enum_Salamander][0][Animal.NW] = "Salamander_NW.png"; 
		FileNames[enum_Salamander][0][Animal.S] = "Salamander_S.png"; 
		FileNames[enum_Salamander][0][Animal.SE] = "Salamander_SE.png"; 
		FileNames[enum_Salamander][0][Animal.SW] = "Salamander_SW.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_Salamander][2][i] = null; //no flying images
		
		//Slug on land
		FileNames[enum_Slug][1][Animal.N] = "Slug_N.png"; 
		FileNames[enum_Slug][1][Animal.NE] = "Slug_NE.png"; 
		FileNames[enum_Slug][1][Animal.NW] = "Slug_NW.png"; 
		FileNames[enum_Slug][1][Animal.S] = "Slug_S.png"; 
		FileNames[enum_Slug][1][Animal.SE] = "Slug_SE.png"; 
		FileNames[enum_Slug][1][Animal.SW] = "Slug_SW.png";
		for(int i = 0; i<6; i++){
			FileNames[enum_Slug][2][i] = null; //no flying images
			FileNames[enum_Slug][0][i] = null; //no swimming images
		}
		
		//turtle on land
		FileNames[enum_SnappingTurtle][1][Animal.N] = "turtle_N.png"; 
		FileNames[enum_SnappingTurtle][1][Animal.NE] = "turtle_NE.png"; 
		FileNames[enum_SnappingTurtle][1][Animal.NW] = "turtle_NW.png"; 
		FileNames[enum_SnappingTurtle][1][Animal.S] = "turtle_S.png"; 
		FileNames[enum_SnappingTurtle][1][Animal.SE] = "turtle_SE.png"; 
		FileNames[enum_SnappingTurtle][1][Animal.SW] = "turtle_SW.png"; 
		//turtle on water
		FileNames[enum_SnappingTurtle][0][Animal.N] = "turtle_N.png"; 
		FileNames[enum_SnappingTurtle][0][Animal.NE] = "turtle_NE.png"; 
		FileNames[enum_SnappingTurtle][0][Animal.NW] = "turtle_NW.png"; 
		FileNames[enum_SnappingTurtle][0][Animal.S] = "turtle_S.png"; 
		FileNames[enum_SnappingTurtle][0][Animal.SE] = "turtle_SE.png"; 
		FileNames[enum_SnappingTurtle][0][Animal.SW] = "turtle_SW.png"; 
		for(int i = 0; i<6; i++)
			FileNames[enum_SnappingTurtle][2][i] = null; //no flying images
		
		//Tadpole in water
		FileNames[enum_Tadpole][0][Animal.N] = "tadpole_north.png"; 
		FileNames[enum_Tadpole][0][Animal.NE] = "tadpole_neast.png"; 
		FileNames[enum_Tadpole][0][Animal.NW] = "tadpole_nwest.png"; 
		FileNames[enum_Tadpole][0][Animal.S] = "tadpole_south.png"; 
		FileNames[enum_Tadpole][0][Animal.SE] = "tadpole_seast.png"; 
		FileNames[enum_Tadpole][0][Animal.SW] = "tadpole_swest.png"; 
		for(int i = 0; i<6; i++){
			FileNames[enum_Tadpole][2][i] = null; //no flying images
			FileNames[enum_Tadpole][1][i] = null; //no walking images
		}
	
		//Bee, on land
		FileNames[enum_Bee][1][Animal.N] = "bee_fly_N.png";
		FileNames[enum_Bee][1][Animal.NE] = "bee_fly_NE.png";
		FileNames[enum_Bee][1][Animal.NW] = "bee_fly_NW.png";
		FileNames[enum_Bee][1][Animal.S] = "bee_fly_S.png";
		FileNames[enum_Bee][1][Animal.SE] = "bee_fly_SE.png";
		FileNames[enum_Bee][1][Animal.SW] = "bee_fly_SW.png";
		//fly, in air
		FileNames[enum_Bee][2][Animal.N] = "bee_fly_N.png";
		FileNames[enum_Bee][2][Animal.NE] = "bee_fly_NE.png";
		FileNames[enum_Bee][2][Animal.NW] = "bee_fly_NW.png";
		FileNames[enum_Bee][2][Animal.S] = "bee_fly_S.png";
		FileNames[enum_Bee][2][Animal.SE] = "bee_fly_SE.png";
		FileNames[enum_Bee][2][Animal.SW] = "bee_fly_SW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_Bee][0][i] = null; //no swimming images
		
	
		//Catfish in water
		FileNames[enum_Catfish][0][Animal.N] = "Catfish_N.png"; 
		FileNames[enum_Catfish][0][Animal.NE] = "Catfish_NE.png"; 
		FileNames[enum_Catfish][0][Animal.NW] = "Catfish_NW.png"; 
		FileNames[enum_Catfish][0][Animal.S] = "Catfish_S.png"; 
		FileNames[enum_Catfish][0][Animal.SE] = "Catfish_SE.png"; 
		FileNames[enum_Catfish][0][Animal.SW] = "Catfish_SW.png"; 
		for(int i = 0; i<6; i++){
			FileNames[enum_Catfish][2][i] = null; //no flying images
			FileNames[enum_Catfish][1][i] = null; //no walking images
		}
		
		//TeeeHarvs, on land
		FileNames[enum_TeeeHarvs][1][Animal.N] = "harvN.png";
		FileNames[enum_TeeeHarvs][1][Animal.NE] = "harvN.png";
		FileNames[enum_TeeeHarvs][1][Animal.NW] = "harvN.png";
		FileNames[enum_TeeeHarvs][1][Animal.S] = "harvS.png";
		FileNames[enum_TeeeHarvs][1][Animal.SE] = "harvSE.png";
		FileNames[enum_TeeeHarvs][1][Animal.SW] = "harvSW.png";
		//TeeeHarvs, in water
		FileNames[enum_TeeeHarvs][0][Animal.N] = "harvN.png";
		FileNames[enum_TeeeHarvs][0][Animal.NE] = "harvN.png";
		FileNames[enum_TeeeHarvs][0][Animal.NW] = "harvN.png";
		FileNames[enum_TeeeHarvs][0][Animal.S] = "harvS.png";
		FileNames[enum_TeeeHarvs][0][Animal.SE] = "harvSE.png";
		FileNames[enum_TeeeHarvs][0][Animal.SW] = "harvSW.png";
		for(int i = 0; i<6; i++)
			FileNames[enum_TeeeHarvs][2][i] = null; //no flying images

	
	}
	
	
		/**
		 * Loads the pictures and the scales it
		 */
		public void loadPics(){
			storage = new BufferedImage[numActors][3][6][4][Animal.frameCount];
			 
			int enumActors, enumDepth, enumDir, enumZoom;
			for(enumActors = 0; enumActors < numActors; enumActors++){
				for(enumDepth = 0; enumDepth < 3; enumDepth++){
					for(enumDir = 0; enumDir < 6; enumDir++){
						if(FileNames[enumActors][enumDepth][enumDir] == null)
							for(enumZoom = 0; enumZoom<4; enumZoom++)
								storage[enumActors][enumDepth][enumDir][enumZoom] = null;
						else{
							storage[enumActors][enumDepth][enumDir][3] = splitImg(getImg(FileNames[enumActors][enumDepth][enumDir], animalSizes[enumActors]));
							
						}
					}
				}
			}
			scalePics();
		}
		
		//this must be separate from loadPics() to conserve heap memory
		/**
		 * Scales the pictures to the initial size
		 */
		public void scalePics(){
			
			int enumActors, enumDepth, enumDir, enumZoom;
			for(enumActors = 0; enumActors < numActors; enumActors++){
				for(enumDepth = 0; enumDepth < 3; enumDepth++){
					for(enumDir = 0; enumDir < 6; enumDir++){
						if(FileNames[enumActors][enumDepth][enumDir] != null){
							for(int picNum = 0; picNum < Animal.frameCount; picNum++){
								for(enumZoom = 0; enumZoom < 3; enumZoom++){
									if(enumZoom == 2)
										storage[enumActors][enumDepth][enumDir][enumZoom][picNum] = scalingOp3.filter(storage[enumActors][enumDepth][enumDir][3][picNum], null);
									else if(enumZoom == 1)
										storage[enumActors][enumDepth][enumDir][enumZoom][picNum] = scalingOp2.filter(storage[enumActors][enumDepth][enumDir][3][picNum], null);
									else if(enumZoom == 0)
										storage[enumActors][enumDepth][enumDir][enumZoom][picNum] = scalingOp1.filter(storage[enumActors][enumDepth][enumDir][3][picNum], null);
								}
							}
						}
					}
				}
			}
		}
	/**
	 * creates the new rescaled pictures in the correct directory	
	 * @param fileName name of the file to which the pictures correspond
	 * @param animalSize size of the animal
	 * @return either the new image or null
	 */
	private BufferedImage getImg(String fileName, int animalSize){
		String smallFileName = fileName.replace(".png", "small.png");
		File smallFile = new File("smallPics/"+ smallFileName);
		try{
		return ImageIO.read(smallFile);
		}catch(IOException e){
		}
		AffineTransformOp op;
		op = getFilter(animalSize);
		
			BufferedImage myImage;
		
		try{
			myImage = ImageIO.read(new File(fileName));
			myImage = op.filter(myImage, null);
			ImageIO.write(myImage, "png", smallFile);
			return myImage;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("couldn't find " + fileName);
		}
		return null; //if the try-stuff all fails
	}
				
	/**
	 * 
	 * @param smallImage  a BufferedImage sequence of images
	 * @return an array of images split from the sequence
	 */
	private BufferedImage[] splitImg(BufferedImage smallImage){
		if(smallImage == null)
			System.out.println("split image is recieving null images!");
		BufferedImage[] subImages = new BufferedImage[frameCount];
		  int width;
		  int height;
		    	width = smallImage.getWidth()/frameCount;
		    	height = smallImage.getHeight();
		    	for(int j = 0; j<frameCount; j++)
		    		subImages[j] = smallImage.getSubimage(j*width, 0, width, height);
		    return subImages;
	}
			
	    //different transforms for all desired animal sizes
	    AffineTransform tx1;
	    AffineTransformOp op1;
	    AffineTransform tx2;
	    AffineTransformOp op2;
	    AffineTransform tx3;
	    AffineTransformOp op3;
	    AffineTransform tx4;
	    AffineTransformOp op4;
	    AffineTransform tx5;
	    AffineTransformOp op5;
	    AffineTransform tx6;
	    AffineTransformOp op6;
	    AffineTransform plantShrink;
	    AffineTransformOp plantShrinkOp;
	    AffineTransform scaling3;
	    AffineTransformOp scalingOp3;
	    AffineTransform scaling2;
	    AffineTransformOp scalingOp2;
	    AffineTransform scaling1;
	    AffineTransformOp scalingOp1;
	    /**
	     * Sets the scale size with respects to the animal size
	     * @param AnimalSize
	     * @return the appropriate transform for the animal's size
	     */
	    AffineTransformOp getFilter(int AnimalSize){
	    	if(AnimalSize == 2)
	    		return op2;
	    	if(AnimalSize == 3)
	    		return op3;
	    	if(AnimalSize == 4)
	    		return op4;
	    	if(AnimalSize == 5)
	    		return op5;
	    	if(AnimalSize == 6)
	    		return op5;
	    	//otherwise
	    	return op1;
	    	
	    }
	    
	    /**
	     * function to set up affine transforms for each animal size
	     */
	    public void transformSetup(){
	    	tx1 = new AffineTransform();
			tx1.scale(1.0/transSize, 1.0/transSize);
			op1 = new AffineTransformOp(tx1, AffineTransformOp.TYPE_BILINEAR);
			
	    	tx2 = new AffineTransform();
			tx2.scale(2.0/transSize, 2.0/transSize);
			op2 = new AffineTransformOp(tx2, AffineTransformOp.TYPE_BILINEAR);
			
	    	tx3 = new AffineTransform();
			tx3.scale(3.0/transSize, 3.0/transSize);
			op3 = new AffineTransformOp(tx3, AffineTransformOp.TYPE_BILINEAR);
			
	    	tx4 = new AffineTransform();
			tx4.scale(4.0/transSize, 4.0/transSize);
			op4 = new AffineTransformOp(tx4, AffineTransformOp.TYPE_BILINEAR);
			
	    	tx5 = new AffineTransform();
			tx5.scale(5.0/transSize, 5.0/transSize);
			op5 = new AffineTransformOp(tx5, AffineTransformOp.TYPE_BILINEAR);
	    	
	    	tx6 = new AffineTransform();
			tx6.scale(6.0/transSize, 6.0/transSize);
			op6 = new AffineTransformOp(tx6, AffineTransformOp.TYPE_BILINEAR);
	    
			scaling3 = new AffineTransform();
			scaling3.scale(0.8571428571, 0.8571428571);
			scalingOp3 = new AffineTransformOp(scaling3, AffineTransformOp.TYPE_BILINEAR);
			
			scaling2 = new AffineTransform();
			scaling2.scale(0.7142857143, 0.7142857143);
			scalingOp2 = new AffineTransformOp(scaling2, AffineTransformOp.TYPE_BILINEAR);
	    
			scaling1 = new AffineTransform();
			scaling1.scale(0.5714285714, 0.5714285714);
			scalingOp1 = new AffineTransformOp(scaling1, AffineTransformOp.TYPE_BILINEAR);
	    
			plantShrink = new AffineTransform();
			plantShrink.scale(0.6, 0.6);
			plantShrinkOp = new AffineTransformOp(plantShrink, AffineTransformOp.TYPE_BILINEAR);
	    
	    }

	    
	    
	   /**
	     * @name getImage function for Actor
	     * 
	     * 
	     * @param a     takes an Actor for layer and, if animal, direction
	     * @param picNum      which frame in sequence
	     * @return  a BufferedImage to be stored in Actor
	     */
	    public BufferedImage getPic(Actor b, int picNum){
	    	int depth = b.z;
	    	if(b.z > 0)
	    		depth--;
		if(b instanceof Plant){
			Plant a = (Plant)b;
			if(a.isSeed)
				return plantStorage[0][Gui.scale -1];
			else if(a instanceof Algae)
				return plantStorage[1][Gui.scale -1];
			else if(a instanceof Flower)
				return plantStorage[2][Gui.scale -1];
			else if(a instanceof Fungus)
				return plantStorage[3][Gui.scale -1];
			else //if(a instanceof SmallPlant)
				return plantStorage[4][Gui.scale -1];
		}
		else if(b instanceof Alligator){
			Animal a = (Animal)b;
			return storage[enum_Alligator][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Catfish){
			Animal a = (Animal)b;
			return storage[enum_Catfish][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Crayfish){
			Animal a = (Animal)b;
			return storage[enum_Crayfish][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Cricket){
			Animal a = (Animal)b;
			return storage[enum_Cricket][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Dragonfly){
			Animal a = (Animal)b;
			return storage[enum_Dragonfly][depth][a.dir][Gui.scale-1][a.picNum];
		}

		else if(b instanceof Duck){
			Animal a = (Animal)b;
			return storage[enum_Duck][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Egret){
			Animal a = (Animal)b;
			return storage[enum_Egret][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Fly){
			Animal a = (Animal)b;
			return storage[enum_Fly][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Frog){
			Animal a = (Animal)b;
			return storage[enum_Frog][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Grasshopper){
			Animal a = (Animal)b;
			return storage[enum_Grasshopper][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Heron){
			Animal a = (Animal)b;
			return storage[enum_Heron][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Moccassin){
			Animal a = (Animal)b;
			return storage[enum_Moccassin][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Mouse){
			Animal a = (Animal)b;
			return storage[enum_Mouse][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof NutriaRat){
			Animal a = (Animal)b;
			return storage[enum_NutriaRat][depth][a.dir][Gui.scale-1][a.picNum];	
		}
		else if(b instanceof Perch){
			Animal a = (Animal)b;
			return storage[enum_Perch][depth][a.dir][Gui.scale-1][a.picNum];	
		}
		 else if(b instanceof Possum){
			Animal a = (Animal)b;
			return storage[enum_Possum][depth][a.dir][Gui.scale-1][a.picNum];
		 }

		else if(b instanceof Salamander){
			Animal a = (Animal)b;
			return storage[enum_Salamander][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Slug){
			Animal a = (Animal)b;
			return storage[enum_Slug][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof SnappingTurtle){
			Animal a = (Animal)b;
			return storage[enum_SnappingTurtle][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Tadpole){
			Animal a = (Animal)b;
			return storage[enum_Tadpole][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Worm){
			Animal a = (Animal)b;
			return storage[enum_Worm][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof Bee){
			Animal a = (Animal)b;
			return storage[enum_Bee][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else if(b instanceof TeeeHarvs){
			Animal a = (Animal)b;
			return storage[enum_TeeeHarvs][depth][a.dir][Gui.scale-1][a.picNum];
		}
		else{ //if(b instanceof Raccoon){
			Animal a = (Animal)b;
			return storage[enum_Raccoon][depth][a.dir][Gui.scale-1][a.picNum];
		}
	}
}
	   