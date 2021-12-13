package ru.ama0.adventofcode.y2021.day13.domain;

import lombok.Getter;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class PointSheet {

    public PointSheet(Set<Point> points) {
        this.points = points;
    }

    @Getter
    private Set<Point> points;

    private static final Map<Axis, BiFunction<Point, Integer, Point>> FOLD_FUNCTION =
            Map.of(Axis.X, (point, x) ->
                            point.getColumn() <= x
                                    ? point
                                    : new Point(point.getRow(), 2 * x - point.getColumn()),
                    Axis.Y, (point, y) ->
                            point.getRow() <= y
                                    ? point
                                    : new Point(2 * y - point.getRow(), point.getColumn()));

    public void fold(FoldLine foldLine) {
        var foldFunction = FOLD_FUNCTION.get(foldLine.getAxis());
        points = points.stream()
                .map(point -> foldFunction.apply(point, foldLine.getCoordinate()))
                .collect(Collectors.toSet());
    }

}
