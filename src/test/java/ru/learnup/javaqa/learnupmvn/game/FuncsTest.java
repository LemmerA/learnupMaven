package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static ru.learnup.javaqa.learnupmvn.game.Funcs.*;

class FuncsTest {

    @BeforeEach
    public void setup() {
        MAX_SPEED = 1;
        isGreenLight = false;
    }

    private final int[] speedArr = {50, 0, 21, 0, 1, 1, 50, 0, 1, 32, 10, 1};
    private final int[] loseArr = {2, 3, 7};
    private final int[] winArr = {0, 1, 0};
    private final int[] negativeArr = {-1, -10, -3, -0, -99};
    private final int[] emptyArr = {};
    private final int[] maxIntArr = {10, Integer.MAX_VALUE + 1};
    private final String[] nameArr = {"John 50", "Mary 1", "Jack 0", "Helen 0",
            "Kate 10", "Gary 5", "Lily 1"};
    private final String[] loseNameArr = {"John 50", "Mary 11", "Jack 2", "Helen 10"};
    private final String[] winNameArr = {"John 0", "Mary 1", "Jack 0", "Helen 0"};
    private final String[] negativeNameArr = {"John -50", "Mary -1", "Jack -0",
            "Helen 0", "Kate -10"};
    private final String[] emptyNameArr = {};
    private final String[] emptyStringArr = {"", "", ""};
    private final String[] missingNameArr = {"-50", "50", "0"};
    private final String[] missingSpeedArr = {"John", "Mary", "Jack"};

    //countLost tests
    @Test
    public void successCountLost() {
        assertEquals(5, countLost(speedArr));
    }

    @Test
    public void successCountLostAllLose() {
        assertEquals(3, countLost(loseArr));
    }

    @Test
    public void successCountLostAllWin() {
        assertEquals(0, countLost(winArr));
    }

    @Test
    public void successCountLostNegatives() {
        assertEquals(0, countLost(negativeArr));
    }

    @Test
    public void successCountLostEmpty() {
        assertEquals(0, countLost(emptyArr));
    }

    @Test
    public void successCountLostIntMax() {
        assertDoesNotThrow(() -> countLost(maxIntArr));
    }

    @Test
    public void successCountLostGreen() {
        isGreenLight = true;
        assertEquals(0, countLost(speedArr));
    }

    @Test
    public void successCountLostNegativeMaxSpeed() {
        MAX_SPEED = -10;
        assertEquals(3, countLost(negativeArr));
    }

    //lostSpeedArr tests
    @Test
    public void successLostArr() {
        int[] expected = {50, 21, 50, 32, 10};
        assertArrayEquals(expected, lostSpeedArr(speedArr));
    }

    @Test
    public void successLostArrAllLose() {
        assertArrayEquals(loseArr, lostSpeedArr(loseArr));
    }

    @Test
    public void successLostArrAllWin() {
        assertArrayEquals(emptyArr, lostSpeedArr(winArr));
    }

    @Test
    public void successLostArrNegatives() {
        assertArrayEquals(emptyArr, lostSpeedArr(negativeArr));
    }

    @Test
    public void successLostArrEmpty() {
        assertArrayEquals(emptyArr, lostSpeedArr(emptyArr));
    }

    @Test
    public void successLostArrIntMax() {
        assertDoesNotThrow(() -> lostSpeedArr(maxIntArr));
    }

    @Test
    public void successLostArrGreen() {
        isGreenLight = true;
        assertArrayEquals(emptyArr, lostSpeedArr(speedArr));
    }

    @Test
    public void successLostArrNegativeMaxSpeed() {
        MAX_SPEED = -10;
        int[] expected = {-1, -3, -0};
        assertArrayEquals(expected, lostSpeedArr(negativeArr));
    }

    //wonSpeedArr tests
    @Test
    public void successWonArr() {
        int[] expected = {0, 0, 1, 1, 0, 1, 1};
        assertArrayEquals(expected, wonSpeedArr(speedArr));
    }

    @Test
    public void successWonArrAllLose() {
        assertArrayEquals(emptyArr, wonSpeedArr(loseArr));
    }

    @Test
    public void successWonArrAllWin() {
        assertArrayEquals(winArr, wonSpeedArr(winArr));
    }

    @Test
    public void successWonArrNegatives() {
        assertArrayEquals(negativeArr, wonSpeedArr(negativeArr));
    }

    @Test
    public void successWonArrEmpty() {
        assertArrayEquals(emptyArr, wonSpeedArr(emptyArr));
    }

    @Test
    public void successWonArrIntMax() {
        assertDoesNotThrow(() -> wonSpeedArr(maxIntArr));
    }

    @Test
    public void successWonArrGreen() {
        isGreenLight = true;
        assertArrayEquals(speedArr, wonSpeedArr(speedArr));
    }

    @Test
    public void successWonArrNegativeMaxSpeed() {
        MAX_SPEED = -10;
        int[] expected = {-10, -99};
        assertArrayEquals(expected, wonSpeedArr(negativeArr));
    }

    //wonNameArr tests
    @Test
    public void successWonNameArr() {
        String[] expected = {"Mary", "Jack", "Helen", "Lily"};
        assertArrayEquals(expected, wonNameArr(nameArr));
    }

    @Test
    public void successWonNameArrAllLose() {
        assertArrayEquals(emptyNameArr, wonNameArr(loseNameArr));
    }

    @Test
    public void successWonNameArrAllWin() {
        String[] expected = {"John", "Mary", "Jack", "Helen"};
        assertArrayEquals(expected, wonNameArr(winNameArr));
    }

    @Test
    public void successWonNameArrNegatives() {
        String[] expected = {"John", "Mary", "Jack", "Helen", "Kate"};
        assertArrayEquals(expected, wonNameArr(negativeNameArr));
    }

    @Test
    public void successWonNameArrEmpty() {
        assertArrayEquals(emptyNameArr, wonNameArr(emptyNameArr));
    }

    @Test
    public void failWonNameArrEmptyString() {
        assertThrows(Exception.class, () -> wonNameArr(emptyStringArr));
    }

    @Test
    public void failWonNameArrMissingName() {
        assertThrows(Exception.class, () -> wonNameArr(missingNameArr));
    }

    @Test
    public void failWonNameArrMissingSpeed() {
        assertThrows(Exception.class, () -> wonNameArr(missingSpeedArr));
    }

    @Test
    public void successWonNameArrGreen() {
        isGreenLight = true;
        String[] expected = {"John", "Mary", "Jack", "Helen",
                "Kate", "Gary", "Lily"};
        assertArrayEquals(expected, wonNameArr(nameArr));
    }

    @Test
    public void successWonNameArrNegativeMaxSpeed() {
        MAX_SPEED = -10;
        String[] expected = {"John", "Kate"};
        assertArrayEquals(expected, wonNameArr(negativeNameArr));
    }
}