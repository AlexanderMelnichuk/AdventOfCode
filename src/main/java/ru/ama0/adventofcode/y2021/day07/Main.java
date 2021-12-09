package ru.ama0.adventofcode.y2021.day07;

import ru.ama0.adventofcode.y2021.day07.application.FuelConsumptionType;
import ru.ama0.adventofcode.y2021.day07.application.FuelConsumptionCalculator;
import ru.ama0.adventofcode.y2021.day07.infrastructure.SomeRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new SomeRepositoryImpl();
        repository.init("/2021/input07.txt");
        var interactor = new FuelConsumptionCalculator(repository);

        var linearCalc = interactor.execute(FuelConsumptionType.LINEAR);
        System.out.println(linearCalc);

        var progressiveCalc = interactor.execute(FuelConsumptionType.PROGRESSIVE);
        System.out.println(progressiveCalc);
    }
}
