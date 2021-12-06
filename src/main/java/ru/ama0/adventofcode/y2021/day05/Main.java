package ru.ama0.adventofcode.y2021.day05;

import ru.ama0.adventofcode.y2021.day05.application.OverlapsCounter;
import ru.ama0.adventofcode.y2021.day05.infrastructure.LineRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var repository = new LineRepositoryImpl();
        repository.init("/2021/input05.txt");
        var overlapsCounter = new OverlapsCounter(repository);
        var allLinesOverlapCount = overlapsCounter.execute(true);
        var hvLinesOverlapCount = overlapsCounter.execute(false);
        System.out.println(hvLinesOverlapCount);
        System.out.println(allLinesOverlapCount);
    }

}
