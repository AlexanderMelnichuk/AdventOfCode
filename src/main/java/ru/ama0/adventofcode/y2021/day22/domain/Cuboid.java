package ru.ama0.adventofcode.y2021.day22.domain;

import lombok.Value;

@Value
public class Cuboid {

    boolean on;
    int xFrom;
    int xTo;
    int yFrom;
    int yTo;
    int zFrom;
    int zTo;

    public Rectangle toRectangle() {
        return new Rectangle(xFrom, xTo, yFrom, yTo);
    }

    public Line getXLine() {
        return new Line(xFrom, xTo);
    }

    public Line getYLine() {
        return new Line(yFrom, yTo);
    }

    public Line getZLine() {
        return new Line(zFrom, zTo);
    }

}
