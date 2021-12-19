package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.Data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class BeaconMapNode {

    private final Scanner scanner;

    private final BeaconMapNode parent;

    private final ScannerRelation scannerRelation;

    private Collection<BeaconMapNode> children = new ArrayList<>();

    private Set<Voxel> beacons = new HashSet<>();

    private Voxel globalShift;

    public BeaconMapNode(@Nonnull Scanner scanner, @Nullable BeaconMapNode parent, @Nullable ScannerRelation relation) {
        this.scanner = scanner;
        this.parent = parent;
        this.scannerRelation = relation;
    }

    @Override
    public String toString() {
        return "BeaconMapNode{" +
                "scannerId='" + scanner.getId() + '\'' +
                ", parent=" + ((parent == null) ? "null" : parent.getScanner().getId()) +
                ", children=" + children.stream().map(node -> node.getScanner().getId()).collect(Collectors.toList()) +
                ", scannerRelation=" + scannerRelation +
                ", beacons=" + beacons +
                "}\n";
    }
}
