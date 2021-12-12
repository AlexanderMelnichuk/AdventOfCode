package ru.ama0.adventofcode.y2021.day12.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day12.application.ports.CaveRepository;
import ru.ama0.adventofcode.y2021.day12.domain.Cave;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CaveRepositoryImpl implements CaveRepository {

    private static final String CAVE_NAME_SEPARATOR = "-";

    private Map<String, Cave> caves;

    public void init(String fileName) throws IOException {
        caves = new HashMap<>();
        Io.readLines(fileName)
                .stream()
                .map(line -> line.split(CAVE_NAME_SEPARATOR))
                .forEach(names -> addCavesConnection(names[0], names[1]));
    }

    private void addCavesConnection(String from, String to) {
        var fromCave = caves.computeIfAbsent(from, Cave::new);
        var toCave = caves.computeIfAbsent(to, Cave::new);

        fromCave.addConnection(toCave);
        toCave.addConnection(fromCave);
    }

    @Override
    public Map<String, Cave> getAll() {
        return new HashMap<>(caves);
    }

}
