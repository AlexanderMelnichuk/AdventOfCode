package ru.ama0.adventofcode.y2021.day21;

import ru.ama0.adventofcode.y2021.day21.application.DeterministicGamePlayer;
import ru.ama0.adventofcode.y2021.day21.application.DiracDiceGamePlayer;
import ru.ama0.adventofcode.y2021.day21.domain.dicegame.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeterministicGamePlayer deterministicGamePlayer = new DeterministicGamePlayer();
        var result = deterministicGamePlayer.execute(List.of(
                new Player("Player 1", 8),
                new Player("Player 2", 10)
        ));
        System.out.println(result);

        DiracDiceGamePlayer diracDiceGamePlayer = new DiracDiceGamePlayer();
        System.out.println(diracDiceGamePlayer.execute());
    }
}
