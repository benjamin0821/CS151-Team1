public class Board {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int SCORE_HEIGHT = 100;
    static final int TOTAL_HEIGHT = SCREEN_HEIGHT + SCORE_HEIGHT;
    static final int UNIT_SIZE = 25;

    Apple apple;
    Snake snake;
    int[] snakeX;
    int[] snakeY;
    Direction snakeDirection;

    public Board() {
        super();
        snakeDirection = Direction.RIGHT;
        apple = Apple.getInstance();
        apple.resetApple();
        snake = new BabySnake();
        snakeX = snake.getX();
        snakeY = snake.getY();
    }

    public int[] getSnakeX() {
        return snake.getX();
    }

    public int[] getSnakeY() {
        return snake.getY();
    }

    public int getAppleX() {
        return apple.getAppleX();
    }

    public int getAppleY() {
        return apple.getAppleY();
    }

    public void resetApple() {
        apple.resetApple();
    }

    public Direction getSnakeDirection() {
        return snakeDirection;
    }

    public void setSnakeDirection(Direction direction) {
        snakeDirection = direction;
    }

    public int getSnakeBodyParts() {
        return snake.getBodyParts();
    }

    public int getScore() {
        return snake.getApplesEaten();
    }

    public void growSnake() {
        snake = new GrowSnake(snake);
    }

    public void checkApple() {
        if((snakeX[0] == getAppleX() && snakeY[0] == getAppleY())){
            growSnake();
            resetApple();
        }
    }

    public void moveSnake(){
        for(int i = getSnakeBodyParts(); i > 0; i--){
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }

        switch(snakeDirection){
            case UP:
                snakeY[0] = snakeY[0] - UNIT_SIZE;
                break;
            case DOWN:
                snakeY[0] = snakeY[0] + UNIT_SIZE;
                break;
            case LEFT:
                snakeX[0] = snakeX[0] - UNIT_SIZE;
                break;
            case RIGHT:
                snakeX[0] = snakeX[0] + UNIT_SIZE;
                break;
        }
    }

    public boolean didSnakeCollide(){
        // checks if head collides with body
        for(int i = getSnakeBodyParts(); i > 0; i--){
            if((snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])){
                return true;
            }
        }
        // checks if head touches left border
        if(snakeX[0] < 0){
            return true;
        }

        // checks if head touches right border
        if(snakeX[0] > SCREEN_WIDTH){
            return true;
        }
        // checks if head touches top border
        if(snakeY[0] < SCORE_HEIGHT){
            return true;
        }
        // checks if head touches bottom border
        if(snakeY[0] > TOTAL_HEIGHT){
            return true;
        }

        return false;
    }
}
