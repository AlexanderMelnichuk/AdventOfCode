package ru.ama0.adventofcode.day17.cube;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AdjacentStrategy {

    public boolean getNextState(Cube cube, int x, int y, int z) {
        boolean current = x >= 0 && x < cube.getX() &&
                y >= 0 && y < cube.getY() &&
                z >= 0 && z < cube.getZ() &&
                cube.getState()[x][y][z];

        int fromX = max(0, x - 1);
        int toX = min(cube.getX() - 1, x + 1);
        int fromY = max(0, y - 1);
        int toY = min(cube.getY() - 1, y + 1);
        int fromZ = max(0, z - 1);
        int toZ = min(cube.getZ() - 1, z + 1);

        int activeCount = 0;
        for (int iX = fromX; iX <= toX; iX++) {
            for (int iY = fromY; iY <= toY; iY++) {
                for (int iZ = fromZ; iZ <= toZ; iZ++) {
                    if (iX == x && iY == y && iZ == z) {
                        continue;
                    }
                    if (cube.getState()[iX][iY][iZ]) {
                        activeCount++;
                    }
                }
            }
        }
        if (current) {
            return (activeCount == 2 || activeCount == 3);
        } else {
            return (activeCount == 3);
        }
    }
}
