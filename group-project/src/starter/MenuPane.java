package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton oval;
	Color green = new Color (22, 106, 11);

	public MenuPane(MainApplication app) {
		super();
		program = app;
		oval = new GButton("Play", 250, 375, 300, 200);
		oval.setFillColor(green);
	}

	@Override
	public void showContents() {
		program.add(oval);
	}

	@Override
	public void hideContents() {
		program.remove(oval);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == oval) {
			program.switchToSome();
		}
	}
}
