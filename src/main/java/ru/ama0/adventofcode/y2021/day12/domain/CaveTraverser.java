package ru.ama0.adventofcode.y2021.day12.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CaveTraverser {

    private final Map<String, Cave> caves;
    private final Map<String, Integer> smallCaveIndices;
    private final byte smallCaveMaxVisits;
    private final String startCaveName;
    private final String endCaveName;
    private List<List<String>> results;

    public CaveTraverser(@Nonnull Map<String, Cave> caves, String startCaveName, String endCaveName,
            byte smallCaveMaxVisits) {
        var startCave = caves.get(startCaveName);
        var endCave = caves.get(endCaveName);
        Objects.requireNonNull(startCave, "Start cave not found");
        Objects.requireNonNull(endCave, "End cave not found");

        this.startCaveName = startCaveName;
        this.endCaveName = endCaveName;
        this.caves = caves;
        smallCaveIndices = generateSmallCaveIds();
        this.smallCaveMaxVisits = smallCaveMaxVisits;
    }

    public List<List<String>> countPaths(@Nonnull String fromCaveName) {
        results = new ArrayList<>();
        countPaths(fromCaveName, new byte[smallCaveIndices.size()], false, new ArrayList<>());
        return results;
    }

    private long countPaths(String fromCaveName, byte[] previousVisitedSmallCaves,
            boolean isPreviousSmallCaveVisitedTwice, List<String> previousPath) {
        // Check if the end is reached
        var path = new ArrayList<>(previousPath);
        if (endCaveName.equals(fromCaveName)) {
            path.add(endCaveName);
            results.add(path);
            return 1L;
        }

        // If this cave is small, mark it visited for current path.
        var thisCave = caves.get(fromCaveName);
        byte[] visitedSmallCaves;
        if (thisCave.isSmall()) {
            visitedSmallCaves = new byte[smallCaveIndices.size()];
            System.arraycopy(previousVisitedSmallCaves, 0, visitedSmallCaves, 0, smallCaveIndices.size());
            visitedSmallCaves[smallCaveIndices.get(thisCave.getName())]++;
        } else {
            visitedSmallCaves = previousVisitedSmallCaves;
        }

        final boolean isThisSmallCaveVisitedTwice =
                isPreviousSmallCaveVisitedTwice ||
                        (thisCave.isSmall() &&
                                visitedSmallCaves[smallCaveIndices.get(thisCave.getName())] > 1);

        // Count paths for all connected caves except visited small ones
        var connectedCavesToVisit = thisCave.getConnections().stream()
                .filter(connectedCave -> !startCaveName.equals(connectedCave.getName()) &&
                        (!connectedCave.isSmall() ||
                                (visitedSmallCaves[smallCaveIndices.get(connectedCave.getName())] <
                                        (isThisSmallCaveVisitedTwice ? 1 : smallCaveMaxVisits))))
                .collect(Collectors.toCollection(HashSet::new));

        path.add(fromCaveName);
        return connectedCavesToVisit.stream()
                .mapToLong(caveToVisit -> countPaths(caveToVisit.getName(), visitedSmallCaves,
                        isThisSmallCaveVisitedTwice, path))
                .sum();
    }

    private Map<String, Integer> generateSmallCaveIds() {
        var smallCaveIds = new HashMap<String, Integer>(caves.size());
        var id = 0;
        for (var cave : caves.values()) {
            if (cave.isSmall()) {
                smallCaveIds.put(cave.getName(), id++);
            }
        }
        return smallCaveIds;
    }

}
