package starter;

public class SpawnPoint {
	private int yPosition;
	private int xPosition;
	private static final int HOLE_HEIGHT = 100;
	private static final int HOLE_WIDTH = 100;
	
//Default Constructor
	SpawnPoint(){
		yPosition = 0;
		xPosition = 0;
	}
	
//Constructor for passing two arguments
	SpawnPoint(int x, int y){
		xPosition = x;
		yPosition = y;
	}
	
//Setters and getters
	public void setX(int x) {
		xPosition = x;
	}
	public void setY(int y) {
		yPosition = y;
	}
	public int getX() {
		return xPosition;
	}
	public int getY() {
		return yPosition;
	}
	public int getHeight() {
		return HOLE_HEIGHT;
	}
	public int getWidth() {
		return HOLE_WIDTH;
	}
}
