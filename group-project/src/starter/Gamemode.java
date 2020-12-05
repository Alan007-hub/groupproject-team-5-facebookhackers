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
			for(Mole moleTemp: molesInHoles) {
				moleTemp = new Mole();//did we already assign an image to this when we do this?
			}
		}
	
		public void mousePressed(MouseEvent e) {//how do we connect the mole with the mouse?
			//do we make a loop to check if we clicked on the mole for every mole in the array?
			for (int i=0; i < molesInHoles.length; i++ ) {
				if (getElementAt( e.getX() , e.getY() ) == molesInHoles[i].getMoleImage()) {
					calculateScore();
					i = molesInHoles.length;
					//may need to consider animations here
				}
			}
		}

	
		//this method will assign the x and y coordinates for each spawns point
		public void setupHoles(int windowWidth, int windowHeight) {
			int x = windowWidth;
			
			//The y position for the middle row of holes
			int y = windowHeight * (3/4); // estimates may need to change later
			
			//At a minimum we will need 3 holes. We always create the first 3 in the middle row.
			for(int i = 1; i <= 3; i++) {
				x = x * (i/3);
				molesInHoles[i-1].setSpawn(new SpawnPoint(x, y));
			}
			
			//Now if easy is selected we will only need 4 holes but if Hard is selected we will need 6.
			//If statement determines if we have at least 4 moles
			if(molesInHoles.length >= 4) {
				x = windowWidth;
				
				//The y position for the bottom row of holes
				y = windowHeight * (4/5);// estimates may need to change later
				for(int i = 1; i <= 3; i++) {
					x = x * (i/3);
					molesInHoles[i+2].setSpawn(new SpawnPoint(x, y));
				
					//if we only have 4 holes then we stop the for loop after one iteration
					if(molesInHoles.length == 4) {
						i = 4;
					}
				}
			}
			//All that is left is to generate the final row of holes if necessary (TOP ROW)
			if(molesInHoles.length > 6) {
				x = windowWidth;
				
				//The y position for the top row of holes
				y = windowHeight * (2/3);// estimates may need to change later
				
				for(int i = 1; i <= 3; i++) {
					x = x * (i/3);
					molesInHoles[i+5].setSpawn(new SpawnPoint(x, y));
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
		abstract boolean endGame();
}
