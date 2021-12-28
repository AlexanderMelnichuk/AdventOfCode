package ru.ama0.adventofcode.y2021.day09.domain;

import lombok.Getter;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class Heights {

    private final int[][] data;
    private final int colCount;
    private final int rowCount;

    public Heights(int[][] data) {
        this.data = data;
        this.rowCount = data.length;
        this.colCount = data[0].length;
    }

    public int getHeight(Point point) {
        requireValidPoint(point.getRow(), point.getColumn());
        return data[point.getRow()][point.getColumn()];
    }

    public Collection<Point> calcLowPoints() {
        var lowPoints = new ArrayList<Point>();
        for (int row = 1; row < rowCount - 1; row++) {
            for (int col = 1; col < colCount - 1; col++) {
                if (isLowPoint(row, col)) {
                    lowPoints.add(new Point(row, col));
                }
            }
        }
        return lowPoints;
    }

    public boolean isLowPoint(int row, int col) {
        requireValidPoint(row, col);
        return data[row][col] < data[row - 1][col] &&
                data[row][col] < data[row + 1][col] &&
                data[row][col] < data[row][col - 1] &&
                data[row][col] < data[row][col + 1];
    }

    private void requireValidPoint(int row, int col) {
        if (row <= 0 || row >= rowCount - 1 ||
                col <= 0 || col >= colCount - 1) {
            throw new IllegalArgumentException(String.format("Invalid point: (%d, %d)", row, col));
        }
    }

    @Nonnull
    public String toString() {
        return Arrays.stream(data)
                .map(row -> Arrays.toString(row) + "\n")
                .collect(Collectors.joining());
    }

}
