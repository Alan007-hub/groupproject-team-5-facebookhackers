package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MolePane extends GraphicsPane{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private MainApplication program;
	private GImage img;
	private Gamemode cGame;

	public MolePane(MainApplication app, Gamemode cGame) {
		this.program = app;
		img = new GImage("LevelBG.jpg");
		this.cGame = cGame;
	}
	
	//Setup the the game
	public void setup() {
		cGame.setupMoles(cGame.getDifficulty().getDifficultyLevel());
		cGame.setupHoles(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	@Override
	public void showContents() {
		program.add(img);
		
	}

	@Override
	public void hideContents() {
		program.remove(img);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
}
