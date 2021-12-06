package ru.ama0.adventofcode.y2021.day04;

import ru.ama0.adventofcode.y2021.day04.application.WinnerCalculator;
import ru.ama0.adventofcode.y2021.day04.application.LoserCalculator;
import ru.ama0.adventofcode.y2021.day04.infrastructure.InputDataRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var winnerCalculator = new WinnerCalculator(new InputDataRepositoryImpl());
        var winnerScore = winnerCalculator.execute();
        System.out.println("Winner score: " + winnerScore);

        var loserCalculator = new LoserCalculator(new InputDataRepositoryImpl());
        var loserScore = loserCalculator.execute();
        System.out.println("Loser score: " + loserScore);
    }
}
