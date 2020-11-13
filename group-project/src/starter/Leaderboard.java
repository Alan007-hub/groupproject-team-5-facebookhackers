package starter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Leaderboard {
	
	private static Leaderboard board;
	private String filePath;
	private String highScores;
	private ArrayList<Integer> topScores;
	
	//constructor 
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
				saveScores();
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
	
	public void saveScores() {
		FileWriter output = null;
		
		try {
			File file = new File(filePath, highScores);
			output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			
			writer.write(topScores.get(0) + "." + topScores.get(1) + "." + topScores.get(2) + "." + topScores.get(3) + "." + topScores.get(4) + ".");
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createSaveData() {
		FileWriter output = null;
		
		try {
			File file = new File(filePath, highScores);
			output = new FileWriter(file);
			BufferedWriter writer = new  BufferedWriter(output);
			
			writer.write("0 - 0 - 0 - 0 -0");
			writer.newLine();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getHighScore() {
		return topScores.get(0);
	}
	
	
	public ArrayList<Integer> getTopScores(){
		return topScores;
	}

}

