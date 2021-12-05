package ru.ama0.adventofcode.y2020.day16;

import com.google.common.collect.Range;
import lombok.Data;

@Data
public class Constraint {
    private final String name;
    private final Range<Integer> firstRange;
    private final Range<Integer> secondRange;

    public Constraint(String name, Range<Integer> firstRange,
            Range<Integer> secondRange) {
        this.name = name;
        this.firstRange = firstRange;
        this.secondRange = secondRange;
    }

    public boolean matches(Integer number) {
        return firstRange.contains(number) || secondRange.contains(number);
    }
}
