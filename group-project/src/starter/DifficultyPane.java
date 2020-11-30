package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class DifficultyPane extends GraphicsPane {
	private MainApplication program;
	private GImage img;
	private GParagraph easy;
	private GParagraph medium;
	private GParagraph hard;
	private GParagraph impossible;
	
	private Difficulty currentDifficulty;

	Color darkGreen = new Color (32, 40, 2);

	public DifficultyPane(MainApplication app) {
		this.program = app;
		img = new GImage("Difficulty.jpg");

		//Easy button 
		easy = new GParagraph("Easy", 320, 150);
		easy.setColor(darkGreen);
		easy.setFont("ArcadeClassic-70");

		//Medium button
		medium = new GParagraph("Medium", 275, 260);
		medium.setColor(darkGreen);
		medium.setFont("ArcadeClassic-70");

		//Hard button
		hard = new GParagraph("Hard", 320, 380);
		hard.setColor(darkGreen);
		hard.setFont("ArcadeClassic-70");

		//Impossible button
		impossible = new GParagraph("Impossible", 270, 495);
		impossible.setColor(darkGreen);
		impossible.setFont("ArcadeClassic-44");
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

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == easy) {
			program.switchToSome();
			currentDifficulty = new Difficulty(0);
		}else if (obj == medium) {
			program.switchToSome();
			currentDifficulty = new Difficulty(1);
		}else if (obj == hard) {
			program.switchToSome();
			currentDifficulty = new Difficulty(2);
		}else if (obj == impossible) {
			program.switchToSome();
			currentDifficulty = new Difficulty(3);
		}
	}
}
