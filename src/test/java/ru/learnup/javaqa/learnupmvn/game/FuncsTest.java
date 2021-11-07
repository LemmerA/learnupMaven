package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncsTest {

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
    private final String[] nullArr = {null, null, null};
    private final String[] whitespaceArr = {" ", " ", " "};
    private final String[] extraWhitespaceNameArr = {"John      50", "Mary  1", "Jack   0",
            "Helen 0", "Kate       10", "Gary                  5", "Lily        1"};
    private final String[] extraArgArr = {"John 50 18yo", "Mary 1 21yo", "Jack 0 20yo",
            "Helen 0 31yo", "Kate 10 35yo", "Gary 5 19yo", "Lily 1 60yo"};
    private final String[] typoNameArr = {"John50 50", "Mary` 1", "Jack, 0", "Helen1 0"};
    private final String[] typoSpeedArr = {"John 50a", "Mary 1,", "Jack 0*", "Helen 0ф"};
    private final String[] floatArr = {"John 50.512", "Mary 1.0", "Jack 0.9", "Helen 0.1",
            "Kate 10.0", "Gary 5.99", "Lily 1.009"};
    private final String[] intMaxArr = {"John 2147483647", "Mary -2147483648",
            "Jack 2147483647", "Helen -2147483648"};
    private final String[] intOverflowArr = {"John 2147483648", "Mary -2147483649",
            "Jack 2147483647", "Helen -2147483648"};
    private final String[] unsignedIntMaxArr = {"John 4294967295", "Mary 4294967295",
            "Jack 4294967295"};
    private final String[] unsignedIntOverflowArr = {"John 4294967296", "Mary 4294967296",
            "Jack 4294967296"};

    GameState gameState = new GameState(false, 1);
    GameState gameStateGreen = new GameState(true, 1);
    GameState gameStateNegative = new GameState(false, -10);

    //countLostSpeeds tests
    @Test
    public void successCountLostSpeeds() {
        assertEquals(5, gameState.countLostSpeeds(speedArr));
    }

    @Test
    public void successCountLostSpeedsAllLose() {
        assertEquals(3, gameState.countLostSpeeds(loseArr));
    }

    @Test
    public void successCountLostSpeedsAllWin() {
        assertEquals(0, gameState.countLostSpeeds(winArr));
    }

    @Test
    public void successCountLostSpeedsNegatives() {
        assertEquals(0, gameState.countLostSpeeds(negativeArr));
    }

    @Test
    public void successCountLostSpeedsEmpty() {
        assertEquals(0, gameState.countLostSpeeds(emptyArr));
    }

    @Test
    public void successCountLostSpeedsIntMax() {
        assertDoesNotThrow(() -> gameState.countLostSpeeds(maxIntArr));
    }

    @Test
    public void successCountLostSpeedsGreen() {
        assertEquals(0, gameStateGreen.countLostSpeeds(speedArr));
    }

    @Test
    public void successCountLostSpeedsNegativeMaxSpeed() {
        assertEquals(3, gameStateNegative.countLostSpeeds(negativeArr));
    }

    //lostSpeedArr tests
    @Test
    public void successLostArr() {
        int[] expected = {50, 21, 50, 32, 10};
        assertArrayEquals(expected, gameState.lostSpeedArr(speedArr));
    }

    @Test
    public void successLostArrAllLose() {
        assertArrayEquals(loseArr, gameState.lostSpeedArr(loseArr));
    }

    @Test
    public void successLostArrAllWin() {
        assertArrayEquals(emptyArr, gameState.lostSpeedArr(winArr));
    }

    @Test
    public void successLostArrNegatives() {
        assertArrayEquals(emptyArr, gameState.lostSpeedArr(negativeArr));
    }

    @Test
    public void successLostArrEmpty() {
        assertArrayEquals(emptyArr, gameState.lostSpeedArr(emptyArr));
    }

    @Test
    public void successLostArrIntMax() {
        assertDoesNotThrow(() -> gameState.lostSpeedArr(maxIntArr));
    }

    @Test
    public void successLostArrGreen() {
        assertArrayEquals(emptyArr, gameStateGreen.lostSpeedArr(speedArr));
    }

    @Test
    public void successLostArrNegativeMaxSpeed() {
        int[] expected = {-1, -3, -0};
        assertArrayEquals(expected, gameStateNegative.lostSpeedArr(negativeArr));
    }

    //wonSpeedArr tests
    @Test
    public void successWonArr() {
        int[] expected = {0, 0, 1, 1, 0, 1, 1};
        assertArrayEquals(expected, gameState.wonSpeedArr(speedArr));
    }

    @Test
    public void successWonArrAllLose() {
        assertArrayEquals(emptyArr, gameState.wonSpeedArr(loseArr));
    }

    @Test
    public void successWonArrAllWin() {
        assertArrayEquals(winArr, gameState.wonSpeedArr(winArr));
    }

    @Test
    public void successWonArrNegatives() {
        assertArrayEquals(negativeArr, gameState.wonSpeedArr(negativeArr));
    }

    @Test
    public void successWonArrEmpty() {
        assertArrayEquals(emptyArr, gameState.wonSpeedArr(emptyArr));
    }

    @Test
    public void successWonArrIntMax() {
        assertDoesNotThrow(() -> gameState.wonSpeedArr(maxIntArr));
    }

    @Test
    public void successWonArrGreen() {
        assertArrayEquals(speedArr, gameStateGreen.wonSpeedArr(speedArr));
    }

    @Test
    public void successWonArrNegativeMaxSpeed() {
        int[] expected = {-10, -99};
        assertArrayEquals(expected, gameStateNegative.wonSpeedArr(negativeArr));
    }

    //countLostNames tests
    @Test
    public void successCountLostNames() {
        assertEquals(3, gameState.countLostNames(nameArr));
    }

    @Test
    public void successCountLostNamesAllLose() {
        assertEquals(4, gameState.countLostNames(loseNameArr));
    }

    @Test
    public void successCountLostNamesAllWin() {
        assertEquals(0, gameState.countLostNames(winNameArr));
    }

    @Test
    public void successCountLostNamesNegatives() {
        assertEquals(0, gameState.countLostNames(negativeNameArr));
    }

    @Test
    public void successCountLostNamesEmpty() {
        assertEquals(0, gameState.countLostNames(emptyNameArr));
    }

    @Test
    public void failCountLostNamesEmptyString() {
        assertThrows(Exception.class, () -> gameState.countLostNames(emptyStringArr));
    }

    @Test
    public void failCountLostNamesMissingName() {
        assertThrows(Exception.class, () -> gameState.countLostNames(missingNameArr));
    }

    @Test
    public void failCountLostNamesMissingSpeed() {
        assertThrows(Exception.class, () -> gameState.countLostNames(missingSpeedArr));
    }

    @Test
    public void failCountLostNamesNull() {
        assertThrows(Exception.class, () -> gameState.countLostNames(nullArr));
    }

    @Test
    public void failCountLostNamesWhitespace() {
        assertThrows(Exception.class, () -> gameState.countLostNames(whitespaceArr));
    }

    @Test
    public void successCountLostNamesGreen() {
        assertEquals(0, gameStateGreen.countLostNames(nameArr));
    }

    @Test
    public void successCountLostNamesNegativeMaxSpeed() {
        assertEquals(3, gameStateNegative.countLostNames(negativeNameArr));
    }

    @Test
    public void successCountLostNamesExtraWhitespace() {
        assertEquals(3, gameState.countLostNames(extraWhitespaceNameArr));
    }

    @Test
    public void successCountLostNamesExtraArg() {
        assertEquals(3, gameState.countLostNames(extraArgArr));
    }

    @Test
    public void successCountLostNamesTypoName() {
        assertEquals(1, gameState.countLostNames(typoNameArr));
    }

    @Test
    public void successCountLostNamesTypoSpeed() {
        assertThrows(Exception.class, () -> gameState.countLostNames(typoSpeedArr));
    }

    @Test
    public void successCountLostNamesFloat() {
        assertThrows(Exception.class, () -> gameState.countLostNames(floatArr));
    }

    @Test
    public void successCountLostNamesIntMax() {
        assertDoesNotThrow(() -> gameState.countLostNames(intMaxArr));
    }

    @Test
    public void successCountLostNamesIntOverflow() {
        assertThrows(NumberFormatException.class, () -> gameState.countLostNames(intOverflowArr));
    }

    @Test
    public void successCountLostNamesUnsignedIntMax() {
        assertThrows(NumberFormatException.class, () -> gameState.countLostNames(unsignedIntMaxArr));
    }

    @Test
    public void successCountLostNamesUnsignedIntOverflow() {
        assertThrows(NumberFormatException.class, () -> gameState.countLostNames(unsignedIntOverflowArr));
    }

    //wonNameArr tests
    @Test
    public void successWonNameArr() {
        String[] expected = {"Mary", "Jack", "Helen", "Lily"};
        assertArrayEquals(expected, gameState.wonNameArr(nameArr));
    }

    @Test
    public void successWonNameArrAllLose() {
        assertArrayEquals(emptyNameArr, gameState.wonNameArr(loseNameArr));
    }

    @Test
    public void successWonNameArrAllWin() {
        String[] expected = {"John", "Mary", "Jack", "Helen"};
        assertArrayEquals(expected, gameState.wonNameArr(winNameArr));
    }

    @Test
    public void successWonNameArrNegatives() {
        String[] expected = {"John", "Mary", "Jack", "Helen", "Kate"};
        assertArrayEquals(expected, gameState.wonNameArr(negativeNameArr));
    }

    @Test
    public void successWonNameArrEmpty() {
        assertArrayEquals(emptyNameArr, gameState.wonNameArr(emptyNameArr));
    }

    @Test
    public void failWonNameArrEmptyString() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(emptyStringArr));
    }

    @Test
    public void failWonNameArrMissingName() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(missingNameArr));
    }

    @Test
    public void failWonNameArrMissingSpeed() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(missingSpeedArr));
    }

    @Test
    public void failWonNameArrNull() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(nullArr));
    }

    @Test
    public void failWonNameArrWhitespace() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(whitespaceArr));
    }

    @Test
    public void successWonNameArrGreen() {
        String[] expected = {"John", "Mary", "Jack", "Helen",
                "Kate", "Gary", "Lily"};
        assertArrayEquals(expected, gameStateGreen.wonNameArr(nameArr));
    }

    @Test
    public void successWonNameArrNegativeMaxSpeed() {
        String[] expected = {"John", "Kate"};
        assertArrayEquals(expected, gameStateNegative.wonNameArr(negativeNameArr));
    }

    @Test
    public void successWonNameArrExtraWhitespace() {
        String[] expected = {"Mary", "Jack", "Helen", "Lily"};
        assertArrayEquals(expected, gameState.wonNameArr(extraWhitespaceNameArr));
    }

    @Test
    public void successWonNameArrExtraArg() {
        String[] expected = {"Mary", "Jack", "Helen", "Lily"};
        assertArrayEquals(expected, gameState.wonNameArr(extraArgArr));
    }

    @Test
    public void successWonNameArrTypoName() {
        String[] expected = {"Mary`", "Jack,", "Helen1"};
        assertArrayEquals(expected, gameState.wonNameArr(typoNameArr));
    }

    @Test
    public void successWonNameArrTypoSpeed() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(typoSpeedArr));
    }

    @Test
    public void successWonNameArrFloat() {
        assertThrows(Exception.class, () -> gameState.wonNameArr(floatArr));
    }

    @Test
    public void successWonNameArrIntMax() {
        assertDoesNotThrow(() -> gameState.wonNameArr(intMaxArr));
    }

    @Test
    public void successWonNameArrIntOverflow() {
        assertThrows(NumberFormatException.class, () -> gameState.wonNameArr(intOverflowArr));
    }

    @Test
    public void successWonNameArrUnsignedIntMax() {
        assertThrows(NumberFormatException.class, () -> gameState.wonNameArr(unsignedIntMaxArr));
    }

    @Test
    public void successWonNameArrUnsignedIntOverflow() {
        assertThrows(NumberFormatException.class, () -> gameState.wonNameArr(unsignedIntOverflowArr));
    }
}