package starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//this class should be responsible for establishing the rules but not making the game function
public abstract class Gamemode extends GraphicsProgram{//made it so that we can add mouselisteners and listen to events
	public static final int HOLE_X_PADDING = 75;
	public static final int BOTTOM_ROW_PADDING = 60;
	public static final int TOP_ROW_PADDING = 37;
	protected Difficulty currentDLevel;
	protected Mole molesInHoles[];//This is the number of moles to appear on screen? A)No, its an array to hold the moles
	protected boolean gameOver;
	protected int score;
	protected boolean moleWasHit;
	
	public void run() {
		addMouseListeners();
		
	}
	
	//Constructors for Game mode
	Gamemode(){
		currentDLevel = new Difficulty();
		score = 0;
		gameOver = false;
		moleWasHit = false;
	}
	Gamemode(Difficulty d){
		currentDLevel = d;
		score = 0;
		gameOver = false;
	}
	
	public Difficulty getDifficulty() {
		return currentDLevel;
	}
	
	public void setStatus(boolean value) {	//added getters and setters for the game over so that later
		gameOver = value;						//it can be called by the abstract endGame method
	}
	
	public boolean getStatus() {
		return gameOver;
	}
	public Mole[] getMoleArray() {
		return molesInHoles;
	}
	
	//This method will create an array of the appropriate size for the current game
	public void setupMoles(int value) {
			switch(value) {
				case 0:
					molesInHoles = new Mole[3];
					break;
				case 1:
					molesInHoles = new Mole[4];
					break;
				case 2:
					molesInHoles = new Mole[6];
					break;
				case 3:
					molesInHoles = new Mole[9];
					break;
			}
			/*
			for(int i = 0; i < molesInHoles.length; i++) {
				//did we already assign an image to this when we do this?
				molesInHoles[i] = new Mole();
			}*/
		}
	
		public void mousePressed(MouseEvent e, GObject current) {//how do we connect the mole with the mouse?
			//do we make a loop to check if we clicked on the mole for every mole in the array?
			for (int i=0; i < molesInHoles.length; i++ ) {
				if (current.equals(molesInHoles[i].getMoleImage())) {
					calculateScore();
					molesInHoles[i].moveMoleDown();
					break;
					//may need to consider animations here
				}
			}
		}

	
		//this method will assign the x and y coordinates for each spawns point
		public void setupHoles(int windowWidth, int windowHeight) {
			float x;
			
			//The y position for the middle row of holes
			float y = (windowHeight * (3/4f)); // estimates may need to change later
			
			//At a minimum we will need 3 holes. We always create the first 3 in the middle row.
			for(int i = 1; i <= 3; i++) {
				x = (windowWidth * ((i-1)/3f)) + HOLE_X_PADDING;
				molesInHoles[i-1]= new Mole((new SpawnPoint(x, y)));
			}
			
			//Now if easy is selected we will only need 4 holes but if Hard is selected we will need 6.
			//If statement determines if we have at least 4 moles
			if(molesInHoles.length == 4) {
				//The y position for the bottom row of holes
				y = (windowHeight * (2/3f)) - TOP_ROW_PADDING;// estimates may need to change later
				
				x = (windowWidth * (1/3f)) + HOLE_X_PADDING;
				molesInHoles[3] = new Mole(new SpawnPoint(x, y));
				
			}
			//All that is left is to generate the final row of holes if necessary (TOP ROW)
			if(molesInHoles.length >= 6) {
				//The y position for the top row of holes
				y = (windowHeight * (2/3f)) - TOP_ROW_PADDING;// estimates may need to change later
				
				for(int i = 1; i <= 3; i++) {
					x = (windowWidth * ((i-1)/3f)) + HOLE_X_PADDING;
					molesInHoles[i+2] = new Mole(new SpawnPoint(x, y));
				}
			}
			if(molesInHoles.length == 9) {
				//The y position for the top row of holes
				y = (windowHeight * (4/5f)) + BOTTOM_ROW_PADDING;// estimates may need to change later
				
				for(int i = 1; i <= 3; i++) {
					x = (windowWidth * ((i-1)/3f)) + HOLE_X_PADDING;
					molesInHoles[i+5]= new Mole(new SpawnPoint(x, y));
				}
			}
			
		}
		
		//This method will randomly select
		//this method will call the functions for the game
		//I also believe we should remove this method
		//This class should just be in responsible for the rules 
		public void playGame() {
			Random index = new Random();
			//The game will end when gameOver = true
			while(!gameOver) {
				/**This is an example of how we can use the number of moles without explicitly 
				 * storing them in memory
				*/
//				int temp = index.nextInt(molesInHoles.length);
//				molesInHoles[temp].animate();
			}
		}
		
		//The following methods are abstract because each mode will implement them slightly differently
		abstract void calculateScore();
		abstract boolean endGame();//This is to end the game right?
}
