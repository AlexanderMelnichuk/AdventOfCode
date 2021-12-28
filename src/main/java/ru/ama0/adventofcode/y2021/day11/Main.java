package ru.ama0.adventofcode.y2021.day11;

import ru.ama0.adventofcode.y2021.day11.application.FlashCountCalculator;
import ru.ama0.adventofcode.y2021.day11.application.FlashSynchronizationCalculator;
import ru.ama0.adventofcode.y2021.day11.infrastructure.OctopusRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new OctopusRepositoryImpl();
        repository.init("/2021/input11.txt");
        var flashCountCalculator = new FlashCountCalculator(repository);

        var flashCount = flashCountCalculator.execute();
        System.out.println(flashCount);

        var flashSynchronizationCalculator = new FlashSynchronizationCalculator(repository);

        var flashSyncStep = flashSynchronizationCalculator.execute();
        System.out.println(flashSyncStep);
    }
}
