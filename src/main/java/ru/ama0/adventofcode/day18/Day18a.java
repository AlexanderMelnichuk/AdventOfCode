package ru.ama0.adventofcode.day18;

import ru.ama0.adventofcode.day18.myparser.Parser;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.List;

public class Day18a {
    public static void main(String[] args) throws IOException {
        List<String> expressions = Io.readLines("/day18.txt");
        long sum = 0;

        Parser parser = new Parser();
        for(String expression : expressions) {
            sum += parser.parse(expression).calc();
        }
        System.out.println(sum);
    }
}
