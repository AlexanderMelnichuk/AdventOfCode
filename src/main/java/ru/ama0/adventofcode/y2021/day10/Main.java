package ru.ama0.adventofcode.y2021.day10;

import ru.ama0.adventofcode.y2021.day10.application.BracketCompletionScoreCalculator;
import ru.ama0.adventofcode.y2021.day10.application.BracketSyntaxErrorScoreCalculator;
import ru.ama0.adventofcode.y2021.day10.infrastructure.BracketsRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new BracketsRepositoryImpl();
        repository.init("/2021/input10.txt");
        var errorScoreCalculator = new BracketSyntaxErrorScoreCalculator(repository);

        var errorScore = errorScoreCalculator.execute();
        System.out.println(errorScore);

        var completionScoreCalculator = new BracketCompletionScoreCalculator(repository);
        var completionScore = completionScoreCalculator.execute();

        System.out.println(completionScore);
    }
}
