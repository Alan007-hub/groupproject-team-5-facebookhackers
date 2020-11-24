package starter;

import acm.graphics.GImage;

public class Mole extends GraphicsPane{
		private SpawnPoint spawn;
		private GImage mole;
		private MainApplication program;
		private GImage background = new GImage("LevelBG.jpg");

		
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
