package MVCorganization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Initializes background images for the GUI to display
 * @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public class Background extends JPanel{
	Image img[];
	Image imgSmall;
	public PriorityQueue<Actor> children;
	
	public static Polygon allBounds;
	public static Polygon waterBounds;
	public static Collection<Polygon> obstacles;
	/**
	 * Initializes the background image and sets the obstacles and boundries of the features of the background
	 */
	public Background(){
		
		img = new Image[4];
	    try {
			img[0] = ImageIO.read(new File("InProgressSwampBackground.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		img[0] = img[0].getScaledInstance(img[0].getWidth(this), -1, Image.SCALE_SMOOTH);
		img[1] = img[0].getScaledInstance(5*img[0].getWidth(this)/4, -1, Image.SCALE_SMOOTH);
		img[2] = img[0].getScaledInstance(6*img[0].getWidth(this)/4, -1, Image.SCALE_SMOOTH);
		img[3] = img[0].getScaledInstance(7*img[0].getWidth(this)/4, -1, Image.SCALE_SMOOTH);
		
//		AffineTransform scalingUp = new AffineTransform();
//	    scalingUp.scale(3.0, 3.0);
//	    AffineTransformOp scalingUpOp = new AffineTransformOp(scalingUp, AffineTransformOp.TYPE_BILINEAR);
//		
//	    AffineTransform scaling = new AffineTransform();
//	    scaling.scale(0.5, 0.5);
//	    AffineTransformOp scalingOp = new AffineTransformOp(scaling, AffineTransformOp.TYPE_BILINEAR);
//
//	    img[3] = scalingUpOp.filter(img[3], null);
//	    img[2] = scalingOp.filter(img[3], null);
//	    img[1] = scalingOp.filter(img[2], null);
//	    img[0] = scalingOp.filter(img[1], null);
	    
	    Gui.mapWidth = img[0].getWidth(null);
		Gui.mapHeight = img[0].getHeight(null);
		
		//set up the Global allBounds polygon
		int[] aBx = {0, Gui.mapWidth, Gui.mapWidth, 0};
		int[] aBy = {0, 0, Gui.mapHeight, Gui.mapHeight};
		allBounds = new Polygon(aBx, aBy, 4);
		//set up the Global waterBounds polygon
//		int[] wBx = {300, 400, 500, 800, 900, 1000, 900, 600, 400};
//		int[] wBy = {500, 400, 350, 350, 400, 600, 650, 700, 650};
//		waterBounds = new Polygon(wBx, wBy, 9);
		

		int[] wBx = {1500,1460,1448,1426,1416,1416,1412,1404,1386,1386,1370,1358,1342,1346,1362,1360,1340,1340,1350,1352,1344,1326,1288,1276,1252,1218,1184,1150,1134,1134,1104,1034,986,968,948,906,886,830,840,838,824,799,809,820,840,858,866,862,850,832,768,714,684,662,560,500,464,434,404,406,428,398,358,314,312,334,312,318,308,272,246,208,176,192,178,192,160,170,162,116,86,64,0,0,402,889,916,936,1012,1038,1060,1102,1080,1116,1176,1142,1146,1215,1238,1210,1276,1278,1318,1500};
		int[] wBy = {584,594,578,564,588,614,622,626,620,598,598,590,606,618,634,642,656,678,694,700,710,716,720,730,740,736,742,728,676,654,634,632,646,622,592,578,582,660,690,712,736,780,794,802,800,810,838,862,868,876,890,882,896,966,1030,1032,1002,990,916,896,872,826,848,840,814,792,780,756,742,748,764,814,820,844,888,952,998,1032,1052,1110,1116,1108,1166,1500,1500,1500,1416,1354,1342,1322,1316,1322,1296,1264,1238,1208,1185,1160,1124,1098,1052,1004,950,926};
        waterBounds = new Polygon(wBx, wBy, wBx.length);
		
		//set up obstacles  (these will be trees, later?)
		obstacles = new ArrayList<Polygon>();
		int[] xo1 = {889,916,936,1012,1038,1060,1102,1080,1116,1176,1142,1146,1215,1238,1210,1276,1278,1318,1500,1500};
		int[] yo1 = {1500,1416,1354,1342,1322,1316,1322,1296,1264,1238,1208,1185,1160,1124,1098,1052,1004,950,926,1500};
		int[] xo2 = {0,72,48,85,96,139,120,129,190,226,229,241,234,289,265,304,315,355,333,355,387,391,429,432,445,436,463,462,478,490,490,514,550,552,570,586,600,607,618,618,612,663,684,694,708,696,712,769,783,783,799,792,810,822,862,844,852,915,949,969,957,1014,0};
		int[] yo2 = {375,402,445,477,483,447,412,370,379,325,397,397,312,325,373,408,408,379,441,438,355,378,370,399,396,321,322,382,382,250,228,208,198,178,177,193,241,331,342,243,235,198,289,294,178,162,193,294,334,340,264,277,280,241,202,169,175,118,120,13,0,0,0};
		obstacles.add(new Polygon(xo1, yo1, xo1.length));
		obstacles.add(new Polygon(xo2, yo2, xo2.length));

	    Dimension size = new Dimension(img[0].getWidth(null), img[0].getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    
	    children = new PriorityQueue<Actor>();
	}
	/**
	 * Causes graphics to be displayed
	 */
	public void paint(Graphics g){
		//Global.painting = true;
		super.paint(g);
		g.drawImage(img[Gui.scale-1], 0, 0, this);
		
		/*
		//to show bounds - remove these lines later
		g.setColor(Color.BLUE);
		g.fillPolygon(waterBounds);
		for(Polygon a: obstacles){
			g.setColor(Color.BLACK);
			g.fillPolygon(a);
		}
		*/
		//end section to remove
	
		//g.setColor(Color.WHITE);
		/*for (int i = 0; i <= 5; i++){
			Iterator<Actor> it = children.iterator();
			Actor a;
			while (it.hasNext()){
				a = it.next();
			//for (Animal a : children){
				
				if (a.z == i){
					//A scalability feature for animal sizes can be added once code is optimized more.  Too much flashing without
					//g.drawImage(a.pictures[a.picNum].getScaledInstance(a.pictures[a.picNum].getWidth()*Global.scale, -1, Image.SCALE_FAST), a.x*Global.scale, a.y*Global.scale, this);
					g.drawImage(a.pictures[a.picNum], a.x*Global.scale, a.y*Global.scale, null);
					//g.drawString(a.name, (a.x + 70)*Global.scale, (a.y + 20)*Global.scale);
					//g.drawImage(a.pictures[a.picNum], a.x, a.y, null);
					//g.drawString(a.name, (a.x + 70), (a.y + 20));
				}
			}
		}*/
		Actor a = children.poll();
		while (a != null){
			g.drawImage(a.picture, a.x*Gui.scale, a.y*Gui.scale, null);
			a = children.poll();
		}
		
		Gui.backpainting = false;
	}
	
	/**
	 * Adds actors to children
	 * @param a actor that will be added
	 */
	public void add(Actor a){
		children.add(a);
	}
}
