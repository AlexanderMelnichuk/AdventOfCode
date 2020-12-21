package ru.ama0.adventofcode.day17.cube;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Simulator {
    private final AdjacentStrategy strategy;

    public Cube simulate(Cube cube) {
        boolean[] expands = cube.getExpandDirections();
        int shiftX = (expands[0] ? 1 : 0);
        int shiftY = (expands[2] ? 1 : 0);
        int shiftZ = (expands[4] ? 1 : 0);
        int topNextX = expands[1]
                ? cube.getX() + shiftX  + 1
                : cube.getX() + shiftX;
        int topNextY = expands[3]
                ? cube.getY() + shiftY  + 1
                : cube.getY() + shiftY;
        int topNextZ = expands[5]
                ? cube.getZ() + shiftZ  + 1
                : cube.getZ() + shiftZ;

        boolean[][][] nextState = new boolean[topNextX][topNextY][topNextZ];
        for (int x = 0; x < topNextX; x++) {
            for (int y = 0; y < topNextY; y++) {
                for (int z = 0; z < topNextZ; z++) {
                    nextState[x][y][z] = strategy.getNextState(cube, x - shiftX, y - shiftY, z - shiftZ);
                }
            }
        }
        return new Cube(nextState);
    }



}
