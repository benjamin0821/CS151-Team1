import java.util.HashSet;

public class BoardTester {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int SCORE_HEIGHT = 100;
    static final int TOTAL_HEIGHT = SCREEN_HEIGHT + SCORE_HEIGHT;
    static final int UNIT_SIZE = 25;

    public static boolean testMoveSnake() {
        Board b = new Board();

        // initial head position is (0, SCORE_HEIGHT)
        int initialX = 0;
        int initialY = SCORE_HEIGHT;

        b.moveSnake();

        // MOVE 1: head is one unit right
        if (b.getSnakeX()[0] != initialX + UNIT_SIZE || b.getSnakeY()[0] != initialY) {
            return false;
        }

        b.moveSnake();

        // MOVE 2: head is two units right
        if (b.getSnakeX()[0] != initialX + (UNIT_SIZE * 2) || b.getSnakeY()[0] != initialY) {
            return false;
        }

        b.setSnakeDirection(Direction.DOWN);

        b.moveSnake();

        // MOVE 3: head is two units right, one unit down
        if (b.getSnakeX()[0] != initialX + (UNIT_SIZE * 2) || b.getSnakeY()[0] != initialY + UNIT_SIZE) {
            return false;
        }

        b.setSnakeDirection(Direction.LEFT);

        b.moveSnake();

        // MOVE 4: head is one unit right, one unit down
        if (b.getSnakeX()[0] != initialX + UNIT_SIZE || b.getSnakeY()[0] != initialY + UNIT_SIZE) {
            return false;
        }

        // verify rest of body parts (should be MOVES 3, 2, 1...):
        if (b.getSnakeX()[1] != initialX + (UNIT_SIZE * 2) || b.getSnakeY()[1] != initialY + UNIT_SIZE) {
            return false;
        }

        if (b.getSnakeX()[2] != initialX + (UNIT_SIZE * 2) || b.getSnakeY()[2] != initialY) {
            return false;
        }

        if (b.getSnakeX()[3] != initialX + UNIT_SIZE || b.getSnakeY()[3] != initialY) {
            return false;
        }

        if (b.getSnakeX()[4] != initialX || b.getSnakeY()[4] != initialY) {
            return false;
        }

        return true;
    }

    public static boolean testDidSnakeCollide() {
        Board b = new Board();

        // SCENARIO 1: head is one unit right, no collision
        b.moveSnake();
        if (b.didSnakeCollide()) {
            return false;
        }

        // SCENARIO 2: head is one unit right, one unit up, top border collision
        b.setSnakeDirection(Direction.UP);
        b.moveSnake();
        if (!b.didSnakeCollide()) {
            return false;
        }

        // reset
        b = new Board();

        // SCENARIO 3: head is one unit left, left border collision
        b.setSnakeDirection(Direction.LEFT);
        b.moveSnake();
        if (!b.didSnakeCollide()) {
            return false;
        }

        // reset
        b = new Board();

        // SCENARIO 4: head is 25 units right, right border collision
        for (int i = 0; i < 25; i++) {
            b.moveSnake();
        }
        if (!b.didSnakeCollide()) {
            return false;
        }

        // reset
        b = new Board();

        // SCENARIO 5: head is 25 units down, bottom border collision
        b.setSnakeDirection(Direction.DOWN);
        for (int i = 0; i < 25; i++) {
            b.moveSnake();
        }
        if (!b.didSnakeCollide()) {
            return false;
        }

        // reset
        b = new Board();

        // SCENARIO 6: head hits body collision
        b.moveSnake(); // one unit right
        b.setSnakeDirection(Direction.DOWN);
        b.moveSnake(); // one unit right, one unit down
        b.setSnakeDirection(Direction.LEFT);
        b.moveSnake(); // one unit right, one unit down, one unit left
        b.setSnakeDirection(Direction.UP);
        b.moveSnake(); // one unit right, one unit down, one unit left, one unit up
        if (!b.didSnakeCollide()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        if (testDidSnakeCollide()) {
            System.out.println("PASSED");
        }
    }

}
