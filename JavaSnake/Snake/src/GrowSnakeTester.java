public class GrowSnakeTester {

    static final int GAME_UNITS = 14400;
    static final int SCORE_HEIGHT = 100;

    public static boolean testGetX() {
        BabySnake bs = new BabySnake();
        GrowSnake gs = new GrowSnake(bs);

        int[] testX = gs.getX();

        for (int i = 0; i < testX.length; i++) {
            if (testX[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean testGetY() {
        BabySnake bs = new BabySnake();
        GrowSnake gs = new GrowSnake(bs);

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
        GrowSnake gs = new GrowSnake(bs);

        int actualBodyParts = gs.getBodyParts();

        int expectedBodyParts = 6+1;

        return actualBodyParts == expectedBodyParts;
    }

    public static boolean testGetApplesEaten() {
        BabySnake bs = new BabySnake();
        GrowSnake gs = new GrowSnake(bs);

        int actualApplesEaten = gs.getApplesEaten();

        int expectedApplesEaten = 0+1;

        return actualApplesEaten == expectedApplesEaten;
    }

    public static void main(String[] args) throws Exception {
        if (!testGetBodyParts()) {
            throw new ReflectiveOperationException("f");
        }
    }
}
