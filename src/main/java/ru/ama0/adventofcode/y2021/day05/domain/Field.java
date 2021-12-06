package ru.ama0.adventofcode.y2021.day05.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Field {

    private final int[][] points;
    private final int height;
    private final int width;

    public Field(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IndexOutOfBoundsException("Width and height must be positive numbers.");
        }
        this.height = height;
        this.width = width;
        points = new int[height][width];
    }

    public void addHvLine(Line line) {
        Objects.checkFromToIndex(line.getMinBound().getRow(), line.getMaxBound().getRow(), height);
        Objects.checkFromToIndex(line.getMinBound().getColumn(), line.getMaxBound().getColumn(), width);

        if (line.isHorizontal()) {
            for (int column = line.getMinBound().getColumn();
                    column <= line.getMaxBound().getColumn();
                    column++) {
                points[line.getFrom().getRow()][column]++;
            }
        } else if (line.isVertical()) {
            for (int row = line.getMinBound().getRow();
                    row <= line.getMaxBound().getRow();
                    row++) {
                points[row][line.getFrom().getColumn()]++;
            }
        }
    }

    public void addLine(Line line) {
        addHvLine(line);

        if (!line.isVertical() && !line.isHorizontal()) {
            var rowStep = line.getTo().getRow() - line.getFrom().getRow() > 0
                    ? 1
                    : -1;
            var columnStep = line.getTo().getColumn() - line.getFrom().getColumn() > 0
                    ? 1
                    : -1;
            var index = 0;
            int row;
            int column;
            do {
                row = line.getFrom().getRow() + index * rowStep;
                column = line.getFrom().getColumn() + index * columnStep;
                points[row][column]++;
            } while (line.getTo().getRow() != line.getFrom().getRow() + rowStep * index++);
        }
    }

    @Override
    public String toString() {
        return toString(0, height, 0, width);
    }

    public String toString(int rowFrom, int height, int colFrom, int width) {
        var rowTo = rowFrom + height;
        var colTo = colFrom + width;

        Objects.checkFromToIndex(rowFrom, rowTo, this.height);
        Objects.checkFromToIndex(colFrom, colTo, this.width);

        var sb = new StringBuilder("Field:\n");
        for (int row = rowFrom; row < rowTo; row++) {
            for (int column = colFrom; column < colTo; column++) {
                sb.append(String.format("%2d ", points[row][column]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
