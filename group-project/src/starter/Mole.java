package starter;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import acm.graphics.GImage;

public class Mole implements ActionListener{
		public static final int MAX_COUNT = 20;
		private SpawnPoint spawn;
		private GImage mole;
		private Timer movementTimer;
		private int count;
		Random randInt;
		
		public void actionPerformed(ActionEvent e){
			if(count < MAX_COUNT) {
				mole.setLocation(mole.getX(), mole.getY() - 5);
				count++;
			}
		}
		
		public void moveMoleDown() {
			movementTimer.stop();
			count = 0;
			while(mole.getY() != spawn.getY()) {
				mole.setLocation(mole.getX(), mole.getY() + 5);
			}
			movementTimer.start();
		}
		
		public void startGame(){
			movementTimer = new Timer(500, this);
			movementTimer.setInitialDelay(randInt.nextInt(5)*1000);
			movementTimer.start();
		}
		Mole(){
			spawn = new SpawnPoint();
			mole = new GImage("mole.png",spawn.getX(),spawn.getY());
			mole.setSize(spawn.getWidth(), spawn.getHeight());
			randInt = new Random();
		}
		
		Mole(SpawnPoint spawn){
			this.spawn = spawn;
			mole = new GImage("mole.png",this.spawn.getX(),this.spawn.getY());
			mole.setSize(spawn.getWidth(), spawn.getHeight());
			randInt = new Random();
		}
		
		Mole(int x, int y){
			spawn = new SpawnPoint(x,y);
			mole = new GImage("mole.png",spawn.getX(),spawn.getY());
			mole.setSize(spawn.getWidth(), spawn.getHeight());
			randInt = new Random();
		}
		
		//Getters and Setters
		public SpawnPoint getSpawn() {
			return spawn;
		}
		
		public GImage getMoleImage() {
			return mole;
		}
		
		public void setSpawn(SpawnPoint spawn) {
			this.spawn = spawn;
		}		

}
