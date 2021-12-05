package ru.ama0.adventofcode.y2020.day17.cube;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class HStrategy {

    public boolean getNextState(HCube cube, int x, int y, int z, int w) {
        boolean current = x >= 0 && x < cube.getX() &&
                y >= 0 && y < cube.getY() &&
                z >= 0 && z < cube.getZ() &&
                w >= 0 && w < cube.getW() &&
                cube.getState()[x][y][z][w];

        int fromX = max(0, x - 1);
        int toX = min(cube.getX() - 1, x + 1);
        int fromY = max(0, y - 1);
        int toY = min(cube.getY() - 1, y + 1);
        int fromZ = max(0, z - 1);
        int toZ = min(cube.getZ() - 1, z + 1);
        int fromW = max(0, w - 1);
        int toW = min(cube.getW() - 1, w + 1);

        int activeCount = 0;
        for (int iX = fromX; iX <= toX; iX++) {
            for (int iY = fromY; iY <= toY; iY++) {
                for (int iZ = fromZ; iZ <= toZ; iZ++) {
                    for (int iW = fromW; iW <= toW; iW++) {
                        if (iX == x && iY == y && iZ == z && iW == w) {
                            continue;
                        }
                        if (cube.getState()[iX][iY][iZ][iW]) {
                            activeCount++;
                        }
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
