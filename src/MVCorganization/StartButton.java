package MVCorganization;

import MVCorganization.StartScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * a supporting class to manage the button in StartScreen.java
 * This class records the user's input in a file (so they don't have to start
 * from scratch every time), and the sets StartScreen's terminate flag to true
 * so that the loop in Emulation can end, and the simulation can commence.
 * @author curtis
 *
 */
public class StartButton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {

	      try{
	    // Create file 
	    FileWriter fstream = new FileWriter("lastNumbers.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    for(int i = 0; i < 27; i++)
	    	out.write(StartScreen.input[i].getText()+ " ");
	    //Close the output stream
	    out.close();
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }
		
		StartScreen.terminate = true;
	}

}
