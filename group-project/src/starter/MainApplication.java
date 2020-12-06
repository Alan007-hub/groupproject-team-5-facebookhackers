package starter;

public class MainApplication extends GraphicsApplication  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GamemodePane gamemodePane;
	private MenuPane menu;
	private AudioPlayer menuSong;
	private DifficultyPane difficulty;
	private MolePane molePane; 
	private Difficulty cDifficulty;
	private LeaderboardPane leaderboard;
	private Gamemode cGamemode;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	public void setDifficulty(Difficulty diff) {
		cDifficulty = diff;
	}

	public void run() {		

		//Plays the title theme music
		menuSong = AudioPlayer.getInstance();
		menuSong.playSound(MUSIC_FOLDER, "menuLeaderBoard.mp3", true);		

		//Load the pages 
		menu = new MenuPane(this);
		leaderboard = new LeaderboardPane(this);
		difficulty = new DifficultyPane(this);
		
		switchToMenu();	
			
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}

	public void switchToDifficulty() {
		switchToScreen(difficulty);
	}

	public void switchToMode() {
		gamemodePane = new GamemodePane(this, cDifficulty);
		switchToScreen(gamemodePane);
	}
	
	public void switchToMole() {
		cGamemode = gamemodePane.getGamemode();
		molePane = new MolePane(this, cGamemode);
		switchToScreen(molePane);
	}
	
	public void switchToLeaderboard() {
		switchToScreen(leaderboard);
	}
}
