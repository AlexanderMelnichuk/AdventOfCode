package ru.ama0.adventofcode.y2021.day07.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day07.application.ports.CrabPositionsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomeRepositoryImpl implements CrabPositionsRepository {

    private List<Integer> positions;

    public void init(String fileName) throws IOException {
        positions = Arrays.stream(Io.readLines(fileName)
                .get(0)
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getAll() {
        return new ArrayList<>(positions);
    }
}
