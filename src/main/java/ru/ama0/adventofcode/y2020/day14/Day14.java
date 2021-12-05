package ru.ama0.adventofcode.y2020.day14;

import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14 {
    private static final Pattern MASK_PATTERN = Pattern.compile("^mask = (?<mask>[01X]{36})$");
    private static final Pattern SET_PATTERN = Pattern.compile("^mem\\[(?<address>\\d+)] = (?<value>\\d+)$");
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day14.txt");

        Processor processor = new Processor();
        long maxCountX = 0;
        for (String line: lines) {
            Matcher maskMatcher;
            Matcher memMatcher;
            if ((maskMatcher = MASK_PATTERN.matcher(line)).find()) {
                String mask = maskMatcher.group("mask");
                long countX = mask.chars().filter(x -> x == (int)'X').count();
                if (countX > maxCountX) {
                    maxCountX = countX;
                }
                processor.readMask(mask);

            } else if ((memMatcher = SET_PATTERN.matcher(line)).find()) {
                Integer address = Integer.parseInt(memMatcher.group("address"));
                long value = Long.parseLong(memMatcher.group("value"));
                processor.setValue(address, value);
            }
        }

        System.out.println(processor.getSum());

        System.out.println(maxCountX);


        Processor2 processor2 = new Processor2();
        for (String line: lines) {
            Matcher maskMatcher;
            Matcher memMatcher;
            if ((maskMatcher = MASK_PATTERN.matcher(line)).find()) {
                String mask = maskMatcher.group("mask");
                processor2.readMask(mask);

            } else if ((memMatcher = SET_PATTERN.matcher(line)).find()) {
                int address = Integer.parseInt(memMatcher.group("address"));
                long value = Long.parseLong(memMatcher.group("value"));
                processor2.setValue(address, value);
            }
        }

        System.out.println(processor2.getSum());

    }
}
