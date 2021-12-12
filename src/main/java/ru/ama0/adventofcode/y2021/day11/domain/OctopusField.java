package ru.ama0.adventofcode.y2021.day11.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public class OctopusField {

    private static final int FLASH_THRESHOLD = 9;

    private final int[][] energyLevels;
    @Getter
    private final int rowCount;
    @Getter
    private final int colCount;

    @Getter
    private long lastStepFlashCount;

    @Getter
    private boolean[][] flashed;


    public OctopusField(@Nonnull int[][] energyLevels) {
        if (energyLevels.length == 0) {
            throw new IllegalArgumentException("Octopus field must have at least one row");
        }
        this.energyLevels = energyLevels;
        rowCount = energyLevels.length;
        colCount = energyLevels[0].length;
    }

    public void step() {
        flashed = new boolean[rowCount][colCount];
        lastStepFlashCount = 0;

        // Increase energyLevels
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                increaseEnergyLevel(row, col);
            }
        }


    }

    private void flash(int row, int col) {
        if (flashed[row][col]) {
            return;
        }
        flashed[row][col] = true;
        energyLevels[row][col] = 0;
        lastStepFlashCount++;
        increaseEnergyLevel(row - 1, col - 1);
        increaseEnergyLevel(row - 1, col);
        increaseEnergyLevel(row - 1, col + 1);
        increaseEnergyLevel(row, col - 1);
        increaseEnergyLevel(row, col);
        increaseEnergyLevel(row, col + 1);
        increaseEnergyLevel(row + 1, col - 1);
        increaseEnergyLevel(row + 1, col);
        increaseEnergyLevel(row + 1, col + 1);
    }

    private void increaseEnergyLevel(int row, int col) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount) {
            return;
        }
        if (!flashed[row][col]) {
            energyLevels[row][col]++;
            if (energyLevels[row][col] > FLASH_THRESHOLD) {
                flash(row, col);
            }
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                sb.append(energyLevels[row][col]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
