package starter;


//Intended to work with the graphicsDiffcultySelect.java. When the user selects a difficulty it will create an instance of this class
public class Difficulty {
	private int difficultyLevel;
	private String nameOfDiffculty[];
	
	Difficulty(){
		difficultyLevel = 0;
		nameOfDiffculty = new String[4];
		nameOfDiffculty[0] = "Easy";
		nameOfDiffculty[1] = "Medium";
		nameOfDiffculty[2] = "Hard";
		nameOfDiffculty[3] = "Impossible";
	}
	Difficulty(int value){
		difficultyLevel = value;
		nameOfDiffculty = new String[4];
		nameOfDiffculty[0] = "Easy";
		nameOfDiffculty[1] = "Medium";
		nameOfDiffculty[2] = "Hard";
		nameOfDiffculty[3] = "Impossible";
	}
	
	public void setDiffcultyLevel(int value) {
		difficultyLevel = value;
	}
	public int getDiffcultyLevel() {
		return difficultyLevel;
	}
	public String getNameOfDiffculty() {
		return nameOfDiffculty[difficultyLevel];
	}
}
