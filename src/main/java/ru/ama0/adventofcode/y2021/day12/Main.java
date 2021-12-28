package ru.ama0.adventofcode.y2021.day12;

import ru.ama0.adventofcode.y2021.day12.application.CavePathsCounter;
import ru.ama0.adventofcode.y2021.day12.infrastructure.CaveRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var repository = new CaveRepositoryImpl();
        repository.init("/2021/input12.txt");
        var cavePathsCounter = new CavePathsCounter(repository);

        var paths = cavePathsCounter.execute((byte) 1);
        System.out.println(paths.size());

        var maxTwoVisitsPaths = cavePathsCounter.execute((byte) 2);
        System.out.println(maxTwoVisitsPaths.size());
    }

}
