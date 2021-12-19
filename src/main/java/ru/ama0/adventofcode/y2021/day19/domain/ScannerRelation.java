package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Relation of scanner coordinate systems
 * Transformation is:
 * 'to' scanner coordinates = 'from' scanner coordinates turned by rotor and then adjusted by shift.
 * Reverse transformation is:
 * 'from' scanner coordinates
 */
@Value
@RequiredArgsConstructor
public class ScannerRelation {

    Scanner fromScanner;
    Scanner toScanner;

    Rotor rotor;
    Voxel shift;

    public Voxel transform(Voxel voxel) {
        return voxel
                .rotate(rotor)
                .add(shift);
    }

    public Voxel reverseTransform(Voxel voxel) {
        return voxel
                .sub(shift)
                .rotate(TransformationUtil.REVERSE_ROTORS.get(rotor.getName()));
    }

    @Override
    public String toString() {
        return (fromScanner == null || toScanner == null)
                ? "ScannerRelation(empty)"
                : "ScannerRelation{" +
                "from=" + fromScanner.getId() +
                ", to=" + toScanner.getId() +
                ", rotor='" + rotor.getName() + '\'' +
                ", shift=" + shift +
                '}';
    }
}
