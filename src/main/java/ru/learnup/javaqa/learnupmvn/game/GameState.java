package ru.learnup.javaqa.learnupmvn.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameState {
    protected boolean isGreenLight;

    public int countLostSpeeds(int[] speeds){
        int counter = 0;
        if (!isGreenLight) {
            for (int speed : speeds) {
                if (speed > 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int[] lostSpeedArr(int[] speeds){
        int[] lostArr = new int[countLostSpeeds(speeds)];
        if (!isGreenLight) {
            int jCounter = 0;
            for (int i = 0; i < lostArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (speeds[j] > 0) {
                        lostArr[i] = speeds[j];
                        break;
                    }
                }
            }
        }
        return lostArr;
    }

    public int[] wonSpeedArr(int[] speeds){
        int[] wonArr = new int[speeds.length - countLostSpeeds(speeds)];
        if (isGreenLight){
            return speeds;
        } else {
            int jCounter = 0;
            for (int i = 0; i < wonArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (speeds[j] <= 0) {
                        wonArr[i] = speeds[j];
                        break;
                    }
                }
            }
            return wonArr;
        }
    }

    protected int countLostNames(String[] nameSpeeds){
        int counter = 0;
        if (!isGreenLight) {
            for (String nameSpeed : nameSpeeds) {
                if (Integer.parseInt(nameSpeed.split(" +")[1]) > 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public String[] wonNameArr(String[] nameSpeeds){
        String[] wonArr;
        if (isGreenLight){
            wonArr = new String[nameSpeeds.length];
            for (int i=0; i < nameSpeeds.length; i++){
                wonArr[i] = nameSpeeds[i].split(" +")[0];
            }
        } else {
            wonArr = new String[nameSpeeds.length - countLostNames(nameSpeeds)];
            int jCounter = 0;
            for (int i = 0; i < wonArr.length; i++) {
                for (int j = jCounter; j < nameSpeeds.length; j++) {
                    jCounter++;
                    if (Integer.parseInt(nameSpeeds[j].split(" +")[1]) <= 0) {
                        wonArr[i] = nameSpeeds[j].split(" +")[0];
                        break;
                    }
                }
            }
        }
        return wonArr;
    }

    protected boolean isFailed(int speed){
        if (!isGreenLight){
            return speed > 0;
        }
        return false;
    }
}
