package ru.ama0.adventofcode.y2021.day19.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day19.infrastructure.ScannerBeaconsRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class BeaconMatcherTest {

    private ScannerBeaconsRepositoryImpl repository;
    private BeaconMatcher beaconMatcher;

    @BeforeEach
    void setUp() throws IOException {
        repository = new ScannerBeaconsRepositoryImpl();
        repository.init("/2021/input19test.txt");

        beaconMatcher = new BeaconMatcher();
    }

    @Test
    void match_correctRotor_success() {
        var scanner1 = repository.getScanners().get(1);
        var scanner0 = repository.getScanners().get(0);

        var scanner1to0Relation = beaconMatcher.match(scanner1, scanner0, TransformationUtil.ROTORS.get("NxYNz"));

        assertThat(scanner1to0Relation).isNotNull();
        assertThat(scanner1to0Relation.getRotor().getName()).isEqualTo("NxYNz");
        assertThat(scanner1to0Relation.getShift()).isEqualTo(new Voxel(68, -1246, -43));
    }

    @Test
    void match_unknownRotor_success() {
        var scanner1 = repository.getScanners().get(1);
        var scanner0 = repository.getScanners().get(0);

        var scanner1to0Relation = beaconMatcher.match(scanner1, scanner0);

        assertThat(scanner1to0Relation).isNotNull();
        assertThat(scanner1to0Relation.getRotor().getName()).isEqualTo("NxYNz");
        assertThat(scanner1to0Relation.getShift()).isEqualTo(new Voxel(68, -1246, -43));
    }


}