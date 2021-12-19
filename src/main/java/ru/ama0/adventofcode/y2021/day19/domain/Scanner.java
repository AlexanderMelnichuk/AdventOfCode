package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.Value;

import java.util.ArrayList;
import java.util.Collection;

@Value
public class Scanner {

    String id;
    Collection<Voxel> beacons;

    public Collection<Voxel> getBeacons() {
        return new ArrayList<>(beacons);
    }
}
