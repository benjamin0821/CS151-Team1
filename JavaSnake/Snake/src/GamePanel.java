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
	Board board;
	boolean running = false;
	boolean gameOver = true;
	Timer timer;
	int highScore = 0;
	int currentScore = 0;

	GamePanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,TOTAL_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		startGame();
	}

	public void startGame(){
		gameOver = false;
		board = new Board();
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
			g.fillOval(board.getAppleX(), board.getAppleY(), UNIT_SIZE, UNIT_SIZE);

			// draw snake
			for(int i = 0; i < board.getSnakeBodyParts(); i++){
				// snake head
				if(i == 0){
					g.setColor(Color.green);
					g.fillRect(board.getSnakeX()[i], board.getSnakeY()[i], UNIT_SIZE, UNIT_SIZE);
				}
				// snake body
				else{
					g.setColor(new Color(45, 180, 0));
					g.fillRect(board.getSnakeX()[i], board.getSnakeY()[i], UNIT_SIZE, UNIT_SIZE);
				}
			}

			g.setColor(Color.white);
			g.setFont(new Font("Courier",Font.PLAIN, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+board.getScore(), (SCREEN_WIDTH - metrics.stringWidth("Score: "+board.getScore()))/2, g.getFont().getSize()+20);
		}
		else {
			gameOver(g);
		}
	}

	public void checkCollisions(){
		if (board.didSnakeCollide()) {
			running = false;
			gameOver = true;
			timer.stop();
		}
	}

	public void gameOver(Graphics g){
		gameOver = true;

		int currentScore = board.getScore();

		if (currentScore > highScore) {
			highScore = currentScore;
		}

		// High Score text
		g.setColor(Color.white);
		g.setFont(new Font("Courier",Font.PLAIN, 25));
		FontMetrics metrics0 = getFontMetrics(g.getFont());
		g.drawString("High Score: " + highScore, (SCREEN_WIDTH - metrics0.stringWidth("High Score: " + highScore))/2, g.getFont().getSize()+TOTAL_HEIGHT/4);

		// Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Impact",Font.PLAIN, 75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("GAME OVER", (SCREEN_WIDTH - metrics1.stringWidth("GAME OVER"))/2, TOTAL_HEIGHT/2);

		// Score text
		g.setColor(Color.white);
		g.setFont(new Font("Courier",Font.PLAIN, 40));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: " + currentScore, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + currentScore))/2, g.getFont().getSize()+TOTAL_HEIGHT/2);

		g.setColor(Color.white);
		g.setFont(new Font("Courier",Font.PLAIN, 25));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString("Press the 'R' key to play again", (SCREEN_WIDTH - metrics3.stringWidth("Press the 'R' key to play again"))/2, (TOTAL_HEIGHT * 3)/4 );

	}

	@Override
	public void actionPerformed(ActionEvent e){

		if(running && !gameOver){
			board.moveSnake();
			board.checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				if(board.getSnakeDirection() != Direction.RIGHT){
					board.setSnakeDirection(Direction.LEFT);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(board.getSnakeDirection()  != Direction.LEFT){
					board.setSnakeDirection(Direction.RIGHT);
				}
				break;
			case KeyEvent.VK_UP:
				if(board.getSnakeDirection()  != Direction.DOWN){
					board.setSnakeDirection(Direction.UP);
				}
				break;
			case KeyEvent.VK_DOWN:
				if(board.getSnakeDirection()  != Direction.UP){
					board.setSnakeDirection(Direction.DOWN);
				}
				break;
			case KeyEvent.VK_R:
				if(gameOver){
					startGame();
				}
			}
		}
	}

}
