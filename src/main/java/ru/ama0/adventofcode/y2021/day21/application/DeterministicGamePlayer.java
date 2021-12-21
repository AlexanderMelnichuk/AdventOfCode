package ru.ama0.adventofcode.y2021.day21.application;

import ru.ama0.adventofcode.y2021.day21.domain.dicegame.DeterministicDice;
import ru.ama0.adventofcode.y2021.day21.domain.dicegame.DiceGame;
import ru.ama0.adventofcode.y2021.day21.domain.dicegame.Player;

import java.util.List;

public class DeterministicGamePlayer {

    public int execute(List<Player> players) {
        var diceGame = new DiceGame(players, new DeterministicDice(), 1000);
        diceGame.newGame();
        diceGame.play();
        return diceGame.getRollCount() * diceGame.getCurrentPlayer().getScore();
    }

}
