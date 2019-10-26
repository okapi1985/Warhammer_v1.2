package app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @RepeatedTest(6)
    @Disabled("Not yet found how to test it")
    void testRollDice() {
        Dice dice = new Dice();
        int result = dice.rollDice();
        assertEquals(6,result);
    }
}