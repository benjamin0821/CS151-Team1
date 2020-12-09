public class BabySnakeTester {

    static final int GAME_UNITS = 14400;
    static final int SCORE_HEIGHT = 100;

    public static boolean testGetX() {
        BabySnake bs = new BabySnake();

        int[] testX = bs.getX();

        for (int i = 0; i < testX.length; i++) {
            if (testX[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean testGetY() {
        BabySnake bs = new BabySnake();

        int[] testY = bs.getY();

        for (int i = 0; i < testY.length; i++) {
            if (testY[i] != SCORE_HEIGHT) {
                return false;
            }
        }

        return true;
    }

    public static boolean testGetBodyParts() {
        BabySnake bs = new BabySnake();

        int actualBodyParts = bs.getBodyParts();

        int expectedBodyParts = 6;

        return actualBodyParts == expectedBodyParts;
    }

    public static boolean testGetApplesEaten() {
        BabySnake bs = new BabySnake();

        int actualApplesEaten = bs.getApplesEaten();

        int expectedApplesEaten = 0;

        return actualApplesEaten == expectedApplesEaten;
    }

    public static void main(String[] args) throws Exception {
        if (!testGetApplesEaten()) {
            throw new ReflectiveOperationException("f");
        }
    }
}
