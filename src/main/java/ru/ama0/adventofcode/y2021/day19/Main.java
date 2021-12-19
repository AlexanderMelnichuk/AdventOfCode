package ru.ama0.adventofcode.y2021.day19;

import ru.ama0.adventofcode.y2021.day19.application.BeaconCounter;
import ru.ama0.adventofcode.y2021.day19.application.MaxScannersManhattanDistanceCalculator;
import ru.ama0.adventofcode.y2021.day19.domain.BeaconMapCalculator;
import ru.ama0.adventofcode.y2021.day19.infrastructure.ScannerBeaconsRepositoryImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var repository = new ScannerBeaconsRepositoryImpl();
        repository.init("/2021/input19.txt");
        var beaconMapCalculator = new BeaconMapCalculator(repository.getScanners());

        var beaconCounter = new BeaconCounter(beaconMapCalculator);
        var beaconCount = beaconCounter.execute();
        System.out.println(beaconCount);

        var scannersManhattanDistanceCalculator = new MaxScannersManhattanDistanceCalculator(beaconMapCalculator);
        var maxManhattanDistance = scannersManhattanDistanceCalculator.execute();
        System.out.println(maxManhattanDistance);
    }

}
