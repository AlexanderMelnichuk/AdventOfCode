package ru.ama0.adventofcode.y2020.day13;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day13a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/2020/day13.txt");
        int earliest = Integer.parseInt(lines.get(0));
        Set<Integer> numbers = Arrays.stream(lines.get(1).split(","))
                .filter(number -> !"x".equals(number))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        int minTime = Integer.MAX_VALUE;
        int minTimeNumber = 0;
        int waitTime;
        for (Integer number : numbers) {
            waitTime = number - earliest % number;
            if (waitTime < minTime) {
                minTime = waitTime;
                minTimeNumber = number;
            }
        }
        System.out.printf("Time: %d, number %d, result = %d", minTime, minTimeNumber, minTime * minTimeNumber);
    }

}
