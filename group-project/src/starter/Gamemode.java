package starter;

abstract class Gamemode{
	private Difficulty currentDLevel;
	private Mole molesInHoles[];
	private boolean gameOver;
	private int score;
	
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
	
	//This method will create an array of the appropriate size for the current game
	void setupMoles(int value) {
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
	
	//this method will create the appropriate spawns points for each mole
	void setupHoles() {
		//will do later need an idea of the window size first
	}
	
	//this method will call the functions for the game
	void playGame() {
		//The game will end when gameOver = true
		while(!gameOver) {
			animateMoles();
		}
	}
	
	//This method will determine which mole should be selected next
	void animateMoles() {
		
	}
	
	//The following methods are abstract because ecah mode will implment them slightly differently
	void calculate
}
