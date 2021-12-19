package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.Getter;

import javax.annotation.Nonnull;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BeaconMapCalculator {

    public static final String ID_ZERO = "0";

    private final BeaconMatcher beaconMatcher;

    @Getter
    @Nonnull
    private final Collection<Scanner> scanners;

    private final Scanner scanner0;

    private final Map<String, BeaconMapNode> beaconMapNodes;

    public final Collection<Voxel> beacons;

    @Nonnull
    public Map<String, BeaconMapNode> getBeaconMapNodes() {
        return Collections.unmodifiableMap(beaconMapNodes);
    }

    public BeaconMapCalculator(@Nonnull Collection<Scanner> scanners) {
        scanner0 = scanners.stream()
                .filter(scanner -> ID_ZERO.equals(scanner.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Scanner with id = '%s' must exist."));
        beaconMatcher = new BeaconMatcher();
        this.scanners = new ArrayList<>(scanners);
        beaconMapNodes = new HashMap<>();
        beaconMapNodes.put(ID_ZERO, new BeaconMapNode(scanner0, null, null));
        beacons = new ArrayList<>();
        findRelations();
    }

    private void findRelations() {
        var unmatchedScanners = scanners.stream()
                .filter(scanner -> !ID_ZERO.equals(scanner.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        var matchedScannersQueue = new ArrayDeque<Scanner>(Collections.singleton(scanner0));

        Scanner scanner;
        Scanner matchedScanner;
        while (!matchedScannersQueue.isEmpty()) {
            matchedScanner = matchedScannersQueue.pop();
            var unmatchedIterator = unmatchedScanners.iterator();
            while (unmatchedIterator.hasNext()) {
                scanner = unmatchedIterator.next();
                var relation = beaconMatcher.match(scanner, matchedScanner);
                if (relation != null) {
                    unmatchedIterator.remove();
                    matchedScannersQueue.add(scanner);

                    var parentBeaconMapNode = beaconMapNodes.get(matchedScanner.getId());
                    var beaconMapNode = new BeaconMapNode(scanner, parentBeaconMapNode, relation);
                    parentBeaconMapNode.getChildren().add(beaconMapNode);
                    beaconMapNodes.put(scanner.getId(), beaconMapNode);
                }
            }
        }
    }

    public Set<Voxel> mapBeacons() {
        return mapBeacons(beaconMapNodes.get(ID_ZERO));
    }

    public Set<Voxel> mapBeacons(BeaconMapNode node) {
        node.setBeacons(new HashSet<>(node.getScanner().getBeacons()));
        for (var childNode : node.getChildren()) {
            node.getBeacons().addAll(mapBeacons(childNode));
        }
        return node.getScannerRelation() == null
                ? node.getBeacons()
                : node.getBeacons().stream()
                .map(node.getScannerRelation()::transform)
                .collect(Collectors.toSet());
    }


}
