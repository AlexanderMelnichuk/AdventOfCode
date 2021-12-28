package ru.ama0.adventofcode.y2021.day09.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day09.application.ports.HeightsRepository;

@RequiredArgsConstructor
public class LowPointsRiskCalculator {

    private final HeightsRepository repository;

    public long execute() {
        var heights = repository.getHeights();

        return heights.calcLowPoints()
                .stream()
                .map(point -> heights.getHeight(point) + 1)
                .reduce(Integer::sum)
                .orElseThrow();
    }

}
