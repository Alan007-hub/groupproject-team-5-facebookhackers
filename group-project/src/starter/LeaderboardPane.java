package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LeaderboardPane extends GraphicsPane{
	private MainApplication program;
	private GImage img;
	private GImage xButton;

	public LeaderboardPane(MainApplication app) {
		this.program = app;
		img = new GImage("Leaderboard.jpg");
		xButton = new GImage("xButton.png", 542, 72);
	}

	@Override
	public void showContents() {
		program.add(img);
		program.add(xButton);
		
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(xButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == xButton) {
			program.switchToMenu();
		}
	}
}