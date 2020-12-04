package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class GamemodePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GImage img;
	private GImage standard;
	private GImage survival;
	private Difficulty cDiff;
	private Gamemode cGamemode;
	
	Color daarkGreen = new Color (32, 40, 2);
	
	public Gamemode getGamemode() {
		return cGamemode;
	}

	public GamemodePane(MainApplication app, Difficulty cDiff) {
		this.program = app;
		this.cDiff = cDiff;
		img = new GImage("Gamemode.jpg");

		//Standard button
		standard = new GImage("Standard.png", 250, 300);

		//Survival button
		survival = new GImage("Survival.png", 250, 455);
	}

	@Override
	public void showContents() {
		program.add(img);
		program.add(standard);
		program.add(survival);
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(standard);
		program.remove(survival);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == standard) {
			program.switchToDifficulty();
			cGamemode = new Standard(cDiff);
		}else if (obj == survival) {
			program.switchToDifficulty();
		}
	}
}