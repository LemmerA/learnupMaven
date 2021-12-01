package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameManagerTest {
    private final int[] speedArr = {0, 0, 0, 5, 0, 0, 11, 0, 0, 32, 10, 0};
    private final int[] loseArr = {15, 4, 1, 0, 0, 0};
    private final int[] winArr = {0, 0, 0, 0, 0, 0};
    private final int[] negativeArr = {-11, -10, -3, -0, -99, -100};
    private final int[] emptyArr = {};
    private final int[] maxIntArr = {10, Integer.MAX_VALUE + 1};

    FastPlayer p1 = new FastPlayer(5, 2);

    GameState gameState = new GameState();
    SpeedGameState speedGameState = new SpeedGameState();
    GameManager gameManager = new GameManager();

    @BeforeEach
    public void setup(){
        gameState.setGreenLight(false);
        speedGameState.setGreenLight(false);
        speedGameState.setMaxSpeed(10);
        gameManager.setGameState(gameState);
    }

    //countRounds tests, GameState
    @Test
    public void successCountRounds() {
        assertEquals(3, gameManager.countRounds(speedArr));
    }

    @Test
    public void successCountRoundsAllLose() {
        assertEquals(0, gameManager.countRounds(loseArr));
    }

    @Test
    public void successCountRoundsAllWin() {
        assertEquals(6, gameManager.countRounds(winArr));
    }

    @Test
    public void successCountRoundsNegatives() {
        assertEquals(6, gameManager.countRounds(negativeArr));
    }

    @Test
    public void successCountRoundsEmpty() {
        assertEquals(0, gameManager.countRounds(emptyArr));
    }

    @Test
    public void successCountRoundsIntMax() {
        assertDoesNotThrow(() -> gameManager.countRounds(maxIntArr));
    }

    @Test
    public void successCountRoundsGreen() {
        gameState.setGreenLight(true);
        assertEquals(12, gameManager.countRounds(speedArr));
    }

    //countRounds tests, SpeedGameState
    @Test
    public void successCountRoundsSpeed() {
        gameManager.setGameState(speedGameState);
        assertEquals(6, gameManager.countRounds(speedArr));
    }

    @Test
    public void successCountRoundsSpeedAllLose() {
        gameManager.setGameState(speedGameState);
        assertEquals(0, gameManager.countRounds(loseArr));
    }

    @Test
    public void successCountRoundsSpeedAllWin() {
        gameManager.setGameState(speedGameState);
        assertEquals(6, gameManager.countRounds(winArr));
    }

    @Test
    public void successCountRoundsSpeedNegatives() {
        gameManager.setGameState(speedGameState);
        assertEquals(6, gameManager.countRounds(negativeArr));
    }

    @Test
    public void successCountRoundsSpeedEmpty() {
        gameManager.setGameState(speedGameState);
        assertEquals(0, gameManager.countRounds(emptyArr));
    }

    @Test
    public void successCountRoundsSpeedIntMax() {
        gameManager.setGameState(speedGameState);
        assertDoesNotThrow(() -> gameManager.countRounds(maxIntArr));
    }

    @Test
    public void successCountRoundsSpeedGreen() {
        speedGameState.setGreenLight(true);
        gameManager.setGameState(speedGameState);
        assertEquals(12, gameManager.countRounds(speedArr));
    }

    @Test
    public void successCountRoundsSpeedNegativeMaxSpeed() {
        speedGameState.setMaxSpeed(-10);
        gameManager.setGameState(speedGameState);
        assertEquals(2, gameManager.countRounds(negativeArr));
    }

    //loser, SpeedGameState tests
    @Test
    public void successLoserP1Speed() {
        gameManager.setGameState(speedGameState);
        ConstantPlayer p2 = new ConstantPlayer(5);
        assertEquals(-1, gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoserP2Speed() {
        gameManager.setGameState(speedGameState);
        ConstantPlayer p2 = new ConstantPlayer(11);
        assertEquals(1, gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoserDrawSpeed() {
        speedGameState.setMaxSpeed(25);
        gameManager.setGameState(speedGameState);
        ConstantPlayer p2 = new ConstantPlayer(25);
        assertEquals(0, gameManager.loser(p1, p2, 10));
    }

    @Test
    public void successLoserBothLoseSpeed() {
        gameManager.setGameState(speedGameState);
        FastPlayer p1 = new FastPlayer(0, 2);
        FastPlayer p2 = new FastPlayer(5, 1);
        assertEquals(0, gameManager.loser(p1, p2, 6));
    }

    @Test
    public void successLoserP1FastSpeed() {
        gameManager.setGameState(speedGameState);
        FastPlayer p2 = new FastPlayer(5, 1);
        assertEquals(-1, gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoserSlowSpeed() {
        gameManager.setGameState(speedGameState);
        FastPlayer p1 = new FastPlayer(5, -3);
        FastPlayer p2 = new FastPlayer(5, -1);
        assertEquals(0, gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoser0StepSpeed() {
        gameManager.setGameState(speedGameState);
        ConstantPlayer p1 = new ConstantPlayer(10);
        FastPlayer p2 = new FastPlayer(10, 0);
        assertEquals(0, gameManager.loser(p1, p2, 100));
    }

    //loser, GameState tests
    @Test
    public void successLoser0Rounds() {
        FastPlayer p2 = new FastPlayer(5, 1);
        assertEquals(0, gameManager.loser(p1, p2, 0));
    }

    @Test
    public void successLoserNegativeRounds() {
        FastPlayer p2 = new FastPlayer(5, 1);
        assertEquals(0, gameManager.loser(p1, p2, -1));
    }

    @Test
    public void successLoserStepOverflow() {
        FastPlayer p1 = new FastPlayer(5, Integer.MIN_VALUE);
        FastPlayer p2 = new FastPlayer(5, Integer.MAX_VALUE);
        assertDoesNotThrow(() -> gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoserP1Regular() {
        FastPlayer p1 = new FastPlayer(0, 2);
        ConstantPlayer p2 = new ConstantPlayer(0);
        assertEquals(-1, gameManager.loser(p1, p2, 1));
    }

    @Test
    public void successLoserP2Regular() {
        FastPlayer p1 = new FastPlayer(0, 0);
        FastPlayer p2 = new FastPlayer(0, 1);
        assertEquals(1, gameManager.loser(p1, p2, 10));
    }

    @Test
    public void successLoserBothLoseRegular() {
        FastPlayer p1 = new FastPlayer(0, 5);
        FastPlayer p2 = new FastPlayer(0, 1);
        assertEquals(0, gameManager.loser(p1, p2, 10));
    }

    @Test
    public void successLoserRegularGreen() {
        gameState.setGreenLight(true);
        gameManager.setGameState(gameState);
        FastPlayer p1 = new FastPlayer(0, 2);
        ConstantPlayer p2 = new ConstantPlayer(5);
        assertEquals(0, gameManager.loser(p1, p2, 5));
    }

    @Test
    public void successLoserRegularNegative() {
        FastPlayer p1 = new FastPlayer(-100, 20);
        FastPlayer p2 = new FastPlayer(-10, 5);
        assertEquals(1, gameManager.loser(p1, p2, 10));
    }
}
