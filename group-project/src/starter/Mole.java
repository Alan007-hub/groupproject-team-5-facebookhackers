package starter;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import acm.graphics.GImage;

public class Mole extends GraphicsPane implements ActionListener{
		public static final int MAX_COUNT = 20;
		private SpawnPoint spawn;
		private GImage mole;
		private MainApplication program;
		private GImage background = new GImage("LevelBG.jpg");
		private Timer movementTimer;
		private int count;

		
		public Mole(MainApplication app) {
			this.program = app;
		}
		
		@Override
		public void showContents() {
			program.add(background);
			
		}

		@Override
		public void hideContents() {
			program.remove(background);
		}
	
		public void actionPerformed(ActionEvent e){
			if(count < MAX_COUNT) {
				mole.setLocation(mole.getX(), mole.getY() + 1);
				count++;
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
