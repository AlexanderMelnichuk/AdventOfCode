package ru.ama0.adventofcode.y2021.day22.domain;

import lombok.Value;

@Value
public class Rectangle {

    int xFrom;
    int xTo;
    int yFrom;
    int yTo;

    public Line getXLine() {
        return new Line(xFrom, xTo);
    }

    public Line getYLine() {
        return new Line(yFrom, yTo);
    }

}
