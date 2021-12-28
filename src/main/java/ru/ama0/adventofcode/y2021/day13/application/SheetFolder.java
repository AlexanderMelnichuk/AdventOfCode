package ru.ama0.adventofcode.y2021.day13.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day13.application.ports.PointsRepository;
import ru.ama0.adventofcode.y2021.day13.domain.PointSheet;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.Set;

@RequiredArgsConstructor
public class SheetFolder {

    private final PointsRepository repository;

    public Set<Point> execute() {
        var data = repository.getPointsFoldsRequest();
        var pointSheet = new PointSheet(data.getPoints());
        data.getFoldLines().stream()
                .sequential()
                .forEach(pointSheet::fold);

        return pointSheet.getPoints();
    }
}
