package MVCorganization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.PriorityQueue;

import javax.swing.JPanel;
/**
 * Creates the minimap to be displayed by the GUI
 * 
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
 
@SuppressWarnings("serial")
public class Minimap extends JPanel{
	Image img;
	int width = 300;
	double scaleFactor;
	double minimapScale;
	Rectangle viewPort;
	
	PriorityQueue<Actor> children;
	/**
	 * Obtains the image for the minimap and scales it to the correct size
	 * @param image the background image
	 */
	Minimap(Image image){
		img = image.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
		scaleFactor = ((double)Gui.mapWidth)/(double)width;
		minimapScale = ((double)Gui.mapWidth)/(double)width;

	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    
	    children = new PriorityQueue<Actor>();
	    
	}
	/**
	 * paints the minimap so the user can see it
	 */
	public void paint(Graphics g){
		//Global.painting = true;
		super.paint(g);
		g.drawImage(img, 0, 0, this);
		Graphics2D ga = (Graphics2D) g;
		/*for (int i = 0; i <= 5; i++){
			for (Actor a : children){
				if (a.z == i){
					ga.setColor(Color.RED);
					//ga.fillOval((int)((a.x + a.pictures[a.picNum].getWidth()/2)/minimapScale), (int)((a.y + a.pictures[a.picNum].getHeight()/2)/minimapScale), a.size/2, a.size/2);
					ga.fillOval((int)((a.x + a.pictures[a.picNum].getWidth()/2 - a.size)/minimapScale), (int)((a.y + a.pictures[a.picNum].getHeight()/2 - a.size)/minimapScale), a.size*2, a.size*2);
				}
			}
		}*/
		ga.setColor(Color.RED);
		Actor a = children.poll();
		while (a != null){
			ga.fillOval((int)((a.x + a.picture.getWidth()/2 - a.size)/minimapScale), (int)((a.y + a.picture.getHeight()/2 - a.size)/minimapScale), a.size*2, a.size*2);
			a = children.poll();
		}
		g.setColor(Color.WHITE);
		g.drawRect(viewPort.x, viewPort.y, viewPort.width, viewPort.height);
		
		Gui.minipainting = false;
	}
	
	public void add(Actor a){
		children.add(a);
	}
	/**
	 * sets a scale factor to correspond to the actual backgound 
	 */
	public void scale(){
		scaleFactor = (Gui.mapWidth*Gui.scale)/width;
	}
	/**
	 * Changes the viewport dependent on the position of the rectangle
	 * Used to show the area viewed on the minimap
	 * @param rect
	 */
	public void changeViewPort(Rectangle rect){
		viewPort = new Rectangle((int)(rect.x/scaleFactor), (int)(rect.y/scaleFactor), (int)(rect.width/scaleFactor), (int)(rect.height/scaleFactor));
	}
}
