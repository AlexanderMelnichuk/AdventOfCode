package ru.ama0.adventofcode.y2021.day09.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day09.application.ports.HeightsRepository;
import ru.ama0.adventofcode.y2021.day09.domain.Heights;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HeightsRepositoryImpl implements HeightsRepository {

    private int[][] data;

    public void init(String fileName) throws IOException {
        var originalData = Io.readLines(fileName)
                .stream()
                .map(String::chars)
                .map((IntStream ints) -> ints.map(x -> x - '0').toArray())
                .toArray(int[][]::new);
        var borderValue = 9;
        var borderedData = new int[originalData.length + 2][originalData[0].length + 2];

        Arrays.fill(borderedData[0], borderValue);
        for (int origRow = 0; origRow < originalData.length; origRow++) {
            borderedData[origRow + 1] = new int[originalData[0].length + 2];
            borderedData[origRow + 1][0] = borderValue;
            borderedData[origRow + 1][originalData[0].length + 1] = borderValue;
            System.arraycopy(originalData[origRow], 0, borderedData[origRow + 1], 1, originalData[0].length);
        }
        Arrays.fill(borderedData[borderedData.length - 1], borderValue);

        data = borderedData;
    }

    /**
     * @return new Heights object with cloned data
     */
    @Override
    public Heights getHeights() {
        return new Heights(Arrays.copyOf(data, data.length));
    }

}
