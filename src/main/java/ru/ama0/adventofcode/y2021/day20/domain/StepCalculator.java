package ru.ama0.adventofcode.y2021.day20.domain;

import com.google.common.base.Strings;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class StepCalculator {

    private static final int REQUIRED_ALGO_LENGTH = 512;

    private final String algorithm;
    private final char darkGeneratedPixel;
    private final char lightGeneratedPixel;

    public StepCalculator(@Nonnull String algorithm) {
        if (algorithm.length() != REQUIRED_ALGO_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("Algorithm must have length of %d.", REQUIRED_ALGO_LENGTH));
        }
        this.algorithm = algorithm;
        darkGeneratedPixel = algorithm.charAt(0);
        lightGeneratedPixel = algorithm.charAt(algorithm.length() - 1);
    }

    public Image enhance(Image image) {
        var expandedImage = expand(image);
        var imageLines = expandedImage.getPixelLines();
        var infinityGeneratedPixel = (image.getInfinityFiller() == PixelType.DARK)
                ? darkGeneratedPixel
                : lightGeneratedPixel;
        var height = imageLines.length;
        var width = imageLines[0].length();
        char[][] matrix = new char[height][width];

        // Fill contour
        for (int row = 0; row < height; row++) {
            matrix[row][0] = infinityGeneratedPixel;
            matrix[row][width - 1] = infinityGeneratedPixel;
        }
        Arrays.fill(matrix[0], infinityGeneratedPixel);
        Arrays.fill(matrix[height - 1], infinityGeneratedPixel);

        // Fill inner part
        for (int row = 1; row < height - 1; row++) {
            for (int col = 1; col < width - 1; col++) {
                matrix[row][col] = calcPixel(imageLines, row, col);
            }
        }
        var newImageLines = Arrays.stream(matrix)
                .map(String::valueOf)
                .toArray(String[]::new);

        return new Image(infinityGeneratedPixel, newImageLines);
    }

    private char calcPixel(@Nonnull String[] imageLines, int row, int col) {
        var pixelArea = new char[]{
                imageLines[row - 1].charAt(col - 1),
                imageLines[row - 1].charAt(col),
                imageLines[row - 1].charAt(col + 1),
                imageLines[row].charAt(col - 1),
                imageLines[row].charAt(col),
                imageLines[row].charAt(col + 1),
                imageLines[row + 1].charAt(col - 1),
                imageLines[row + 1].charAt(col),
                imageLines[row + 1].charAt(col + 1)
        };
        int bits = 0;
        for (char c : pixelArea) {
            if (c == PixelType.LIGHT) {
                bits |= 1;
            }
            bits <<= 1;
        }
        return algorithm.charAt(bits >> 1);
    }

    public Image expand(Image image) {
        final int expansionWidth = 2;
        var lines = image.getPixelLines();
        var sideExpansion = Strings.repeat(String.valueOf(image.getInfinityFiller()), expansionWidth);
        var horizontallyExpandedLines = Arrays.stream(lines)
                .map(line -> sideExpansion + line + sideExpansion)
                .toArray(String[]::new);
        var expandedLength = lines.length + expansionWidth * 2;
        String[] expandedLines = new String[expandedLength];
        var lineExpansion =
                Strings.repeat(String.valueOf(image.getInfinityFiller()), lines[0].length() + expansionWidth * 2);
        Arrays.fill(expandedLines, lineExpansion);
        System.arraycopy(horizontallyExpandedLines, 0, expandedLines, expansionWidth, horizontallyExpandedLines.length);
        return new Image(image.getInfinityFiller(), expandedLines);
    }


}
