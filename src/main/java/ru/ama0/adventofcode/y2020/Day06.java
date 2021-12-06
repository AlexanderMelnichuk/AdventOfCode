package ru.ama0.adventofcode.y2020;

import com.google.common.collect.Sets;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 {

    public static final String LINE_DELIMITER = " ";
    public static final String GROUP_DELIMITER = LINE_DELIMITER + LINE_DELIMITER;

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/2020/day06.txt");
        String[] sLines = String.join(LINE_DELIMITER, lines)
                .split(GROUP_DELIMITER);

        int anyone = Arrays.stream(sLines)
                .map(s -> s.replace(LINE_DELIMITER, ""))
                .map(s -> s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet()).size())
                .reduce(Integer::sum)
                .orElse(0);
        int everyone = Arrays.stream(sLines)
                .map(group -> Arrays.stream(group.split(LINE_DELIMITER))
                        .map(str -> str.chars().mapToObj(e -> (char) e)
                                .collect(Collectors.toSet()))
                        .reduce(Sets::intersection)
                        .orElse(Collections.emptySet())
                        .size())
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println(anyone);
        System.out.println(everyone);


    }
}
