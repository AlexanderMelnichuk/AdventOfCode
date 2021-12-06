package ru.ama0.adventofcode.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class StringUtil {

    public static String toString(boolean[][] array) {
        var sb = new StringBuilder("[\n");
        for (boolean[] line : array) {
            sb.append(Arrays.toString(line)).append(",\n");
        }
        sb.replace(sb.length() - 1, sb.length(), "\n]");
        return sb.toString();
    }

    public static String toString(int[][] array) {
        var sb = new StringBuilder("[");
        for (int[] line : array) {
            sb.append("\n").append(Arrays.toString(line)).append(",");
        }
        sb.replace(sb.length() - 1, sb.length(), "\n]");
        return sb.toString();
    }

}
