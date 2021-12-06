package ru.ama0.adventofcode.y2021.day04.domain;

import ru.ama0.adventofcode.util.StringUtil;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static final int BOARD_SIZE = 5;

    private final boolean[][] drawn = new boolean[BOARD_SIZE][BOARD_SIZE];
    private final int[][] numbers;

    private final Map<Integer, Point> numbersIndex = new HashMap<>(BOARD_SIZE * BOARD_SIZE);


    public Board(@Nonnull int[][] numbers) {
        this.numbers = numbers;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (numbersIndex.get(numbers[row][column]) != null) {
                    throw new IllegalArgumentException("Duplicate number on a board");
                }
                numbersIndex.put(numbers[row][column], new Point(row, column));
            }
        }
    }

    // Could add some arrays to store drawn count for rows & cols, and update them on number draw,
    // but that's premature optimization.
    public boolean isWinner() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int drawnInRow = 0;
            int drawnInCol = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                drawnInRow += (drawn[i][j] ? 1 : 0);
                drawnInCol += (drawn[j][i] ? 1 : 0);
            }
            if (drawnInRow == BOARD_SIZE || drawnInCol == BOARD_SIZE) {
                return true;
            }
        }
        return false;
    }

    public void draw(int number) {
        var point = numbersIndex.get(number);
        if (point != null) {
            drawn[point.getRow()][point.getColumn()] = true;
        }
    }

    @Nonnull
    public Collection<Integer> getNotDrawnNumbers() {
        var result = new ArrayList<Integer>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (!drawn[row][column]) {
                    result.add(numbers[row][column]);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Board{" +
                "\ndrawn=" + StringUtil.toString(drawn) +
                ";\nnumbers=" + StringUtil.toString(numbers) +
                ";\nnumbersIndex=" + numbersIndex +
                "}\n";
    }

}
