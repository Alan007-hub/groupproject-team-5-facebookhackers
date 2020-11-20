package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class GamemodePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph standard;
	private GParagraph survival;

	Color daarkGreen = new Color (32, 40, 2);

	public GamemodePane(MainApplication app) {
		this.program = app;
		img = new GImage("Gamemode.jpg");

		//Standard button 
		standard = new GParagraph("Standard", 245, 345);
		standard.setColor(daarkGreen);
		standard.setFont("ArcadeClassic-70");

		//Survival button
		survival = new GParagraph("Survival", 245, 500);
		survival.setColor(daarkGreen);
		survival.setFont("ArcadeClassic-70");
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
			program.switchToMenu();
		}else if (obj == survival) {
			program.switchToMenu();
		}
	}
}