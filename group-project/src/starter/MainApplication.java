package starter;

public class MainApplication extends GraphicsApplication  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GamemodePane gamemode;
	private MenuPane menu;
	private AudioPlayer menuSong;
	private DifficultyPane difficulty;
	private Mole molePane; 
	private MolePane mole;
	private Difficulty cDifficulty;
	private LeaderboardPane leaderboard;
	private Gamemode cGamemode;
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {		

		//Plays the title theme music
		menuSong = AudioPlayer.getInstance();
		menuSong.playSound(MUSIC_FOLDER, "menuLeaderBoard.mp3", true);		

		//Load the pages 
		menu = new MenuPane(this);
		leaderboard = new LeaderboardPane(this);
		difficulty = new DifficultyPane(this);
		mole = new MolePane(this);
		
		//I, Michael, Placed this here because it made sense to place it before gamemodePane
		cDifficulty = difficulty.getCurrentD();
		
		gamemode = new GamemodePane(this, cDifficulty);
		
		cGamemode = gamemode.getGamemode();
		
		molePane = new Mole(this);	
		
		switchToMenu();		
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}

	public void switchToDifficulty() {
		switchToScreen(difficulty);
	}

	public void switchToSome() {
		switchToScreen(gamemode);
	}
	
	public void switchToMole() {
		switchToScreen(molePane);
	}
	
	public void switchToLeaderboard() {
		switchToScreen(leaderboard);
	}
	
	public void switchToMolePane() {
		switchToScreen(mole);
	}
}
