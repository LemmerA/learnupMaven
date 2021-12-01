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

    private int[] playerSpeeds (Movable player, int rounds){
        if (rounds <= 0){
            return new int[0];
        }

        int[] playerSpeeds = new int[rounds];
        for (int i=0; i < rounds; i++){
            playerSpeeds[i] = player.getSpeed();
        }
        return playerSpeeds;
    }

    public int loser(Movable p1, Movable p2, int rounds){
        if (rounds <= 0){
            return 0;
        }

        int[] playerSpeedsP1 = playerSpeeds(p1, rounds);
        int[] playerSpeedsP2 = playerSpeeds(p2, rounds);

        int lostRoundP1 = countRounds(playerSpeedsP1);
        int lostRoundP2 = countRounds(playerSpeedsP2);

        if (lostRoundP1 > lostRoundP2) {
            return 1;
        } else if (lostRoundP1 < lostRoundP2) {
            return -1;
        } else {
            return 0;
        }
    }
}
