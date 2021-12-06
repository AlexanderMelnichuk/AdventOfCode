package ru.ama0.adventofcode.y2021.day03.infrastructure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day03.application.interfaces.InputDataRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class InputDataRepositoryImpl implements InputDataRepository {

    private final String inputFileName;

    private List<Integer> numbers;
    private Integer digitCount;


    @Override
    public List<Integer> retrieveNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public void init() throws IOException {
        var lines = Io.readLines(inputFileName);

        digitCount = lines.get(0).length();
        numbers = lines.stream()
                .map(line -> Integer.parseInt(line, 2))
                .collect(Collectors.toList());
    }

}
