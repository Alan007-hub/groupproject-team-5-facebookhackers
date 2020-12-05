package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class DifficultyPane extends GraphicsPane {
	private MainApplication program;
	private GImage img;
	private GImage easy;
	private GImage medium;
	private GImage hard;
	private GImage impossible;
	
	private Difficulty currentDifficulty;

	Color darkGreen = new Color (32, 40, 2);

	public DifficultyPane(MainApplication app) {
		this.program = app;
		img = new GImage("Difficulty.jpg");

		//Easy button 
		easy = new GImage("Easy.png", 320, 105);

		//Medium button
		medium = new GImage("Medium.png", 288, 224);

		//Hard button
		hard = new GImage("Hard.png", 320, 340);

		//Impossible button
		impossible = new GImage("Impossible.png", 268, 472);
	}

	@Override
	public void showContents() {
		program.add(img);
		program.add(easy);
		program.add(medium);
		program.add(hard);
		program.add(impossible);
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(easy);
		program.remove(medium);
		program.remove(hard);
		program.remove(impossible);
	}
	
	public Difficulty getCurrentD() {
		return currentDifficulty;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == easy) {
			program.switchToMode();
			currentDifficulty = new Difficulty(0);
		}else if (obj == medium) {
			program.switchToMode();
			currentDifficulty = new Difficulty(1);
		}else if (obj == hard) {
			program.switchToMode();
			currentDifficulty = new Difficulty(2);
		}else if (obj == impossible) {
			program.switchToMode();
			currentDifficulty = new Difficulty(3);
		}
	}
}
