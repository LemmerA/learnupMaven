package ru.learnup.javaqa.learnupmvn.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FastPlayer extends ConstantPlayer{
    private int step;

    public FastPlayer(int speed, int step){
        super(speed);
        this.step = step;
    }

    @Override
    public int getSpeed(){
        return speed += step;
    }
}
