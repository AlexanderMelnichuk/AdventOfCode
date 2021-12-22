package ru.ama0.adventofcode.y2021.day22.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day22.application.ports.CuboidRepository;
import ru.ama0.adventofcode.y2021.day22.domain.Cuboid;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class SmallRegionCubeCalculator {

    private static final int AREA_SIZE = 101;
    private static final int HALF_SIZE = AREA_SIZE / 2;

    private final CuboidRepository repository;

    public long execute() {
        var cuboids = repository.getCuboids().stream()
                .filter(this::isInSmallRegion).collect(Collectors.toList());

        var matrix = new boolean[AREA_SIZE][AREA_SIZE][AREA_SIZE];
        cuboids.forEach(cuboid -> {
            for (int x = cuboid.getXFrom() + HALF_SIZE; x <= cuboid.getXTo() + HALF_SIZE; x++) {
                for (int y = cuboid.getYFrom() + HALF_SIZE; y <= cuboid.getYTo() + HALF_SIZE; y++) {
                    for (int z = cuboid.getZFrom() + HALF_SIZE; z <= cuboid.getZTo() + HALF_SIZE; z++) {
                        matrix[x][y][z] = cuboid.isOn();
                    }
                }
            }
        });
        var count = 0L;
        for (int x = 0; x < AREA_SIZE; x++) {
            for (int y = 0; y < AREA_SIZE; y++) {
                for (int z = 0; z < AREA_SIZE; z++) {
                    if (matrix[x][y][z]) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    private boolean isInSmallRegion(Cuboid cuboid) {
        return Stream.of(cuboid.getXFrom(), cuboid.getXTo(),
                        cuboid.getYFrom(), cuboid.getYTo(),
                        cuboid.getZFrom(), cuboid.getZTo())
                .allMatch(coord -> coord >= -HALF_SIZE && coord <= HALF_SIZE);
    }

}
