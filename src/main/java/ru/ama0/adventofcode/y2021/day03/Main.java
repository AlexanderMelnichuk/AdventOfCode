package ru.ama0.adventofcode.y2021.day03;

import ru.ama0.adventofcode.y2021.day03.application.PowerConsumptionCalculator;
import ru.ama0.adventofcode.y2021.day03.application.RatingsCalculator;
import ru.ama0.adventofcode.y2021.day03.infrastructure.InputDataRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var repository = new InputDataRepositoryImpl("/2021/input03.txt");
        repository.init();

        var powerConsumptionCalculator = new PowerConsumptionCalculator(repository);
        var powerConsumption = powerConsumptionCalculator.execute();
        System.out.println(powerConsumption);

        var ratingsCalculator = new RatingsCalculator(repository);
        var co2ScrubberRating = ratingsCalculator.calculateCo2ScrubberRating();
        var oxygenGeneratorRating = ratingsCalculator.calculateOxygenGeneratorRating();
        System.out.println(co2ScrubberRating * oxygenGeneratorRating);

    }

}
