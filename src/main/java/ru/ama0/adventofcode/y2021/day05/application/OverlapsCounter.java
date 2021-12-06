package ru.ama0.adventofcode.y2021.day05.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day05.application.interfaces.LineRepository;
import ru.ama0.adventofcode.y2021.day05.domain.Field;

import java.util.Arrays;

@RequiredArgsConstructor
public class OverlapsCounter {

    private final LineRepository repository;

    public int execute(boolean includeDiagonalLines) {
        var lines = repository.getAllLines();
        var maxRow = lines.stream()
                .map(line -> line.getMaxBound().getRow())
                .max(Integer::compare)
                .orElse(0);
        var maxColumn = lines.stream()
                .map(line -> line.getMaxBound().getColumn())
                .max(Integer::compare)
                .orElse(0);
        var field = new Field(maxRow + 1, maxColumn + 1);

        if (includeDiagonalLines) {
            lines.forEach(field::addLine);
        } else {
            lines.forEach(field::addHvLine);
        }

        return (int) Arrays.stream(field.getPoints())
                .flatMapToInt(Arrays::stream)
                .filter(value -> value > 1)
                .count();
    }

}
