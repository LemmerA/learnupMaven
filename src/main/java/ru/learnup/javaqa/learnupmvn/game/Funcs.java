package ru.learnup.javaqa.learnupmvn.game;

public class Funcs {
    public static boolean isGreenLight = false;
    public static int MAX_SPEED = 10;

    public static int countLost(int[] speeds){
        int counter = 0;
        if (isGreenLight){
            return counter;
        } else {
            for (int i=0;  i < speeds.length; i++) {
                if (!isGreenLight && speeds[i] > MAX_SPEED){
                    counter++;
                }
            }
            return counter;
        }
    }

    public static int[] lostSpeedArr(int[] speeds){
        int[] lostArr = new int[countLost(speeds)];
        if (isGreenLight){
            return lostArr;
        } else {
            int jCounter = 0;
            for (int i = 0; i < lostArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (!isGreenLight && speeds[j] > MAX_SPEED) {
                        lostArr[i] = speeds[j];
                        break;
                    }
                }
            }
            return lostArr;
        }
    }

    public static int[] wonSpeedArr(int[] speeds){
        int[] wonArr = new int[speeds.length - countLost(speeds)];
        if (isGreenLight){
            return speeds;
        } else {
            int jCounter = 0;
            for (int i = 0; i < wonArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (!isGreenLight && speeds[j] <= MAX_SPEED) {
                        wonArr[i] = speeds[j];
                        break;
                    }
                }
            }
            return wonArr;
        }
    }

    public static String[] wonNameArr(String[] nameSpeeds){
        if (isGreenLight){
            String[] wonArr = new String[nameSpeeds.length];
            for (int i=0; i < nameSpeeds.length; i++){
                wonArr[i] = nameSpeeds[i].split(" ")[0];
            }
            return wonArr;
        } else {
            int counter = 0;
            for (int i = 0; i < nameSpeeds.length; i++) {
                if (!isGreenLight && Integer.parseInt(nameSpeeds[i].split(" ")[1]) <= MAX_SPEED) {
                    counter++;
                }
            }
            String[] wonArr = new String[counter];
            int jCounter = 0;
            for (int i = 0; i < wonArr.length; i++) {
                for (int j = jCounter; j < nameSpeeds.length; j++) {
                    jCounter++;
                    if (!isGreenLight && Integer.parseInt(nameSpeeds[j].split(" ")[1]) <= MAX_SPEED) {
                        wonArr[i] = nameSpeeds[j].split(" ")[0];
                        break;
                    }
                }
            }
            return wonArr;
        }
    }
}
