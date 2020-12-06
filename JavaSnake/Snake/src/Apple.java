import java.util.Random;

public class Apple {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int SCORE_HEIGHT = 100;
	static final int UNIT_SIZE = 25;

	private int appleX;
	private int appleY;
	private Random generator;
	private static Apple instance = new Apple();

	public void setSeed(int seed) {
		generator.setSeed(seed);
	}

	public int getNextX() {
		return generator.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
	}

	public int getNextY() {
		return SCORE_HEIGHT + (generator.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
	}

	private Apple() {
		generator = new Random();
	}

	public static Apple getInstance() {
		return instance;
	}

	public void resetApple(){
		appleX = getNextX();
		appleY = getNextY();
	}

	public int getAppleX(){
		return this.appleX;
	}

	public int getAppleY(){
		return this.appleY;
	}
}
