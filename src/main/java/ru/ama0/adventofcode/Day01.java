package ru.ama0.adventofcode;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day01 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day01.txt");
        Set<Integer> set = lines.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        for (int a : set) {
            for (int b : set) {
                int c = 2020 - a - b;
                if (set.contains(c)) {
                    System.out.println(MessageFormat.format("{0} * {1} * {2} = {3,number,#}", a, b, c, a * b * c));
                    return;
                }
            }
        }
    }
}
