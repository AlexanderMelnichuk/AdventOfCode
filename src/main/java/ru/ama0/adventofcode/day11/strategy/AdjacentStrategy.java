package ru.ama0.adventofcode.day11.strategy;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static ru.ama0.adventofcode.day11.Constants.EMPTY;
import static ru.ama0.adventofcode.day11.Constants.FLOOR;
import static ru.ama0.adventofcode.day11.Constants.OCCUPIED;

public class AdjacentStrategy implements StateStrategy {

    @Override
    public Character getNextState(char[][] state, Integer row, Integer col) {
        char current = state[row][col];
        if (current == FLOOR) {
            return FLOOR;
        }
        int fromRow = max(0, row - 1);
        int toRow = min(state.length - 1, row + 1);
        int fromCol = max(0, col - 1);
        int toCol = min(state[0].length - 1, col + 1);
        int occupied = 0;
        for (int iRow = fromRow; iRow <= toRow; iRow++) {
            for (int iCol = fromCol; iCol <= toCol; iCol++) {
                if (iRow == row && iCol == col) {
                    continue;
                }
                if (state[iRow][iCol] == OCCUPIED) {
                    occupied++;
                }
            }
        }

        if (current == OCCUPIED && occupied >= 4) {
            return EMPTY;
        } else if (current == EMPTY && occupied == 0) {
            return OCCUPIED;
        } else {
            return current;
        }
    }
}
