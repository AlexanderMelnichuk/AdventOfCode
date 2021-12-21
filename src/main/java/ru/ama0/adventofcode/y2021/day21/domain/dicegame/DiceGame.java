package ru.ama0.adventofcode.y2021.day21.domain.dicegame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DiceGame {

    @Getter
    private final List<Player> players;
    @Getter
    private final Dice dice;
    @Getter
    private final int winningScore;

    @Getter
    private int rollCount;
    @Getter
    private Player currentPlayer;

    public void newGame() {
        rollCount = 0;
        players.forEach(Player::resetScore);
        currentPlayer = players.get(0);
    }

    public void play() {
        do {
            turn();
            nextPlayer();
        } while (!isFinished());
    }

    public Player nextPlayer() {
        var playerIndex = players.indexOf(currentPlayer) + 1;
        if (playerIndex >= players.size()) {
            playerIndex = 0;
        }
        currentPlayer = players.get(playerIndex);
        return currentPlayer;
    }

    public void turn() {
        var diceSum = dice.roll() + dice.roll() + dice.roll();
        rollCount += 3;
        var position = (currentPlayer.getPosition() + diceSum - 1) % 10 + 1;
        currentPlayer.setPosition(position);
        currentPlayer.increaseScore(position);
    }

    public boolean isWinner(Player player) {
        return player.getScore() >= winningScore;
    }

    public boolean isFinished() {
        return players.stream().anyMatch(this::isWinner);
    }

}
