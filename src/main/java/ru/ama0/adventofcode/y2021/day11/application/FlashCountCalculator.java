package ru.ama0.adventofcode.y2021.day11.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day11.application.interfaces.OctopusRepository;

@RequiredArgsConstructor
public class FlashCountCalculator {

    private final OctopusRepository repository;

    public long execute() {
        var octopusField = repository.getOctopusField();
        var flashCount = 0L;
        for (int i = 0; i < 100; i++) {
            octopusField.step();
            flashCount += octopusField.getLastStepFlashCount();
        }
        return flashCount;
    }

}
