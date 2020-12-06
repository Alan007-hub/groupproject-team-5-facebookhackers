package starter;


//Intended to work with the graphicsDiffcultySelect.java. When the user selects a difficulty it will create an instance of this class
public class Difficulty {
	private int difficultyLevel;
	private String nameOfDiffculty[];
	private int time;
	
	Difficulty(){
		difficultyLevel = 0;
		nameOfDiffculty = new String[4];
		nameOfDiffculty[0] = "Easy";
		nameOfDiffculty[1] = "Medium";
		nameOfDiffculty[2] = "Hard";
		nameOfDiffculty[3] = "Impossible";
		time = 90;
	}
	Difficulty(int value){
		difficultyLevel = value;
		nameOfDiffculty = new String[4];
		nameOfDiffculty[0] = "Easy";
		nameOfDiffculty[1] = "Medium";
		nameOfDiffculty[2] = "Hard";
		nameOfDiffculty[3] = "Impossible";
		
		switch(value) {
		//Isn't this suppose to be related to the name of the Difficulty array?
		//If so, we need to add two more ?
		case 0:
			time = 90;
			break;
		case 1:
			time = 75;
			break;
		case 2:
			time = 60;
			break;
		case 3:
			time = 45;
			break;	
		}		
	}
	
	//Created the getTimer() in order to get the timer value so we can check if we can end the game
	public int getTimer() {
		return time;
	}
	
	
	public void setDifficultyLevel(int value) {
		difficultyLevel = value;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public String getNameOfDifficulty() {
		return nameOfDiffculty[difficultyLevel];
	}
}
