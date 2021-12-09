package ru.ama0.adventofcode.y2021.day09.domain;

import lombok.Getter;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

@Getter
public class BasinFiller {

    private static final int BASIN_EDGE_HEIGHT = 9;

    private final Heights heights;
    private final Integer[][] basinIds;
    private final Map<Integer, Basin> basins;

    public BasinFiller(Heights heights) {
        this.heights = heights;
        basinIds = new Integer[heights.getRowCount()][heights.getColCount()];
        basins = new HashMap<>();
    }

    public Map<Integer, Basin> calcBasins() {
        var lowPoints = heights.calcLowPoints();

        int basinId = 1;
        for (var lowPoint : lowPoints) {
            var basin = createBasin(lowPoint, basinId);
            basins.put(basin.getId(), basin);
            basinId++;
        }

        return basins;
    }

    @Nonnull
    private Basin createBasin(Point point, int basinId) {
        if (heights.getHeight(point) == BASIN_EDGE_HEIGHT) {
            throw new IllegalArgumentException("Basin can't contain an edge point" + BASIN_EDGE_HEIGHT);
        }

        var existingBasinId = basinIds[point.getRow()][point.getColumn()];
        if (existingBasinId != null) {
            return basins.get(existingBasinId);
        }

        // Create new Basin and fill it
        var basin = new Basin(basinId);
        fillBasin(point, basin);
        return basin;
    }

    private void fillBasin(Point point, Basin basin) {
        // Edges are not included
        if (heights.getHeight(point) == BASIN_EDGE_HEIGHT) {
            return;
        }

        // Skipping already filled points
        if (basinIds[point.getRow()][point.getColumn()] != null) {
            return;
        }

        // Filling the point
        basinIds[point.getRow()][point.getColumn()] = basin.getId();
        basin.getPoints().add(point);

        // Calling the fill recursively for adjacent points
        if (point.getRow() > 1) {
            fillBasin(new Point(point.getRow() - 1, point.getColumn()), basin);
        }
        if (point.getRow() < heights.getRowCount() - 2) {
            fillBasin(new Point(point.getRow() + 1, point.getColumn()), basin);
        }
        if (point.getColumn() > 1) {
            fillBasin(new Point(point.getRow(), point.getColumn() - 1), basin);
        }
        if (point.getColumn() < heights.getColCount() - 2) {
            fillBasin(new Point(point.getRow(), point.getColumn() + 1), basin);
        }
    }

}
