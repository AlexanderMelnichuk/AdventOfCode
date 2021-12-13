package ru.ama0.adventofcode.y2021.day13.infrastructure.console;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day13.application.SheetFolder;

@RequiredArgsConstructor
public class PointSheetFoldController {

    private final PointsPresenter presenter;
    private final SheetFolder folder;

    public void foldSheet() {
        System.out.println(presenter.toString(folder.execute()));
    }

}
