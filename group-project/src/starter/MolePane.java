package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class MolePane extends GraphicsPane{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private MainApplication program;
	private GImage imgBG;
	private Gamemode cGame;

	public MolePane(MainApplication app, Gamemode cGame) {
		this.program = app;
		imgBG = new GImage("LevelBG.jpg");
		this.cGame = cGame;
	}
	
	//Setup the the game
	public void setup() {
		cGame.setupMoles(cGame.getDifficulty().getDifficultyLevel());
		cGame.setupHoles(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	@Override
	public void showContents() {
		program.add(imgBG);
		this.setup();
		 
		for(Mole tempMole:cGame.getMoleArray()) {
			GOval hole = new GOval(tempMole.getSpawn().getX(), tempMole.getSpawn().getY(), tempMole.getSpawn().getWidth(), tempMole.getSpawn().getHeight());
			hole.setFilled(true);
			hole.setColor(Color.BLACK);
			program.add(hole);
			program.add(tempMole.getMoleImage());
			tempMole.startGame();
		}	
	}
	

	@Override
	public void hideContents() {
		program.remove(imgBG);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		cGame.mousePressed(e, program.getElementAt(e.getX(), e.getY()));
	}
}
