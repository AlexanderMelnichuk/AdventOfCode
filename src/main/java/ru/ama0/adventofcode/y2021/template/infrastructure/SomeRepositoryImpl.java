package ru.ama0.adventofcode.y2021.template.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.template.application.ports.SomeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeRepositoryImpl implements SomeRepository {

    private List<String> data;

    public void init(String fileName) throws IOException {
        data = Io.readLines(fileName);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(data);
    }
}
