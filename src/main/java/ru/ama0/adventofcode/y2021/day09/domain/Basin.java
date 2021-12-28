package ru.ama0.adventofcode.y2021.day09.domain;

import lombok.Value;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.HashSet;
import java.util.Set;

@Value
public class Basin {

    int id;
    Set<Point> points = new HashSet<>();

}
