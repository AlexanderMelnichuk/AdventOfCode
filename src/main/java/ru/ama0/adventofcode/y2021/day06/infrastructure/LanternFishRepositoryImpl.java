package ru.ama0.adventofcode.y2021.day06.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day06.application.interfaces.LanternFishRepository;

import java.io.IOException;
import java.util.Arrays;

public class LanternFishRepositoryImpl implements LanternFishRepository {

    private long[] counts;

    public void init(String filename) throws IOException {
        var strings = Io.readLines(filename);

        var fish = Arrays.stream(strings.get(0).split(","))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        counts = new long[9];
        Arrays.fill(counts, 0L);
        Arrays.stream(fish).forEach(elem -> counts[elem]++);
    }

    public long[] retrieveCounts() {
        return Arrays.copyOf(counts, 9);
    }

}
