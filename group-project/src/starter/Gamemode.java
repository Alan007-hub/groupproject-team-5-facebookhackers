package starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Gamemode extends GraphicsProgram{//made it so that we can add mouselisteners and listen to events
	private Difficulty currentDLevel;
	private Mole molesInHoles[];//This is the number of moles to appear on screen? A)yes
	private boolean gameOver;
	private int score;
	
	public void run() {
		addMouseListeners();
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
					molesInHoles = new Mole[8];
					break;
			}
			for(Mole moleTemp: molesInHoles) {
				moleTemp = new Mole();
			}
		}
	
		public void mousePressed(MouseEvent e) {
			
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
	
		//this method will create the appropriate spawns points for each mole
		public void setupHoles() {
			//will do later need an idea of the window size first
			//We could try to make it dynamic with a variables that represents the width and height
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
