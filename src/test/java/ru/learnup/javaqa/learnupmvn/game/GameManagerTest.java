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
}
