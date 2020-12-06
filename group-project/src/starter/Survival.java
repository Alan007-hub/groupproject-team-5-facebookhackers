package starter;

import java.lang.*;

public class Survival extends Gamemode {
	private int score;
	private int numMiss;

	Survival() {
		currentDLevel = new Difficulty();
		gameOver = false;
		numMiss = 0;
		score = 0;
		moleWasHit = false;
	}

	Survival(Difficulty d) {
		currentDLevel = d;
		gameOver = false;
		numMiss = 0;
		score = 0;
		moleWasHit = false;
	}

	boolean endGame() {

		missDetection();
		if (numMiss == 3) {
			setStatus(true);
		}

		return getStatus();
	}

	public void missDetection() {
		for (int i = 0; i < molesInHoles.length; i++) {
			if (molesInHoles[i].getMiss() == true) {
				numMiss++;
			}

		}

	}

	@Override
	void calculateScore() {
		// TODO Auto-generated method stub
		score += 100;
	}

}
