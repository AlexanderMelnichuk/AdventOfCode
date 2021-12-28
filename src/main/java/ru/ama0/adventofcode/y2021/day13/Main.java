package ru.ama0.adventofcode.y2021.day13;

import ru.ama0.adventofcode.y2021.day13.application.SheetFolder;
import ru.ama0.adventofcode.y2021.day13.infrastructure.console.PointSheetFoldController;
import ru.ama0.adventofcode.y2021.day13.infrastructure.console.PointsPresenterImpl;
import ru.ama0.adventofcode.y2021.day13.infrastructure.persist.PointsRepositoryImpl;
import ru.ama0.adventofcode.y2021.day13.application.FirstFoldPointsCounter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var repository = new PointsRepositoryImpl();
        repository.init("/2021/input13.txt");
        var oneTimeFoldPointsCounter = new FirstFoldPointsCounter(repository);

        var oneTimeFoldPointsCount = oneTimeFoldPointsCounter.execute();
        System.out.println(oneTimeFoldPointsCount);

        var pointsPresenter = new PointsPresenterImpl();
        var sheetFolder = new SheetFolder(repository);
        var pointSheetFoldController = new PointSheetFoldController(pointsPresenter, sheetFolder);

        pointSheetFoldController.foldSheet();
    }
}
