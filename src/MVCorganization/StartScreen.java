package MVCorganization;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 	This class creates the start screen used by the emulation and sets its initial values
 *  @author Curtis Kisielius, Keith Elliott, Oran Cluskey-Gallagher, Jeffrey Townsend, Joshua Wolford, Scott Buckley
 *
 */
public class StartScreen extends JFrame{
	
	static boolean terminate = false;
	static int[] arr = {10, 6, 30, 10, 0, 0, 0, 10, 0, 50, 50, 10, 5, 0, 0, 0, 20, 5, 10, 0, 10, 20,50, 30, 0, 40, 0};
	public static JTextField[] input = new JTextField[27];
	
	/**
	 * Sets initial values of start screen
	 */
	public StartScreen(){
		File listFile = new File("lastNumbers.txt");
		if(listFile.exists()){
			Scanner sc;
			try {
				sc = new Scanner(listFile);
				String line = sc.nextLine();
				String[] numbers = line.split(" ");
			
				arr = new int[numbers.length];
				for(int i=0;i<numbers.length;i++)
				arr[i] = Integer.parseInt(numbers[i]);
			} catch (FileNotFoundException e) {
			}

		}
		
		//read in from last saved file:
			
		
		
		Label titleLabel = new Label("Adjust Parameters, then click:"); 
		Button btn1 = new Button("Start Simulation"); 
		btn1.addActionListener(new StartButton());
		
		add(titleLabel); 
		add(btn1);
		
		
		
		
		//algae
		Label algaeLabel = new Label("Starting Number of Algae:");
		input[0] = new JTextField(Integer.toString(arr[0]));
		add(algaeLabel); add(input[0]);
		//gators
		Label AlligatorLabel = new Label("Starting Number of Alligators:");
		input[1] = new JTextField(Integer.toString(arr[1]));
		add(AlligatorLabel); add(input[1]);
		//bees
		Label BeeLabel = new Label("Starting Number of Bees:");
		input[2] = new JTextField(Integer.toString(arr[2]));
		add(BeeLabel); add(input[2]);
		//catfish
		Label CatFishLabel = new Label("Starting Number of CatFish:");
		input[3] = new JTextField(Integer.toString(arr[3]));
		add(CatFishLabel); add(input[3]);
		//crayfish
		Label CrayFishLabel = new Label("Starting Number of CrayFish:");
		input[4] = new JTextField(Integer.toString(arr[4]));
		add(CrayFishLabel); add(input[4]);
		//Cricket
		Label CricketLabel = new Label("Starting Number of Crickets:");
		input[5] = new JTextField(Integer.toString(arr[5]));
		add(CricketLabel); add(input[5]);
		//Dragon
		Label DragonflyLabel = new Label("Starting Number of Dragonflies:");
		input[6] = new JTextField(Integer.toString(arr[6]));
		add(DragonflyLabel); add(input[6]);
		//DuckLabel
		Label DuckLabel = new Label("Starting Number of Ducks:");
		input[7] = new JTextField(Integer.toString(arr[7]));
		add(DuckLabel); add(input[7]);
		//Egret
		Label EgretLabel = new Label("Starting Number of Egrets:");
		input[8] = new JTextField(Integer.toString(arr[8]));
		add(EgretLabel); add(input[8]);
		//Flower
		Label FlowerLabel = new Label("Starting Number of Flowers:");
		input[9] = new JTextField(Integer.toString(arr[9]));
		add(FlowerLabel); add(input[9]);
		//Fly
		Label FlyLabel = new Label("Starting Number of Flies:");
		input[10] = new JTextField(Integer.toString(arr[10]));
		add(FlyLabel); add(input[10]);
		//Frog
		Label FrogLabel = new Label("Starting Number of Frogs:");
		input[11] = new JTextField(Integer.toString(arr[11]));
		add(FrogLabel); add(input[11]);
		//Fungus
		Label FungusLabel = new Label("Starting Number of Fungi:");
		input[12] = new JTextField(Integer.toString(arr[12]));
		add(FungusLabel); add(input[12]);
		//Grasshopper
		Label GrasshopperLabel = new Label("Starting Number of Grasshoppers:");
		input[13] = new JTextField(Integer.toString(arr[13]));
		add(GrasshopperLabel); add(input[13]);
		//Heron
		Label HeronLabel = new Label("Starting Number of Herons:");
		input[14] = new JTextField(Integer.toString(arr[14]));
		add(HeronLabel); add(input[14]);
		//Moccassin
		Label MoccassinLabel = new Label("Starting Number of Moccassins:");
		input[15] = new JTextField(Integer.toString(arr[15]));
		add(MoccassinLabel); add(input[15]);
		//Mouse
		Label MouseLabel = new Label("Starting Number of Mice:");
		input[16] = new JTextField(Integer.toString(arr[16]));
		add(MouseLabel); add(input[16]);
		//Nutria
		Label NutriaLabel = new Label("Starting Number of Rats:");
		input[17] = new JTextField(Integer.toString(arr[17]));
		add(NutriaLabel); add(input[17]);
		//Perch
		Label PerchLabel = new Label("Starting Number of Perch:");
		input[18] = new JTextField(Integer.toString(arr[18]));
		add(PerchLabel); add(input[18]);
		//Possum
		Label PossumLabel = new Label("Starting Number of Possums:");
		input[19] = new JTextField(Integer.toString(arr[19]));
		add(PossumLabel); add(input[19]);
		//raccoon
		Label RaccoonLabel = new Label("Starting Number of Raccoons:");
		input[20] = new JTextField(Integer.toString(arr[20]));
		add(RaccoonLabel); add(input[20]);
		//Salamander
		Label SalamanderLabel = new Label("Starting Number of Salamaders:");
		input[21] = new JTextField(Integer.toString(arr[21]));
		add(SalamanderLabel); add(input[21]);
		//Slug
		Label SlugLabel = new Label("Starting Number of Slugs:");
		input[22] = new JTextField(Integer.toString(arr[22]));
		add(SlugLabel); add(input[22]);
		//Small Plant
		Label ShrubLabel = new Label("Starting Number of Small Plants:");
		input[23] = new JTextField(Integer.toString(arr[23]));
		add(ShrubLabel); add(input[23]);
		//Turtle
		Label TurtleLabel = new Label("Starting Number of Snapping Turtles:");
		input[24] = new JTextField(Integer.toString(arr[24]));
		add(TurtleLabel); add(input[24]);
		//TadpoleLabel
		Label TadpoleLabel = new Label("Starting Number of Tadpoles:");
		input[25] = new JTextField(Integer.toString(arr[25]));
		add(TadpoleLabel); add(input[25]);
		//Worm
		Label WormLabel = new Label("Starting Number of Worm:");
		input[26] = new JTextField(Integer.toString(arr[26]));
		add(WormLabel); add(input[26]);
		
		setSize(475, 600); 
		setLayout(new GridLayout(30, 2)); 
		setVisible(true);
	
	}
	/**
	 * Closes the start screen when a certain even happens
	 */
    public void closeStartScreen() {
    	//System.out.println("Closing Start Screen!!!!!");
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
}

}
