package ru.ama0.adventofcode.y2020.day17.cube;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cube {

    @Getter
    private final boolean[][][] state;

    public int getX() {
        return state.length;
    }

    public int getY() {
        return state[0].length;
    }

    public int getZ() {
        return state[0][0].length;
    }

    public int getCount() {
        int count = 0;
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                for (int z = 0; z < getZ(); z++) {
                    if (state[x][y][z]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean[] getExpandDirections() {
        boolean[] result = new boolean[6];
        // x top
        result[0] = checkXPlane(0);
        result[1] = checkXPlane(getX() - 1);
        result[2] = checkYPlane(0);
        result[3] = checkYPlane(getY() - 1);
        result[4] = checkZPlane(0);
        result[5] = checkZPlane(getZ() - 1);

        return result;
    }

    private boolean checkXPlane(int x) {
        for (int y = 0; y < getY(); y++) {
            for (int z = 0; z < getZ(); z++) {
                if (state[x][y][z]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkYPlane(int y) {
        for (int x = 0; x < getX(); x++) {
            for (int z = 0; z < getZ(); z++) {
                if (state[x][y][z]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkZPlane(int z) {
        for (int x = 0; x < getX(); x++) {
            for (int y = 0; y < getY(); y++) {
                if (state[x][y][z]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < getZ(); z++) {
            sb.append("z = ").append(z);
            for (int x = 0; x < getX(); x++) {
                sb.append("\n");
                for (int y = 0; y < getY(); y++) {
                    sb.append(state[x][y][z] ? '#' : '.');
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
