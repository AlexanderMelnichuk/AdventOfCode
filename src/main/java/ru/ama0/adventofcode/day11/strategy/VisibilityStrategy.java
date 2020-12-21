package ru.ama0.adventofcode.day11.strategy;

import static ru.ama0.adventofcode.day11.Constants.EMPTY;
import static ru.ama0.adventofcode.day11.Constants.FLOOR;
import static ru.ama0.adventofcode.day11.Constants.OCCUPIED;

public class VisibilityStrategy implements StateStrategy {
    @Override
    public Character getNextState(char[][] state, Integer row, Integer col) {
        char current = state[row][col];
        if (current == FLOOR) {
            return FLOOR;
        }

        int occupied = checkOccupied(state, row, col, 1, 0)
                + checkOccupied(state, row, col, 0, 1)
                + checkOccupied(state, row, col, 1, 1)
                + checkOccupied(state, row, col, -1, 0)
                + checkOccupied(state, row, col, -1, -1)
                + checkOccupied(state, row, col, 0, -1)
                + checkOccupied(state, row, col, -1, 1)
                + checkOccupied(state, row, col, 1, -1);
        if (current == EMPTY && occupied == 0) {
            return OCCUPIED;
        } else if (current == OCCUPIED && occupied >= 5) {
            return EMPTY;
        } else {
            return current;
        }
    }

    private int checkOccupied(char[][] state, int row, int col, int stepRow, int stepCol) {
        int maxRow = state.length - 1;
        int maxCol = state[0].length - 1;
        while (true) {
            row += stepRow;
            col += stepCol;
            if (row > maxRow || col > maxCol || row < 0 || col < 0) {
                return 0;
            }
            if (state[row][col] != FLOOR) {
                return state[row][col] == OCCUPIED ? 1 : 0;
            }
        }
    }
}
