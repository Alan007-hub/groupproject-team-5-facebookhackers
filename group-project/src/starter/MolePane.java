package starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import javax.swing.Timer;


public  class MolePane extends GraphicsPane implements ActionListener{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private MainApplication program;
	private GImage imgBG;
	private Gamemode cGame;
	
	private int score = 0; //= cGame.getScore();
	private int timeLeft = 5; //= cGame.getDifficulty().getTimer();
	private Timer gameTimer = new Timer(50, this);
	private int timerAdd = 0;	
	private GLabel scoreLabel; 
	private GLabel timerLabel; 
	
	public MolePane(MainApplication app, Gamemode cGame) {
		this.program = app;
		imgBG = new GImage("LevelBG.jpg");
		this.cGame = cGame;
		scoreLabel= new GLabel("Score: " + score, 50, 50);
		timerLabel= new GLabel("Time Remaining: " + cGame.getDifficulty().getTimer(), 550, 50);
		timeLeft=cGame.getDifficulty().getTimer();
		scoreLabel.setFont(MainApplication.menuFont);
		timerLabel.setFont(MainApplication.menuFont);
		gameTimer.start();
	}

	//Setup the the game
	public void setup() {
		cGame.setupMoles(cGame.getDifficulty().getDifficultyLevel());
		cGame.setupHoles(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	@Override
	public void showContents() {
		program.add(imgBG);
		program.add(scoreLabel);
		program.add(timerLabel);
		
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
		program.remove(scoreLabel);
		program.remove(timerLabel);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		cGame.mousePressed(e, program.getElementAt(e.getX(), e.getY()));
		score = cGame.getScore();
	}
	
	public boolean everyXSeconds(double x) {
		return (timerAdd % (20 * x) == 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		timerAdd++;
		gameOver();
		cGame.calculateScore();
		scoreLabel.setLabel("Score: " + score);
		timerLabel.setLabel("Time Remaining: " + timeLeft);
		if(everyXSeconds(1))
			timeLeft--;	
		
	}
	
	public void gameOver() {
		if(timeLeft < 0) {
			program.switchToMenu();	
		}
	}
	
}
