import java.util.HashSet;

public class AppleTester {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int SCORE_HEIGHT = 100;
    static final int UNIT_SIZE = 25;

    public static boolean testGetNextX() {
        Apple a = Apple.getInstance();

        HashSet<Integer> validXValues = new HashSet<Integer>();

        for (int i = 0; i <= SCREEN_WIDTH/UNIT_SIZE; i++) {
            validXValues.add(i * UNIT_SIZE);
        }

        for (int i = 0; i < 20; i++) {
            int actualXValue = a.getNextX();

            if (!validXValues.contains(actualXValue)) {
                return false;
            }
        }

        return true;
    }

    public static boolean testGetNextY() {
        Apple a = Apple.getInstance();

        HashSet<Integer> validYValues = new HashSet<Integer>();

        for (int i = 0; i <= SCREEN_HEIGHT/UNIT_SIZE; i++) {
            validYValues.add((i * UNIT_SIZE) + SCORE_HEIGHT);
        }

        for (int i = 0; i < 20; i++) {
            int actualYValue = a.getNextY();

            if (!validYValues.contains(actualYValue)) {
                return false;
            }
        }

        return true;
    }

    public static boolean testResetApple() {
        Apple a = Apple.getInstance();

        HashSet<Integer> validXValues = new HashSet<Integer>();
        HashSet<Integer> validYValues = new HashSet<Integer>();

        for (int i = 0; i <= SCREEN_WIDTH/UNIT_SIZE; i++) {
            validXValues.add(i * UNIT_SIZE);
        }

        for (int i = 0; i <= SCREEN_HEIGHT/UNIT_SIZE; i++) {
            validYValues.add((i * UNIT_SIZE) + SCORE_HEIGHT);
        }

        for (int i = 0; i < 20; i++) {
            a.resetApple();
            int actualXValue = a.getAppleX();
            int actualYValue = a.getAppleY();

            if (!validXValues.contains(actualXValue) || !validYValues.contains(actualYValue)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        if (!testGetNextX()) {
            throw new ReflectiveOperationException("a");
        }
        if (!testGetNextY()) {
            throw new ReflectiveOperationException("b");
        }
        if (!testResetApple()) {
            throw new ReflectiveOperationException("c");
        }
    }
}
