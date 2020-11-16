package starter;

public class MainApplication extends GraphicsApplication  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private SomePane somePane;
	private MenuPane menu;
	private AudioPlayer menuSong;
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {		

		//Plays the title theme music
		menuSong = AudioPlayer.getInstance();
		menuSong.playSound(MUSIC_FOLDER, "menuLeaderBoard.mp3", true);		
		
		//Load the pages 
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		switchToMenu();
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}

	public void switchToSome() {
		menuSong.stopSound(MUSIC_FOLDER, "menuLeaderBoard.mp3");
		switchToScreen(somePane);
	}
}
