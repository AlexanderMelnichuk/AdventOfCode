package ru.ama0.adventofcode.y2021.day13.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day13.application.ports.PointsRepository;
import ru.ama0.adventofcode.y2021.day13.domain.PointSheet;

@RequiredArgsConstructor
public class FirstFoldPointsCounter {

    private final PointsRepository repository;

    public long execute() {
        var data = repository.getPointsFoldsRequest();
        var pointSheet = new PointSheet(data.getPoints());
        var firstFold = data.getFoldLines().get(0);
        pointSheet.fold(firstFold);
        return pointSheet.getPoints().size();
    }


}
