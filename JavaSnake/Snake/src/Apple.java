import java.util.Random;

public class Apple {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int SCORE_HEIGHT = 100;
	static final int UNIT_SIZE = 25;
	
	int appleX;
	int appleY;
	Random random;
	
	public void resetApple(){
		random = new Random();
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = SCORE_HEIGHT + (random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
	}
	
	public int getAppleX(){
		return this.appleX;
	}
	
	public int getAppleY(){
		return this.appleY;
	}
}
