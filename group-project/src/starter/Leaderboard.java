package starter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
				topScores.remove(topScores.size()-1);
			}
		}
	}
	
	public void loadScores() {
		try {
			File scoreFile = new File(filePath, highScores);
			if(!scoreFile.isFile()) {
				//Write a method to save the data
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scoreFile)));
			topScores.clear();
			
			String[] scores = reader.readLine().split(".");	
			
			for(int i = 0; i < scores.length; i++) {
				topScores.add(Integer.parseInt(scores[i]));
			}
			
			reader.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}

