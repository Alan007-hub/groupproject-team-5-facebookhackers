package starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public abstract class Gamemode extends GraphicsProgram{//made it so that we can add mouselisteners and listen to events
	private Difficulty currentDLevel;
	private Mole molesInHoles[];//This is the number of moles to appear on screen?
	private boolean gameOver;
	private int score;
	private int numberOfMoles;
	private boolean moleWasHit;
	
	public void run() {
		addMouseListeners();
		
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
			if getElementAt(e.getX(),e.getY() != null) {
				moleWasHit==true;
			}
		}

		//Constructors for Gamemode
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
	
		//this method will create the appropriate spawns points for each mole
		public void setupHoles() {
			//will do later need an idea of the window size first
		}
		
		//this method will call the functions for the game
		public void playGame() {
			//The game will end when gameOver = true
			while(!gameOver) {
				animateMoles();
			}
		}
		
		//This method will determine which mole should be selected next
		public void animateMoles() {
			
		}
		
		//The following methods are abstract because each mode will implement them slightly differently
		abstract void calculateScore();
		abstract boolean endGame();
}
