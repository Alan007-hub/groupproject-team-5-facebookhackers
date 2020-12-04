package starter;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;

public class Mole implements ActionListener{
		public static final int MAX_COUNT = 20;
		private SpawnPoint spawn;
		private GImage mole;
		private Timer movementTimer;
		private int count;

		public void actionPerformed(ActionEvent e){
			if(count < MAX_COUNT) {
				mole.setLocation(mole.getX(), mole.getY() + 1);
				count++;
			}
		}
		
		public void mousePressed(MouseEvent e) {
			movementTimer.stop();
			count = 0;
			while(mole.getY() != spawn.getY()) {
				mole.setLocation(mole.getX(), mole.getY() - 2);
			}
		}
		Mole(){
			spawn = new SpawnPoint();
			mole = new GImage("mole.png",spawn.getX(),spawn.getY());
		}
		
		Mole(SpawnPoint spawn){
			this.spawn = spawn;
			mole = new GImage("mole.png",this.spawn.getX(),this.spawn.getY());
		}
		
		Mole(int x, int y){
			spawn = new SpawnPoint(x,y);
			mole = new GImage("mole.png",spawn.getX(),spawn.getY());
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
