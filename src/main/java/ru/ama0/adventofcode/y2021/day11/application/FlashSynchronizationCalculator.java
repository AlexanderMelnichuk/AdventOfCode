package ru.ama0.adventofcode.y2021.day11.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day11.application.interfaces.OctopusRepository;

@RequiredArgsConstructor
public class FlashSynchronizationCalculator {

    private final OctopusRepository repository;

    public long execute() {
        var octopusField = repository.getOctopusField();
        var targetFlashCount = octopusField.getRowCount() * octopusField.getColCount();
        var step = 0L;
        do {
            step++;
            octopusField.step();
        } while (octopusField.getLastStepFlashCount() < targetFlashCount);
        return step;
    }

}
