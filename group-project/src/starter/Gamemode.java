package starter;

public class Gamemode{
	private Difficulty currentDLevel;
	private Mole molesInHoles[];
	
	//Constructors for Gamemode
	Gamemode(){
		currentDLevel = new Difficulty();
	}
	Gamemode(Difficulty d){
		currentDLevel = d;
	}
}
