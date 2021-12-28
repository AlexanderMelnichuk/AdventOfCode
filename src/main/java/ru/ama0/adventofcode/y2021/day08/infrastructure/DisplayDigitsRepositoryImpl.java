package ru.ama0.adventofcode.y2021.day08.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day08.application.ports.DisplayDigitsRepository;
import ru.ama0.adventofcode.y2021.day08.application.DigitsRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayDigitsRepositoryImpl implements DisplayDigitsRepository {

    private List<DigitsRequest> data;

    public void init(String fileName) throws IOException {
        data = Io.readLines(fileName)
                .stream()
                .map(line -> line.split(" \\| "))
                .map((String[] lineParts) -> {
                    var dictionary = Arrays.stream(lineParts[0].split(" "))
                            .map(this::normalize)
                            .collect(Collectors.toList());
                    var requested = Arrays.stream(lineParts[1].split(" "))
                            .map(this::normalize)
                            .collect(Collectors.toList());
                    return new DigitsRequest(dictionary, requested);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<DigitsRequest> getAll() {
        return new ArrayList<>(data);
    }

    public String normalize(String encodedDigit) {
        var chars = encodedDigit.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
