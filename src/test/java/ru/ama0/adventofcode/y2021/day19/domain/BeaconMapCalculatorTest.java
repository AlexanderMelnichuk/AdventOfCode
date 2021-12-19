package ru.ama0.adventofcode.y2021.day19.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day19.infrastructure.ScannerBeaconsRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BeaconMapCalculatorTest {

    private ScannerBeaconsRepositoryImpl repository;
    private BeaconMapCalculator beaconMapCalculator;

    @BeforeEach
    void setUp() throws IOException {
        repository = new ScannerBeaconsRepositoryImpl();
        repository.init("/2021/input19test.txt");

        beaconMapCalculator = new BeaconMapCalculator(repository.getScanners());
    }

    @Test
    void findRelations_valid_valid() {
        assertThat(beaconMapCalculator.getBeaconMapNodes().size()).isNotZero();
        System.out.println(beaconMapCalculator.getBeaconMapNodes());
    }

    @Test
    void mapBeacons_valid_valid() {
        var rootNode = beaconMapCalculator.getBeaconMapNodes().get(BeaconMapCalculator.ID_ZERO);

        var beacons = beaconMapCalculator.mapBeacons(rootNode);

        assertThat(beacons.size()).isNotZero();
        assertThat(beacons.size()).isEqualTo(79);
        System.out.println(beacons);
    }
}