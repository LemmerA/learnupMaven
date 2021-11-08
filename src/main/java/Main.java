import ru.learnup.javaqa.learnupmvn.game.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameState gameState = new GameState(true);
        SpeedGameState speedGameState = new SpeedGameState(false, 10);
        SpeedGameState test = new SpeedGameState(1);
        int[] speedArr = {50, 0, 21, 5, 1, 15, 50, 0, 2, 5, 1, 2};
        String[] nameArr = {"John 50", "Mary 5", "Jack 0", "Helen 10"};

        System.out.println("Игра 1:");
        System.out.println("Количество выбывших: " + gameState.countLostSpeeds(speedArr));
        System.out.println("Скорости выбывших: " + Arrays.toString(gameState.lostSpeedArr(speedArr)));
        System.out.println("Скорости выигравших: " + Arrays.toString(gameState.wonSpeedArr(speedArr)));
        System.out.println("Имена выигравших: " + Arrays.toString(gameState.wonNameArr(nameArr)));

        System.out.println("Игра 2:");
        System.out.println("Количество выбывших: " + speedGameState.countLostSpeeds(speedArr));
        System.out.println("Скорости выбывших: " + Arrays.toString(speedGameState.lostSpeedArr(speedArr)));
        System.out.println("Скорости выигравших: " + Arrays.toString(speedGameState.wonSpeedArr(speedArr)));
        System.out.println("Имена выигравших: " + Arrays.toString(speedGameState.wonNameArr(nameArr)));
    }
}