package ru.ama0.adventofcode.day10;

import com.google.common.base.Strings;
import ru.ama0.adventofcode.util.Io;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws Exception {

        List<String> lines = Io.readLines("/day10.txt");
        List<Long> adapters = lines
                .stream()
                .filter(s -> !Strings.isNullOrEmpty(s))
                .map(Long::parseLong)
                .sorted()
                .collect(Collectors.toList());
        int ones = 0;
        int threes = 0;
        Long previous = 0L;
        for (Long current : adapters) {
            if (current - previous == 1) {
                ones++;
            } else {
                threes++;
            }
            previous = current;
        }
        threes++;

        System.out.println("ones: " + ones);
        System.out.println("threes: " + threes);
        System.out.println(ones * threes);

        // Part 2
        List<Integer> sumsOfOnes = new ArrayList<>();
        previous = 0L;
        int sequence = 0;
        for (Long adapter : adapters) {
            if (adapter - previous == 1) {
                sequence++;
            } else if (sequence != 0) {
                if (sequence != 1) {
                    sumsOfOnes.add(sequence);
                }
                sequence = 0;
            }
            previous = adapter;
        }
        if (sequence != 0) {
            sumsOfOnes.add(sequence);
        }
        System.out.println(adapters);
        System.out.println(sumsOfOnes);
        BigInteger prod = sumsOfOnes.stream()
                .map(MAP::get)
                .map(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .orElse(BigInteger.ZERO);
        System.out.println(prod);

    }

    private static final Map<Integer, Integer> MAP = Map.of(
            1, 1,
            2, 2,
            3, 4,
            4, 7);
}
