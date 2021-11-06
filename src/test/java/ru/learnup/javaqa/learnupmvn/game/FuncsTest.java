package ru.learnup.javaqa.learnupmvn.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static ru.learnup.javaqa.learnupmvn.game.Funcs.*;

class FuncsTest {

    @BeforeAll
    public static void setup(){
        MAX_SPEED = 1;
    }

    private final int[] loseArr = {2, 3, 7};
    private final int[] winArr = {0, 1, 0};
    private final int[] negativeArr = {-1, -10, -3};
    private final int[] emptyArr = new int[0];
    private final int[] maxIntArr = {10, Integer.MAX_VALUE + 1};

    //countLost tests
    @Test
    public void successAllLoseCount(){
        assertEquals(3, countLost(loseArr));
    }

    @Test
    public void successAllWinCount(){
        assertEquals(0, countLost(winArr));
    }

    @Test
    public void successNegativesCount(){
        assertEquals(0, countLost(negativeArr));
    }

    @Test
    public void successEmptyCount(){
        assertEquals(0, countLost(emptyArr));
    }

    @Test
    public void successIntMaxCount(){
        assertDoesNotThrow(()-> countLost(maxIntArr));
    }

    //lostSpeedArr tests
    @Test
    public void successAllLoseLostArr(){
        assertArrayEquals(loseArr, lostSpeedArr(loseArr));
    }

    @Test
    public void successAllWinLostArr(){
        assertArrayEquals(emptyArr, lostSpeedArr(winArr));
    }

    @Test
    public void successNegativesLostArr(){
        assertArrayEquals(emptyArr, lostSpeedArr(negativeArr));
    }

    @Test
    public void successEmptyLostArr(){
        assertArrayEquals(emptyArr, lostSpeedArr(emptyArr));
    }

    @Test
    public void successIntMaxLostArr(){
        assertDoesNotThrow(()-> lostSpeedArr(maxIntArr));
    }

    //wonSpeedArr tests
    @Test
    public void successAllLoseWonArr(){
        assertArrayEquals(emptyArr, wonSpeedArr(loseArr));
    }

    @Test
    public void successAllWinWonArr(){
        assertArrayEquals(winArr, wonSpeedArr(winArr));
    }

    @Test
    public void successNegativesWonArr(){
        assertArrayEquals(negativeArr, wonSpeedArr(negativeArr));
    }

    @Test
    public void successEmptyWonArr(){
        assertArrayEquals(emptyArr, wonSpeedArr(emptyArr));
    }

    @Test
    public void successIntMaxWonArr(){
        assertDoesNotThrow(()-> wonSpeedArr(maxIntArr));
    }
}