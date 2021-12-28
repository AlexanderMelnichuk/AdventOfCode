package ru.ama0.adventofcode.y2021.day14;

import ru.ama0.adventofcode.y2021.day14.application.MostMinusLeastElementPairsCounter;
import ru.ama0.adventofcode.y2021.day14.infrastructure.PolymerDataRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new PolymerDataRepositoryImpl();
        repository.init("/2021/input14.txt");
        var mostMinusLeastElementPairsCounter = new MostMinusLeastElementPairsCounter(repository);

        var result = mostMinusLeastElementPairsCounter.execute(40);

        System.out.println(result);
    }
}
