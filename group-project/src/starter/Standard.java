package starter;
import java.lang.*;

public class Standard extends Gamemode {
	private int score;
	
	//constructor
	Standard(){
		currentDLevel = new Difficulty();
		gameOver = false;
		score = 0;
		moleWasHit = false;
	}
	
	Standard(Difficulty d){
		currentDLevel = d;
		gameOver = false;
		score = 0;
		moleWasHit = false;
	}
	
	
	boolean endGame() {

		return getStatus();
	}

	@Override
	void calculateScore() {
		// TODO Auto-generated method stub
		score += 100;
	}

}
