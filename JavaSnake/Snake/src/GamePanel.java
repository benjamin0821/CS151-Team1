import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int SCORE_HEIGHT = 100;
	static final int TOTAL_HEIGHT = SCREEN_HEIGHT + SCORE_HEIGHT;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	Snake snake;
	int[] snakeX;
	int[] snakeY;
	Apple apple;
	char direction = 'R';
	boolean running = false;
	Timer timer;

	GamePanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,TOTAL_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		snake = new BabySnake();
		snakeX = snake.getX();
		snakeY = snake.getY();
		startGame();
	}

	public void startGame(){
		apple = new Apple();
		apple.resetApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g){

		if(running){

			// top border line for the game
			g.drawLine(0, SCORE_HEIGHT, SCREEN_WIDTH, SCORE_HEIGHT);

			// unit grid lines for visualization
//			for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
//				g.drawLine(i*UNIT_SIZE, SCORE_HEIGHT, i*UNIT_SIZE, TOTAL_HEIGHT);
//				g.drawLine(0, SCORE_HEIGHT+(i*UNIT_SIZE), SCREEN_WIDTH, SCORE_HEIGHT+(i*UNIT_SIZE));
//			}

			// draws apple
			g.setColor(Color.red);
			g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

			// draw snake
			for(int i = 0; i < snake.getBodyParts(); i++){
				// snake head
				if(i == 0){
					g.setColor(Color.green);
					g.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
				}
				// snake body
				else{
					g.setColor(new Color(45, 180, 0));
					g.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
				}
			}

			g.setColor(Color.white);
			g.setFont(new Font("Courier",Font.PLAIN, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+snake.getApplesEaten(), (SCREEN_WIDTH - metrics.stringWidth("Score: "+snake.getApplesEaten()))/2, g.getFont().getSize()+20);
		}
		else {
			gameOver(g);
		}
	}

	public void move(){
		for(int i = snake.getBodyParts(); i > 0; i--){
			snakeX[i] = snakeX[i-1];
			snakeY[i] = snakeY[i-1];
		}

		switch(direction){
		case 'U':
			snakeY[0] = snakeY[0] - UNIT_SIZE;
			break;
		case 'D':
			snakeY[0] = snakeY[0] + UNIT_SIZE;
			break;
		case 'L':
			snakeX[0] = snakeX[0] - UNIT_SIZE;
			break;
		case 'R':
			snakeX[0] = snakeX[0] + UNIT_SIZE;
			break;
		}
	}

	public void checkApple(){
		if((snakeX[0] == apple.getAppleX() && snakeY[0] == apple.getAppleY())){
			snake = new GrowSnake(snake);
			apple.resetApple();
		}
	}

	public void checkCollisions(){
		// checks if head collides with body
		for(int i = snake.getBodyParts(); i > 0; i--){
			if((snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])){
				running = false;
			}
		}
		// checks if head touches left border
		if(snakeX[0] < 0){
			running = false;
		}
		// checks if head touches right border
		if(snakeX[0] > SCREEN_WIDTH){
			running = false;
		}
		// checks if head touches top border
		if(snakeY[0] < SCORE_HEIGHT){
			running = false;
		}
		// checks if head touches bottom border
		if(snakeY[0] > TOTAL_HEIGHT){
			running = false;
		}

		if(!running){
			timer.stop();
		}
	}

	public void gameOver(Graphics g){
		// Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Impact",Font.PLAIN, 75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("GAME OVER", (SCREEN_WIDTH - metrics1.stringWidth("GAME OVER"))/2, TOTAL_HEIGHT/2);

		// Score text
		g.setColor(Color.white);
		g.setFont(new Font("Courier",Font.PLAIN, 40));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: "+snake.getApplesEaten(), (SCREEN_WIDTH - metrics2.stringWidth("Score: "+snake.getApplesEaten()))/2, g.getFont().getSize()+TOTAL_HEIGHT/2);
	}

	@Override
	public void actionPerformed(ActionEvent e){

		if(running){
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				if(direction != 'R'){
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L'){
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D'){
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U'){
					direction = 'D';
				}
				break;
			}
		}
	}

}
