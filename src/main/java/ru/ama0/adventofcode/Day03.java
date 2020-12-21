package ru.ama0.adventofcode;


import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;

public class Day03 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day03.txt");

        long trees5 = getTrees(lines, 1, 2);

        long trees = getTrees(lines, 3, 1);
        long trees2 = getTrees(lines, 1, 1);
        long trees3 = getTrees(lines, 5, 1);
        long trees4 = getTrees(lines, 7, 1);
        System.out.println(trees);
        System.out.println(trees * trees2 * trees3 * trees4 * trees5);
    }

    private static int getTrees(List<String> lines, int hStep, int vStep) {
        int trees = 0;
        int pos = 0;
        int currentVStep = 0;
        int size = lines.get(0).length();
        for(String line: lines) {
            if (currentVStep > 1) {
                currentVStep--;
                continue;
            } else {
                currentVStep = vStep;
            }
            if (line.charAt(pos) != '.') {
                trees++;
            }
            pos+=hStep;
            if (pos > size - 1) {
                pos -= size;
            }
        }
        return trees;
    }
}
