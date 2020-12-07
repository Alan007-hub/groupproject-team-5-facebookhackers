package starter;
import java.lang.*;

public class Standard extends Gamemode {
	//private int score;
	
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
		/**In standard, game should end when the timer reaches zero,
		 and there should be a setStatus()? so that we could set the gameover to true*/
		if (currentDLevel.getTimer()==0) {
			//This will set the gameOver to true
			setStatus(true);
		}

		
		
		return getStatus();
	}

	@Override
	void calculateScore() {
		// TODO Auto-generated method stub
		score += 100;
	}

}
