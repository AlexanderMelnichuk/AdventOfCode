package ru.ama0.adventofcode.y2021.day13.domain;

import lombok.Value;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.List;
import java.util.Set;

@Value
public class PointsFoldsRequest {

    Set<Point> points;
    List<FoldLine> foldLines;

}
