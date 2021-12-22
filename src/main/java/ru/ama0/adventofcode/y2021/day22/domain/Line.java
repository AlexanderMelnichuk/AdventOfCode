package ru.ama0.adventofcode.y2021.day22.domain;

import lombok.Value;

@Value
public class Line {
    int from;
    int to;

    boolean contains(int value) {
        return value >= from && value <= to;
    }
}
