package ru.ama0.adventofcode.y2021.day17.domain;

import lombok.Value;

@Value
public class Target {

    int xFrom;
    int xTo;
    int yFrom; // upper one
    int yTo; // lower one

    public Target(int xFrom, int xTo, int yFrom, int yTo) {
        this.xFrom = xFrom;
        this.xTo = xTo;
        this.yFrom = yFrom;
        this.yTo = yTo;
    }

    boolean isHit(int x, int y) {
        return x >= xFrom && x <= xTo && y <= yFrom && y >= yTo;
    }

    boolean isMissed(int x, int y) {
        return x > xTo || y < yTo;
    }

}
