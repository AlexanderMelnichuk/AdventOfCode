package ru.ama0.adventofcode.y2021.day19.domain;

import com.google.common.collect.Sets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BeaconMatcher {

    public static final int REQUIRED_BEACON_MATCHES_COUNT = 12;

    @Nullable
    public ScannerRelation match(@Nonnull Scanner fromScanner, @Nonnull Scanner toScanner) {
        ScannerRelation relation;
        for (var rotor : TransformationUtil.ROTORS.values()) {
            relation = match(fromScanner, toScanner, rotor);
            if (relation != null) {
                return relation;
            }
        }
        return null;
    }

    @Nullable
    public ScannerRelation match(@Nonnull Scanner fromScanner, @Nonnull Scanner toScanner, @Nonnull Rotor rotor) {
        var fromBeacons = fromScanner.getBeacons().stream()
                .map(beacon -> rotor.getOperator().apply(beacon))
                .collect(Collectors.toSet());
        var fromBeaconsToCheck = fromBeacons.stream()
                .limit(fromBeacons.size() - REQUIRED_BEACON_MATCHES_COUNT + 1L)
                .collect(Collectors.toSet());
        var toBeacons = new HashSet<>(toScanner.getBeacons());
        for (var fromBeacon : fromBeaconsToCheck) {
            for (var toBeacon : toBeacons) {
                var shift = toBeacon.sub(fromBeacon);
                if (matches(fromBeacons, toBeacons, shift)) {
                    return new ScannerRelation(fromScanner, toScanner, rotor, shift);
                }
            }
        }
        return null;
    }

    private boolean matches(@Nonnull Set<Voxel> fromBeacons, @Nonnull Set<Voxel> toBeacons, @Nonnull Voxel shift) {
        var shiftedFromBeacons = fromBeacons.stream().map(voxel -> voxel.add(shift)).collect(Collectors.toSet());
        return Sets.intersection(shiftedFromBeacons, toBeacons).size() >= REQUIRED_BEACON_MATCHES_COUNT;
    }

}
