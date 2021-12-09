package ru.ama0.adventofcode.y2021.day09.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day09.application.ports.HeightsRepository;
import ru.ama0.adventofcode.y2021.day09.domain.Basin;
import ru.ama0.adventofcode.y2021.day09.domain.BasinFiller;

import java.util.Comparator;

@RequiredArgsConstructor
public class BasinsCalculator {

    public static final int NUMBER_OF_BASINS_TO_RETURN = 3;

    private final HeightsRepository repository;

    public long execute() {
        var basinFiller = new BasinFiller(repository.getHeights());
        var basins = basinFiller.calcBasins();
        return basins.values().stream()
                .sorted(Comparator.comparing((Basin basin) -> basin.getPoints().size()).reversed())
                .limit(NUMBER_OF_BASINS_TO_RETURN)
                .peek(basin -> System.out.printf("DEBUG: id:%d, size:%d%n", basin.getId(), basin.getPoints().size()))
                .map(basin -> basin.getPoints().size())
                .reduce((a, b) -> a * b)
                .orElseThrow();
    }

}
