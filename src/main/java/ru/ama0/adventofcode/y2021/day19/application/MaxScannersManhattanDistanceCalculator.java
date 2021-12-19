package ru.ama0.adventofcode.y2021.day19.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day19.domain.BeaconMapCalculator;
import ru.ama0.adventofcode.y2021.day19.domain.BeaconMapNode;
import ru.ama0.adventofcode.y2021.day19.domain.Voxel;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MaxScannersManhattanDistanceCalculator {

    private final BeaconMapCalculator beaconMapCalculator;

    public int execute() {
        beaconMapCalculator.getBeaconMapNodes().values().forEach(this::calculateGlobalShift);
        var shifts = beaconMapCalculator.getBeaconMapNodes().values().stream()
                .map(BeaconMapNode::getGlobalShift)
                .collect(Collectors.toList());
        var maxManhattanDistance = 0;
        for (int i = 0; i < shifts.size(); i++) {
            for (int j = i + 1; j < shifts.size(); j++) {
                var distance = shifts.get(j).sub(shifts.get(i)).getManhattanDistance();
                if (distance > maxManhattanDistance) {
                    maxManhattanDistance = distance;
                }
            }
        }
        return maxManhattanDistance;
    }

    private void calculateGlobalShift(@Nonnull BeaconMapNode node) {
        Voxel scannerPosition = new Voxel(0, 0, 0);
        var nextNode = node;
        while (nextNode != null && nextNode.getScannerRelation() != null){
            scannerPosition = nextNode.getScannerRelation().transform(scannerPosition);
            nextNode = nextNode.getParent();
        }
        node.setGlobalShift(scannerPosition);
    }
}
