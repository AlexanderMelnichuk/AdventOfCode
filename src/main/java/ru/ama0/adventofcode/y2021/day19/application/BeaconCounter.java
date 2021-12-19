package ru.ama0.adventofcode.y2021.day19.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day19.domain.BeaconMapCalculator;

@RequiredArgsConstructor
public class BeaconCounter {

    private final BeaconMapCalculator beaconMapCalculator;

    public int execute() {
        return beaconMapCalculator.mapBeacons().size();
    }

}
