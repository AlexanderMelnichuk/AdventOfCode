package ru.ama0.adventofcode.day17.cube;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HSimulator {
    private final HStrategy strategy;

    public HCube simulate(HCube cube) {
        boolean[] expands = cube.getExpandDirections();
        int shiftX = (expands[0] ? 1 : 0);
        int shiftY = (expands[2] ? 1 : 0);
        int shiftZ = (expands[4] ? 1 : 0);
        int shiftW = (expands[6] ? 1 : 0);
        int topNextX = expands[1]
                ? cube.getX() + shiftX + 1
                : cube.getX() + shiftX;
        int topNextY = expands[3]
                ? cube.getY() + shiftY + 1
                : cube.getY() + shiftY;
        int topNextZ = expands[5]
                ? cube.getZ() + shiftZ + 1
                : cube.getZ() + shiftZ;
        int topNextW = expands[7]
                ? cube.getW() + shiftW + 1
                : cube.getW() + shiftW;

        boolean[][][][] nextState = new boolean[topNextX][topNextY][topNextZ][topNextW];
        for (int x = 0; x < topNextX; x++) {
            for (int y = 0; y < topNextY; y++) {
                for (int z = 0; z < topNextZ; z++) {
                    for (int w = 0; w < topNextW; w++) {
                        nextState[x][y][z][w] = strategy.getNextState(cube,
                                x - shiftX,
                                y - shiftY,
                                z - shiftZ,
                                w - shiftW);
                    }
                }
            }
        }
        return new HCube(nextState);
    }
}
