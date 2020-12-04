package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GImage background;
	private GImage play;
	private GImage playButton;
	private GButton circle;
	private GImage leaderboard;

	Color brown = new Color (96, 40, 10);
	Color lightBrown = new Color (235, 174, 83);

	public MenuPane(MainApplication app) {
		super();
		program = app;

		//Background
		background = new GImage("Background.jpg");

		//Hit play button
		play = new GImage ("Play.png",309, 419);
		playButton = new GImage ("PlayButton.png",235, 372);

		//Hit leaderBoard button
		circle = new GButton("", 17, 10, 90,90);
		circle.setColor(brown);
		circle.setFillColor(lightBrown);
		leaderboard = new GImage("leaderboard.png", 30, 28);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(playButton);
		program.add(play);
		program.add(circle);
		program.add(leaderboard);
	}

	@Override
	public void hideContents() {
		program.remove(background);	
		program.remove(play);
		program.remove(playButton);
		program.remove(circle);
		program.remove(leaderboard);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play || obj == playButton) {
			program.switchToSome();
		}else if(obj == circle || obj == leaderboard){
			program.switchToLeaderboard();
		}
	}
}
