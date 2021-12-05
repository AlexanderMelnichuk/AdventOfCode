package ru.ama0.adventofcode.y2020.day17.cube;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HCube {

    @Getter
    private final boolean[][][][] state;

    public int getX() {
        return state.length;
    }

    public int getY() {
        return state[0].length;
    }

    public int getZ() {
        return state[0][0].length;
    }

    public int getW() {
        return state[0][0][0].length;
    }

    public int getCount() {
        int count = 0;
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                for (int z = 0; z < getZ(); z++) {
                    for (int w = 0; w < getW(); w++) {
                        if (state[x][y][z][w]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public HCube(Cube cube) {
        this.state = new boolean[cube.getX()][cube.getY()][cube.getZ()][1];
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                for (int z = 0; z < getZ(); z++) {
                    this.state[x][y][z][0] = cube.getState()[x][y][z];
                }
            }

        }
    }

    public boolean[] getExpandDirections() {
        boolean[] result = new boolean[8];
        // x top
        result[0] = checkXPlane(0);
        result[1] = checkXPlane(getX() - 1);
        result[2] = checkYPlane(0);
        result[3] = checkYPlane(getY() - 1);
        result[4] = checkZPlane(0);
        result[5] = checkZPlane(getZ() - 1);
        result[6] = checkWPlane(0);
        result[7] = checkWPlane(getW() - 1);

        return result;
    }

    private boolean checkXPlane(int x) {
        for (int y = 0; y < getY(); y++) {
            for (int z = 0; z < getZ(); z++) {
                for (int w = 0; w < getW(); w++) {
                    if (state[x][y][z][w]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkYPlane(int y) {
        for (int x = 0; x < getX(); x++) {
            for (int z = 0; z < getZ(); z++) {
                for (int w = 0; w < getW(); w++) {
                    if (state[x][y][z][w]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkZPlane(int z) {
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                for (int w = 0; w < getW(); w++) {
                    if (state[x][y][z][w]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWPlane(int w) {
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                for (int z = 0; z < getZ(); z++) {
                    if (state[x][y][z][w]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int w = 0; w < getW(); w++) {
            for (int z = 0; z < getZ(); z++) {
                sb.append("z = ").append(z).append(", w = ").append(w);
                for (int x = 0; x < getX(); x++) {
                    sb.append("\n");
                    for (int y = 0; y < getY(); y++) {
                        sb.append(state[x][y][z][w] ? '#' : '.');
                    }
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
