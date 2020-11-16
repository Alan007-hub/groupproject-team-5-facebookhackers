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
	private int numberOfMoles; //This isn't necessary because the length of molesInHoles is the numberOfMoles
	private boolean moleWasHit=false;
	
	public void run() {
		addMouseListeners();
		
	}
	
	//Constructors for Game mode
	Gamemode(){
		currentDLevel = new Difficulty();
		gameOver = false;
		score = 0;
	}
	Gamemode(Difficulty d){
		currentDLevel = d;
		gameOver = false;
		score = 0;
	}
	
	public Difficulty getDiffculty() {
		return currentDLevel;
	}
	public int getNumMoles() {
		return numberOfMoles;
	}
	
	public void setStatus(boolean value) {//added getters and setters for the gameover so that later
		//it can be called by the abstract endGame method
		gameOver=value;
	}
	
	public boolean getStatus() {
		return gameOver;
	}
	
	//This method will create an array of the appropriate size for the current game
		public void setupMoles(int value) {
			switch(value) {
				case 0:
					molesInHoles = new Mole[3];
					numberOfMoles=3;
					break;
				case 1:
					molesInHoles = new Mole[4];
					numberOfMoles=4;
					break;
				case 2:
					molesInHoles = new Mole[6];
					numberOfMoles=6;
					break;
				case 3:
					molesInHoles = new Mole[8];
					numberOfMoles=8;
					break;
			}
			for(Mole moleTemp: molesInHoles) {
				moleTemp = new Mole();
			}
		}
	
		public void mousePressed(MouseEvent e) {
			
		}

	
		//this method will create the appropriate spawns points for each mole
		public void setupHoles(int windowWidth, int windowHeight) {
			
		}
		
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
				animateMole(molesInHoles[index.nextInt(molesInHoles.length)]);
			}
		}
		//I'm not sure if the animations should be here lets discuss this on Monday
		public void animateMole(Mole cMole) {
			
		}
		//The following methods are abstract because each mode will implement them slightly differently
		abstract void calculateScore();
		abstract boolean endGame();
}
