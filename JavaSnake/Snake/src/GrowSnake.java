
public class GrowSnake implements Snake {
	Snake snake;

	GrowSnake(Snake snake){
		this.snake = snake;
	}
	
	@Override
	public int getBodyParts() {
		return snake.getBodyParts()+1;
	}

	@Override
	public int getApplesEaten() {
		return snake.getApplesEaten()+1;
	}

	@Override
	public int[] getX() {
		return snake.getX();
	}

	@Override
	public int[] getY() {
		return snake.getY();	}
}
