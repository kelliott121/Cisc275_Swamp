package MVCorganization;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Animals.Alligator;
import Animals.Bee;
import Animals.Butterfly;
import Animals.Catfish;
import Animals.Duck;
import Animals.Fly;
import Animals.Frog;
import Animals.Heron;
import Animals.Moccassin;
import Animals.Mouse;
import Animals.NutriaRat;
import Animals.Perch;
import Animals.Possum;
import Animals.Raccoon;
import Animals.Salamander;
import Animals.Slug;
import Animals.Tadpole;
import Animals.TeeeHarvs;
import Animals.SnappingTurtle;
/**
 *  This class creates the Graphical User Interface
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
@SuppressWarnings("serial")
public class Gui extends JFrame implements ChangeListener, MouseListener{
	int speed = 1;
	static int scale = 1;
	static double scaleFactor = 1.25;
	static int mapWidth;
	static int mapHeight;
	
	static boolean minipainting = false;
	static boolean backpainting = false;
	static int paintDelay = 0;

	
	public ImageIcon img;
	public Background background;
	public Minimap minimap;
	public JSlider zoomSlide;
	public JSlider speedSlide;
	public JScrollPane scroll;
	public Container content;
	public JSplitPane splitPane;
	public JSplitPane bottomPane;
	public JSplitPane infoPane;
	public JList statusPane;
	public JComponent animalPane;
	public JTextPane animalStatus;
	public JPanel animalEdit;
	//public JTextPane statusPane;
	public boolean actorClicked = false;
	public Actor followedActor = null;
	public Point clickedPoint;
	public static ImageRepo imageRepo;
	//private boolean isEaster = false;

	/**
	 * This sets up the initial conditions of the GUI
	 */
	Gui(){
	
	    super("Swamp Simulation");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    imageRepo = new ImageRepo();
		imageRepo.loadPics();

		setFocusable(true);
		/*
		addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        .requestFocusInWindow();
		    }
		};*/
		

		background = new Background();

		background.addMouseListener(this);
		
		scroll = new JScrollPane(background);
		scroll.getViewport().addChangeListener(this);
		minimap = new Minimap(background.img[0]);
		//minimap.setMinimumSize(new Dimension(minimap.getHeight(), minimap.getWidth()));
		minimap.setMaximumSize(new Dimension(minimap.getHeight(), minimap.getWidth()));
		
		content = getContentPane();
		
	    //content.add(minimap);
		
	    zoomSlide = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
	    zoomSlide.addChangeListener(this);
	    zoomSlide.setMajorTickSpacing(1);
	    zoomSlide.setPaintTicks(true);
	    zoomSlide.setPaintLabels(true);
	    zoomSlide.setSnapToTicks(true);
	    zoomSlide.setFont(new Font("Serif", Font.ITALIC, 15));
	    zoomSlide.setLocation(0, 0);
	    
	    speedSlide = new JSlider(JSlider.VERTICAL, 0, 5, 1);
	    speedSlide.addChangeListener(this);
	    speedSlide.setMajorTickSpacing(1);
	    speedSlide.setPaintTicks(true);
	    speedSlide.setPaintLabels(true);
	    speedSlide.setSnapToTicks(true);
	    speedSlide.setFont(new Font("Serif", Font.ITALIC, 15));
	    speedSlide.setLocation(0, 0);
	    
	    scroll.getViewport().addChangeListener(this);
	    
	    animalStatus = new JTextPane();
	    animalStatus.setEditable(false);
	    animalPane = animalStatus;
	    
	    
	    statusPane = new JList();
	    statusPane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    statusPane.setVisibleRowCount(10);
	    statusPane.setLayoutOrientation(JList.VERTICAL_WRAP);
	    statusPane.addMouseListener(this);
	    
	    infoPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, statusPane, animalPane);
	    infoPane.setDividerLocation(400);
	    //infoPane.setEnabled(false);
	    
	    bottomPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, minimap, infoPane);
	    bottomPane.setDividerLocation(minimap.getWidth());
	    bottomPane.setEnabled(false);
	    
	    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scroll, bottomPane);
	    splitPane.setDividerLocation(getHeight() - minimap.getHeight());
	    splitPane.setResizeWeight(1.0);
	    splitPane.setEnabled(false);
	    
	    minimap.addMouseListener(this);
	    
	    content.add(splitPane);
	    content.add(zoomSlide, BorderLayout.SOUTH);
	    content.add(speedSlide, BorderLayout.EAST);
	    
	    setSize(1000, 1000);
	    setVisible(true);
	}
	/**
	 * 
	 */
	public void scale(){
	}
	/**
	 * Updates the pictures of all actors in the GUI
	 * @param actors the array of all actors
	 */
	public void update(AllActors actors){
		//int numAn = 0;
		Actor.dayCount+=16;
		background.children.clear();
		minimap.children.clear();
		
		backpainting = true;
		minipainting = true;
		for(int i=0; i<actors.maxSize;i++){
			for (Actor a : actors.array.get(i)){
				a.lastPicture = a.picture;
				a.picture = imageRepo.getPic(a, a.picNum);
				background.add(a);
				if(a instanceof Animal){
					minimap.add(a);
				}
				/*
				if(i != 0){
					if (!((Animal)a).corpse)
						numAn++;
				}*/
				if (actorClicked && a.getRectangle().contains(clickedPoint)){
					followedActor = a;
					actorClicked = false;
				}
			}
		}
		
		this.repaint();
		
		paintDelay = 0;
		while (backpainting || minipainting){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paintDelay++;
		}
	
		if (actorClicked)
			followedActor = null;
		
		if (followedActor != null){
			animalStatus.setText(followedActor.toString());
		}
		else
			animalStatus.setText("");
		
		//if (Animal.dayCount%100 == 0)
		statusPane.setListData(Animal.toVector());
	}
	/**
	 * This Checks if the mouse has been clicked to move one of the sliders or the scroll bar
	 */
	public void stateChanged(ChangeEvent e) {
			if (e.getSource() == zoomSlide && zoomSlide.getValue() != scale){
				scale = zoomSlide.getValue();
				scale();
				minimap.scale();
			}
			else if (e.getSource() == speedSlide){
				speed = speedSlide.getValue();
			}
			else if (e.getSource() instanceof JViewport){
				minimap.changeViewPort(scroll.getViewport().getViewRect());
				//repaint();
			}
		
		//this.repaint();
	}
	/**
	 * This causes the image on the minimap to move to the clicked position
	 */
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() instanceof Minimap){
			int newX;
			int newY;
			
			newX = (int)((e.getX() - minimap.viewPort.width/2)*minimap.scaleFactor);
			newY = (int)((e.getY() - minimap.viewPort.height/2)*minimap.scaleFactor);
			
			scroll.getViewport().setViewPosition(new Point(newX, newY));
			repaint();
		}
		else if (e.getSource() instanceof Background){
			e.getModifiers();
			if(e.getButton() == MouseEvent.BUTTON3 || e.getButton() == MouseEvent.BUTTON2){
				Actor x = new TeeeHarvs(Animal.S, Animal.onGround, e.getX(), e.getY());
				//((Animal)x).hp.lose(6000); //sorry!  For hunger.
				Animal.actors.actorAdd(x);
			}
			actorClicked = true;
			clickedPoint = e.getPoint();
		}
//		else if (e.getSource() == statusPane){
//			String instance = (String) statusPane.getSelectedValue();
//			if (instance.startsWith("Alligators"))
//				animalPane = new AnimalEdit(Alligator.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Bees"))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Butterflies"))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Ducks: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Flies: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Frogs: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Herons: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Moccassins: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Mice: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Nutria Rats: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Perch: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Possums: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Raccoons: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Newts: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Slug: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Turtles: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Tadpoles: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);
//			else if (instance.startsWith("Catfish: "))
//				animalPane = new AnimalEdit(a.hp.getMax(), a.gestateTime, 0);	
//		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
}
