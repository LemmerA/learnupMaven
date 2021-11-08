package ru.learnup.javaqa.learnupmvn.game;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameManager {
    private GameState gameState;

    public int countRounds (int[] playerSpeeds){
        for (int i=0; i < playerSpeeds.length; i++){
            if (gameState.isFailed(playerSpeeds[i])){
                return i;
            }
        }
        return playerSpeeds.length;
    }
}
