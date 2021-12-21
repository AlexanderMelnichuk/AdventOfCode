package ru.ama0.adventofcode.y2021.day20.domain;

import lombok.Value;

@Value
public class Image {

    char infinityFiller;
    String[] pixelLines;

    public String[] getPixelLines() {
        String[] result = new String[pixelLines.length];
        System.arraycopy(pixelLines, 0, result, 0, pixelLines.length);
        return result;
    }

    @Override
    public String toString() {
        return String.join("\n", pixelLines);
    }

}
