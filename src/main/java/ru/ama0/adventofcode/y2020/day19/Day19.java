package ru.ama0.adventofcode.y2020.day19;

import java.io.IOException;

public class Day19 {
    public static void main(String[] args) throws IOException {
        DataHolder data = DataHolder.loadFrom("/day19-2.txt");

        System.out.println(data.complyingCount());
    }
}
