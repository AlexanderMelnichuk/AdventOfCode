package ru.ama0.adventofcode.y2021.day05.domain;

import lombok.Getter;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

@Getter
public class Line {

    private final Point from;
    private final Point to;

    private final Point minBound;
    private final Point maxBound;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;

        minBound = new Point(Math.min(from.getRow(), to.getRow()), Math.min(from.getColumn(), to.getColumn()));
        maxBound = new Point(Math.max(from.getRow(), to.getRow()), Math.max(from.getColumn(), to.getColumn()));

        validate();
    }

    public boolean isHorizontal() {
        return getRowDiff() == 0;
    }

    public boolean isVertical() {
        return getColumnDiff() == 0;
    }

    public int getRowDiff() {
        return maxBound.getRow() - minBound.getRow();
    }

    public int getColumnDiff() {
        return maxBound.getColumn() - minBound.getColumn();
    }

    public void validate() {
        if (!(getRowDiff() == getColumnDiff() || getRowDiff() == 0 || getColumnDiff() == 0)) {
            throw new IllegalStateException("Line direction is not vertical, horizontal or diagonal");
        }
    }

}
