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

	Color brown = new Color (96, 40, 10);
	Color lightBrown = new Color (235, 174, 83);

	private GImage title;
	Color green = new Color (22, 106, 11);

	public MenuPane(MainApplication app) {
		super();
		program = app;
		
		//Hit play button
		oval = new GButton("Play", 250, 375, 300, 200);
		oval.setColor(brown);
		oval.setFillColor(lightBrown);
		oval.setFillColor(green);

		
		
		//Title card 
		//title = new GImage("WhackAmole.png", 60, 110);
		
		background = new GImage("Background.jpg");
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(oval);
		//program.add(title);
		
		
	}

	@Override
	public void hideContents() {
		program.remove(oval);
		program.removeAll();
		program.remove(background);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == oval) {
			program.switchToSome();
		}
	}
}
