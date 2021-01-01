package ru.ama0.adventofcode.day24;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Pair<T> {
    private final T x;
    private final T y;

    public Pair(T x, T y) {
        this.x = x;
        this.y = y;
    }
}
