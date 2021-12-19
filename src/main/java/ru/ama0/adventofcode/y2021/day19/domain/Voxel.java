package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.Value;

@Value
public class Voxel {
    int x;
    int y;
    int z;

    public Voxel add(Voxel another) {
        return new Voxel(x + another.getX(), y + another.getY(), z + another.getZ());
    }

    public Voxel sub(Voxel another) {
        return new Voxel(x - another.getX(), y - another.getY(), z - another.getZ());
    }

    public Voxel rotate(Rotor rotor) {
        return rotor.getOperator().apply(this);
    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", x, y, z);
    }
}
