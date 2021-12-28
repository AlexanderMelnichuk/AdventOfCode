package ru.ama0.adventofcode.y2021.day12.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day12.application.ports.CaveRepository;
import ru.ama0.adventofcode.y2021.day12.domain.CaveTraverser;

import java.util.List;

@RequiredArgsConstructor
public class CavePathsCounter {

    private static final String START_CAVE_NAME = "start";
    private static final String END_CAVE_NAME = "end";

    private final CaveRepository repository;

    public List<List<String>> execute(byte smallCaveMaxVisits) {
        var caves = repository.getAll();

        var caveTraverser = new CaveTraverser(caves, START_CAVE_NAME, END_CAVE_NAME, smallCaveMaxVisits);

        return caveTraverser.countPaths(START_CAVE_NAME);
    }

}
