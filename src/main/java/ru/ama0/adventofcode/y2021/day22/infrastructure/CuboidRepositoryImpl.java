package ru.ama0.adventofcode.y2021.day22.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day22.application.ports.CuboidRepository;
import ru.ama0.adventofcode.y2021.day22.domain.Cuboid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CuboidRepositoryImpl implements CuboidRepository {

    private final Pattern PATTERN = Pattern.compile("(?<switch>(on|off)) " +
            "x=(?<xFrom>-?\\d+)\\.\\.(?<xTo>-?\\d+)," +
            "y=(?<yFrom>-?\\d+)\\.\\.(?<yTo>-?\\d+)," +
            "z=(?<zFrom>-?\\d+)\\.\\.(?<zTo>-?\\d+)");

    private List<Cuboid> cuboids;

    public void init(String filename) throws IOException {
        cuboids = Io.readLines(filename).stream()
                .map(line -> {
                    var matcher = PATTERN.matcher(line);
                    if (!matcher.matches()) {
                         throw new IllegalArgumentException(String.format("Invalid line: %s", line));
                    }
                    var on = "on".equals(matcher.group("switch"));
                    var xFrom = Integer.parseInt(matcher.group("xFrom"));
                    var xTo = Integer.parseInt(matcher.group("xTo"));
                    var yFrom = Integer.parseInt(matcher.group("yFrom"));
                    var yTo = Integer.parseInt(matcher.group("yTo"));
                    var zFrom = Integer.parseInt(matcher.group("zFrom"));
                    var zTo = Integer.parseInt(matcher.group("zTo"));
                    return new Cuboid(on, xFrom, xTo, yFrom, yTo, zFrom, zTo);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Cuboid> getCuboids() {
        return new ArrayList<>(cuboids);
    }

}
