package ru.ama0.adventofcode.y2020;


import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 {
    private static final Pattern PATTERN = Pattern.compile("(?<from>\\d+)-(?<to>\\d+) (?<character>.): (?<string>.*)");
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/2020/day02.txt");
        int validCountFirst = 0;
        int validCountSecond = 0;
        for(String line: lines) {
            Matcher matcher = PATTERN.matcher(line);
            if (matcher.find()) {
                int from = Integer.parseInt(matcher.group("from"));
                int to = Integer.parseInt(matcher.group("to"));
                char character = matcher.group("character").charAt(0);
                String password = matcher.group("string");

                int countChars1 = countChars(password, character);
                if (countChars1 >= from && countChars1 <= to) {
                    validCountFirst++;
                }

                if (password.charAt(from - 1) == character ^ password.charAt(to - 1) == character) {
                    validCountSecond++;
                }
            }
        }
        System.out.println(validCountFirst);
        System.out.println(validCountSecond);
    }

    private static int countChars(String line, char character) {
        int count = 0;
        if (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == character) {
                    count++;
                }
            }
        }
        return count;
    }
}
