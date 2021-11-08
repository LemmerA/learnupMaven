package ru.learnup.javaqa.learnupmvn.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeedGameState extends GameState{
    private int maxSpeed;

    public SpeedGameState(boolean isGreenLight, int maxSpeed){
        super(isGreenLight);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int countLostSpeeds(int[] speeds){
        int counter = 0;
        if (!isGreenLight) {
            for (int speed : speeds) {
                if (speed > maxSpeed) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int[] lostSpeedArr(int[] speeds){
        int[] lostArr = new int[countLostSpeeds(speeds)];
        if (!isGreenLight) {
            int jCounter = 0;
            for (int i = 0; i < lostArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (speeds[j] > maxSpeed) {
                        lostArr[i] = speeds[j];
                        break;
                    }
                }
            }
        }
        return lostArr;
    }


    @Override
    public int[] wonSpeedArr(int[] speeds){
        int[] wonArr = new int[speeds.length - countLostSpeeds(speeds)];
        if (isGreenLight){
            return speeds;
        } else {
            int jCounter = 0;
            for (int i = 0; i < wonArr.length; i++) {
                for (int j = jCounter; j < speeds.length; j++) {
                    jCounter++;
                    if (speeds[j] <= maxSpeed) {
                        wonArr[i] = speeds[j];
                        break;
                    }
                }
            }
            return wonArr;
        }
    }

    @Override
    protected int countLostNames(String[] nameSpeeds){
        int counter = 0;
        if (!isGreenLight) {
            for (String nameSpeed : nameSpeeds) {
                if (Integer.parseInt(nameSpeed.split(" +")[1]) > maxSpeed) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
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
                    if (Integer.parseInt(nameSpeeds[j].split(" +")[1]) <= maxSpeed) {
                        wonArr[i] = nameSpeeds[j].split(" +")[0];
                        break;
                    }
                }
            }
        }
        return wonArr;
    }

    @Override
    protected boolean isFailed(int speed){
        if (!isGreenLight){
            return speed > maxSpeed;
        }
        return false;
    }
}
