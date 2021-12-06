package ru.ama0.adventofcode.y2021.sharedkernel;

import lombok.Value;

@Value
public class Point {

    int row;
    int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", row, column);
    }
}
