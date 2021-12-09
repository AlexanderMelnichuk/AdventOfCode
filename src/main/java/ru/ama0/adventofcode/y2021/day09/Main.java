package ru.ama0.adventofcode.y2021.day09;

import ru.ama0.adventofcode.y2021.day09.application.BasinsCalculator;
import ru.ama0.adventofcode.y2021.day09.application.LowPointsRiskCalculator;
import ru.ama0.adventofcode.y2021.day09.infrastructure.HeightsRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new HeightsRepositoryImpl();
        repository.init("/2021/input09.txt");
        var lowPointsRiskCalculator = new LowPointsRiskCalculator(repository);

        var riskLevelSum = lowPointsRiskCalculator.execute();
        System.out.println(riskLevelSum);

        var basinCalculator = new BasinsCalculator(repository);
        var basinSizesMultiplied = basinCalculator.execute();
        System.out.println(basinSizesMultiplied);
    }
}
