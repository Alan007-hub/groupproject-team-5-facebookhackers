package starter;
import java.io.File;
import java.util.ArrayList;



public class Leaderboard {
	
	private static Leaderboard board;
	private String filePath;
	private String highScores;
	
	private ArrayList<Integer> topScores;
	
	private Leaderboard() {
		filePath = new File("").getAbsolutePath();
		highScores = "Scores";
		topScores = new ArrayList<Integer>();
	}
	
	public static Leaderboard newInstance() {
		if (board == null) {
			board = new Leaderboard();
		}
		return board; 
	}
	
	public void addScore(int score) {
		for(int i = 0; i < topScores.size(); i++) {
			if(score >= topScores.get(i)) {
				topScores.add(i, score);
				topScores.removve(topScores.size()-1);
			}
		}
	}
	
	
	
	
	
	
	
}

