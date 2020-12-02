
public class BabySnake implements Snake {
	
	static final int GAME_UNITS = 14400;
	static final int SCORE_HEIGHT = 100;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	
	BabySnake(){
		for(int i = 0; i < y.length; i++){
			y[i] += SCORE_HEIGHT;
		}
	}
	
	public int[] getX(){
		return this.x;
	}
	
	public int[] getY(){
		return this.y;
	}
	
	@Override
	public int getBodyParts() {
		return this.bodyParts;
	}

	@Override
	public int getApplesEaten() {
		return this.applesEaten;
	}
}
