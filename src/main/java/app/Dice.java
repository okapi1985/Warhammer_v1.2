package app;

import java.util.Random;

public class Dice {

    private static final int D6 = 6;

    public static int rollDice() {
        Random r = new Random();
        int result = r.nextInt(D6) + 1;
        System.out.println(result);
        return result;
    }
}
