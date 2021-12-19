package ru.ama0.adventofcode.y2021.day19.domain;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class TransformationUtilTest {

    @Test
    void checkRotorsForDuplicates() {
        var voxel = new Voxel(1, 2, 3);
        var rotatedVoxels = TransformationUtil.ROTORS.values().stream()
                .map(rotor -> rotor.getOperator().apply(voxel))
                .collect(Collectors.toSet());

        assertThat(rotatedVoxels).hasSize(TransformationUtil.ROTORS.size());
    }

    @Test
    void checkRotorsForMirrors() {
        var voxel = new Voxel(1, 2, 3);
        var rotatedVoxels = TransformationUtil.ROTORS.values().stream()
                .map(rotor -> rotor.getOperator().apply(voxel))
                .collect(Collectors.toSet());

        var mirrorVoxels = Set.of(
                new Voxel(-1, 2, 3),
                new Voxel(1, -2, 3),
                new Voxel(1, 2, -3));
        var rotatedMirrorVoxels = TransformationUtil.ROTORS.values().stream()
                .flatMap(rotor -> mirrorVoxels.stream().map(rotor.getOperator()))
                .collect(Collectors.toSet());

        assertThat(Sets.intersection(rotatedVoxels, rotatedMirrorVoxels)).isEmpty();
    }

}