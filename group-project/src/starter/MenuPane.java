package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GImage background;
	private GButton oval;
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
		oval = new GButton("Play", 250, 375, 300, 200);
		oval.setColor(brown);
		oval.setFillColor(lightBrown);

		//Hit leaderBoard button
		circle = new GButton("", 17, 10, 90,90);
		circle.setColor(brown);
		circle.setFillColor(lightBrown);
		leaderboard = new GImage("leaderboard.png", 30, 28);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(oval);
		program.add(circle);
		program.add(leaderboard);
	}

	@Override
	public void hideContents() {
		program.remove(oval);
		program.removeAll();
		program.remove(background);	
		program.remove(oval);
		program.remove(circle);
		program.remove(leaderboard);
		program.removeAll();	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == oval) {
			program.switchToSome();
		}else if(obj == circle || obj == leaderboard){
			program.switchToLeaderboard();
		}
	}
}
