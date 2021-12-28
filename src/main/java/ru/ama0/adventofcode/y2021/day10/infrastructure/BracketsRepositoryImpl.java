package ru.ama0.adventofcode.y2021.day10.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day10.application.interfaces.BracketsRepository;
import ru.ama0.adventofcode.y2021.day10.domain.BracketsChunk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BracketsRepositoryImpl implements BracketsRepository {

    private List<BracketsChunk> data;

    public void init(String fileName) throws IOException {
        data = Io.readLines(fileName)
        .stream()
        .map(BracketsChunk::new)
        .collect(Collectors.toList());
    }

    @Override
    public List<BracketsChunk> getAll() {
        return new ArrayList<>(data);
    }

}
