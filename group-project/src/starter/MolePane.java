package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MolePane extends GraphicsPane{

	private MainApplication program;
	private GImage img;

	public MolePane(MainApplication app) {
		this.program = app;
		img = new GImage("LevelBG.jpg");

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
