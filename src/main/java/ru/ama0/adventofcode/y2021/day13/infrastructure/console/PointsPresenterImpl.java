package ru.ama0.adventofcode.y2021.day13.infrastructure.console;

import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.Arrays;
import java.util.Set;

public class PointsPresenterImpl implements PointsPresenter {

    public String toString(Set<Point> points) {
        var maxX = points.stream().map(Point::getColumn).max(Integer::compareTo).orElse(0);
        var maxY = points.stream().map(Point::getRow).max(Integer::compareTo).orElse(0);
        var display = new char[maxY + 1][maxX + 1];
        for(var row: display) {
            Arrays.fill(row, ' ');
        }
        for (Point point : points) {
            display[point.getRow()][point.getColumn()] = '#';
        }
        var presentation = new StringBuilder();
        for (char[] row : display) {
            presentation.append(row).append("\n");
        }
        return presentation.toString();
    }

}
