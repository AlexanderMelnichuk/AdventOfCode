package ru.ama0.adventofcode.y2021.sharedkernel;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ArrayUtils {

    public int[][] clone2d(int[][] array) {
        return Arrays.stream(array).sequential()
                .map((int[] row) -> {
                    int[] clonedRow = new int[row.length];
                    System.arraycopy(row, 0, clonedRow, 0, row.length);
                    return clonedRow;
                }).toArray(int[][]::new);
    }

}
