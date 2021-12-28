package ru.ama0.adventofcode.y2021.day11.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day11.domain.OctopusField;
import ru.ama0.adventofcode.y2021.day11.application.interfaces.OctopusRepository;
import ru.ama0.adventofcode.y2021.sharedkernel.ArrayUtils;

import java.io.IOException;

public class OctopusRepositoryImpl implements OctopusRepository {

    private int[][] data;

    public void init(String fileName) throws IOException {
        data = Io.readLines(fileName).stream()
                .map(String::chars)
                .map(intStream -> intStream.map(x -> x - '0').toArray())
                .toArray(int[][]::new);
    }

    @Override
    public OctopusField getOctopusField() {
         return new OctopusField(ArrayUtils.clone2d(data));
    }
}
