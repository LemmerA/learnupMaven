import java.util.Arrays;

import static ru.learnup.javaqa.learnupmvn.game.Funcs.*;

public class Main {
    public static void main(String[] args) {

        int[] speedArr = {50, 0, 21, 5, 1, 15, 50, 0, 2, 5, 1, 2};
        String[] nameArr = {"John 50", "Mary 5", "Jack 0", "Helen 10"};

        System.out.println("Горит зеленый: " + isGreenLight);
        System.out.println("Максимальная скорость: " + MAX_SPEED);
        System.out.println("Количество выбывших: " + countLost(speedArr));
        System.out.println("Скорости выбывших: " + Arrays.toString(lostSpeedArr(speedArr)));
        System.out.println("Скорости выигравших: " + Arrays.toString(wonSpeedArr(speedArr)));
        System.out.println("Имена выигравших: " + Arrays.toString(wonNameArr(nameArr)));
    }
}