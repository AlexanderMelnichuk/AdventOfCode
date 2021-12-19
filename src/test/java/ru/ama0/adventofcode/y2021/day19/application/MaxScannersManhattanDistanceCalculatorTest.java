package ru.ama0.adventofcode.y2021.day19.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day19.domain.BeaconMapCalculator;
import ru.ama0.adventofcode.y2021.day19.infrastructure.ScannerBeaconsRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MaxScannersManhattanDistanceCalculatorTest {

    private BeaconMapCalculator beaconMapCalculator;

    private MaxScannersManhattanDistanceCalculator calculator;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new ScannerBeaconsRepositoryImpl();
        repository.init("/2021/input19test.txt");

        beaconMapCalculator = new BeaconMapCalculator(repository.getScanners());
        calculator = new MaxScannersManhattanDistanceCalculator(beaconMapCalculator);
    }

    @Test
    void execute_valid_valid() {
        var maxManhattanDistance = calculator.execute();

        assertThat(maxManhattanDistance).isEqualTo(3621);
    }

}