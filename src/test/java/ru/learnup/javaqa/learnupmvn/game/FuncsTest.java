package ru.learnup.javaqa.learnupmvn.game;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static ru.learnup.javaqa.learnupmvn.game.Funcs.*;

class FuncsTest {

    private int[] loseArr = {1, 2, 6};
    private int[] winArr = {0, 0, 0};
    private int[] negativeArr = {-1, -10, -3};
    private int[] emptyArr = new int[0];
    private int[] maxIntArr = {1, Integer.MAX_VALUE + 1};

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
        assertTrue(Arrays.equals(loseArr, lostSpeedArr(loseArr)));
    }

    @Test
    public void successAllWinLostArr(){
        assertTrue(Arrays.equals(emptyArr, lostSpeedArr(winArr)));
    }

    @Test
    public void successNegativesLostArr(){
        assertTrue(Arrays.equals(emptyArr, lostSpeedArr(negativeArr)));
    }

    @Test
    public void successEmptyLostArr(){
        assertTrue(Arrays.equals(emptyArr, lostSpeedArr(emptyArr)));
    }

    @Test
    public void successIntMaxLostArr(){
        assertDoesNotThrow(()-> lostSpeedArr(maxIntArr));
    }

    //wonSpeedArr tests
    @Test
    public void successAllLoseWonArr(){
        assertTrue(Arrays.equals(emptyArr, wonSpeedArr(loseArr)));
    }

    @Test
    public void successAllWinWonArr(){
        assertTrue(Arrays.equals(winArr, wonSpeedArr(winArr)));
    }

    @Test
    public void successNegativesWonArr(){
        assertTrue(Arrays.equals(negativeArr, wonSpeedArr(negativeArr)));
    }

    @Test
    public void successEmptyWonArr(){
        assertTrue(Arrays.equals(emptyArr, wonSpeedArr(emptyArr)));
    }

    @Test
    public void successIntMaxWonArr(){
        assertDoesNotThrow(()-> wonSpeedArr(maxIntArr));
    }
}