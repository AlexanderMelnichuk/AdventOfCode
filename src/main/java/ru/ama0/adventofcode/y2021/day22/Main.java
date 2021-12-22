package ru.ama0.adventofcode.y2021.day22;

import ru.ama0.adventofcode.y2021.day22.application.SmallRegionCubeCalculator;
import ru.ama0.adventofcode.y2021.day22.infrastructure.CuboidRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new CuboidRepositoryImpl();
        repository.init("/2021/input22.txt");
        var calculator = new SmallRegionCubeCalculator(repository);

        System.out.println(calculator.execute());
    }

}
