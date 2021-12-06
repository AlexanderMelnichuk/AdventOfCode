package ru.ama0.adventofcode.y2021.day05.infrastructure;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day05.application.interfaces.LineRepository;
import ru.ama0.adventofcode.y2021.day05.domain.Line;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LineRepositoryImpl implements LineRepository {

    private List<Line> lines;

    @Override
    public void init(String fileName) throws IOException {
        var strings = Io.readLines(fileName);
        var pattern = Pattern.compile("(?<colFrom>\\d+),(?<rowFrom>\\d+) -> (?<colTo>\\d+),(?<rowTo>\\d+)");
        lines = strings.stream()
                .map(string -> {
                    var matcher = pattern.matcher(string);
                    if (!matcher.matches()) {
                        throw new IllegalStateException(
                                String.format("String %s does not conform to 'x1,y1 -> x2,y2' format", string));
                    }
                    var rowFrom = Integer.parseInt(matcher.group("rowFrom"));
                    var rowTo = Integer.parseInt(matcher.group("rowTo"));
                    var colFrom = Integer.parseInt(matcher.group("colFrom"));
                    var colTo = Integer.parseInt(matcher.group("colTo"));
                    return new Line(new Point(rowFrom, colFrom), new Point(rowTo, colTo));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Line> getAllLines() {
        return new ArrayList<>(lines);
    }

}
