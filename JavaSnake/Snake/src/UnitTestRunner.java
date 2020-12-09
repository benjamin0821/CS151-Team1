public class UnitTestRunner {

    public static void main(String[] args) {
        int testsPassed = 0;
        int testsFailed = 0;

        // BabySnake tests
        System.out.println("*********************************");
        System.out.println("Running unit tests for BabySnake:");
        System.out.println("*********************************");

        // testGetX
        System.out.print("testGetX: ");
        if (BabySnakeTester.testGetX()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetY
        System.out.print("testGetY: ");
        if (BabySnakeTester.testGetY()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetBodyParts
        System.out.print("testGetBodyParts: ");
        if (BabySnakeTester.testGetBodyParts()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetApplesEaten
        System.out.print("testGetApplesEaten: ");
        if (BabySnakeTester.testGetApplesEaten()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // GrowSnake tests
        System.out.println();
        System.out.println("*********************************");
        System.out.println("Running unit tests for GrowSnake:");
        System.out.println("*********************************");

        // testGetX
        System.out.print("testGetX: ");
        if (GrowSnakeTester.testGetX()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetY
        System.out.print("testGetY: ");
        if (GrowSnakeTester.testGetY()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetBodyParts
        System.out.print("testGetBodyParts: ");
        if (GrowSnakeTester.testGetBodyParts()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetApplesEaten
        System.out.print("testGetApplesEaten: ");
        if (GrowSnakeTester.testGetApplesEaten()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // Apple tests
        System.out.println();
        System.out.println("*****************************");
        System.out.println("Running unit tests for Apple:");
        System.out.println("*****************************");

        // testGetX
        System.out.print("testGetNextX: ");
        if (AppleTester.testGetNextX()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testGetY
        System.out.print("testGetNextY: ");
        if (AppleTester.testGetNextY()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // testResetApple
        System.out.print("testResetApple: ");
        if (AppleTester.testResetApple()) {
            testsPassed++;
            System.out.println("PASSED");
        } else {
            testsFailed++;
            System.out.println("FAILED");
        }

        // Summary
        int totalTests = testsPassed + testsFailed;
        System.out.println();
        System.out.println("SUMMARY:");
        System.out.println("Tests passed: " + testsPassed);
        System.out.println("Tests failed: " + testsFailed);
        System.out.println("Total tests: " + totalTests);
    }

}
