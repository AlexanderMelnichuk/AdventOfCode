package ru.ama0.adventofcode.y2021.day13.infrastructure.persist;

import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day13.application.ports.PointsRepository;
import ru.ama0.adventofcode.y2021.day13.domain.FoldLine;
import ru.ama0.adventofcode.y2021.day13.domain.Axis;
import ru.ama0.adventofcode.y2021.day13.domain.PointsFoldsRequest;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PointsRepositoryImpl implements PointsRepository {

    private static final Pattern FOLD_LINE_PATTERN = Pattern.compile("fold along (?<axis>[xy])=(?<coordinate>\\d+)");

    private Set<Point> points = null;
    private List<FoldLine> foldLines = null;

    public void init(String fileName) throws IOException {
        var lines = Io.readLines(fileName);
        points = lines.stream()
                .map(line -> line.split(","))
                .filter(parts -> parts.length > 1)
                .map(parts -> Arrays.stream(parts).mapToInt(Integer::parseInt).toArray())
                .map(intParts -> new Point(intParts[1], intParts[0]))
                .collect(Collectors.toSet());

        foldLines = lines.stream()
                .filter(FOLD_LINE_PATTERN.asMatchPredicate())
                .map(line -> {
                    var matcher = FOLD_LINE_PATTERN.matcher(line);
                    matcher.find();
                    var foldAxis = Axis.valueOf(matcher.group("axis").toUpperCase(Locale.ROOT));
                    var coordinate = Integer.parseInt(matcher.group("coordinate"));
                    return new FoldLine(foldAxis, coordinate);
                })
                .collect(Collectors.toList());
    }

    @Override
    public PointsFoldsRequest getPointsFoldsRequest() {
        var pointsCopy = new HashSet<>(this.points);
        var foldLinesCopy = new ArrayList<>(this.foldLines);

        return new PointsFoldsRequest(pointsCopy, foldLinesCopy);
    }
}
