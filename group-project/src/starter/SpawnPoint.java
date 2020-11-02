package starter;

public class SpawnPoint {
	private int yPosition;
	private int xPosition;
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
	void setX(int x) {
		xPosition = x;

	}
	void setY(int y) {
		yPosition = y;
	}
	int getX() {
		return xPosition;
	}
	int getY() {
		return yPosition;
	}
}
