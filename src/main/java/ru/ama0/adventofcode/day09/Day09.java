package ru.ama0.adventofcode.day09;

import lombok.val;
import ru.ama0.adventofcode.util.Io;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Day09 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day09.txt");
        Long[] numbers = lines.stream().map(Long::parseLong).toArray(Long[]::new);
        int preambleLength = 25;
        List<List<Long>> sums = new LinkedList<>();

        // Calculate preamble sums
        for (int i = 0; i < preambleLength - 1; i++) {
            val sumLine = new LinkedList<Long>();
            for (int j = i + 1; j < preambleLength; j++) {
                sumLine.add(numbers[i] + numbers[j]);
            }
            sums.add(sumLine);
        }

        long foundNumber = 0;

        int index = preambleLength;
        while (index < numbers.length) {
            if (!sumExists(sums, numbers[index])) {
                foundNumber = numbers[index];
                System.out.println(foundNumber);
                break;
            }
            shiftSums(sums, numbers, preambleLength, index);
            index++;
        }

        // Part 2
        int min = 0;
        long sum = numbers[min];
        int max = 0;
        while (foundNumber != sum) {
            if (sum > foundNumber) {
                sum -= numbers[min];
                min++;
            } else {
                max++;
                sum += numbers[max];
            }
        }

        // Find the smallest and the largest
        int smallestIndex = min;
        int largestIndex = min;
        for (int i = min; i <= max ; i++) {
            if (numbers[i] < numbers[smallestIndex]) {
                smallestIndex = i;
            }
            if (numbers[i] > numbers[largestIndex]) {
                largestIndex = i;
            }
        }

        System.out.println(numbers[smallestIndex]);
        System.out.println(numbers[largestIndex]);
        System.out.println(numbers[smallestIndex] + numbers[largestIndex]);
    }

    private static boolean sumExists(List<List<Long>> sums, Long number) {
        return sums.stream()
                .flatMapToLong(subList -> subList.stream().mapToLong(Long::valueOf))
                .anyMatch(number::equals);
    }

    private static void shiftSums(List<List<Long>> sums, Long[] numbers, int preambleLength, int index) {
        sums.remove(0);
        sums.add(new LinkedList<>());

        int shift = index - preambleLength + 1;
        for (int i = shift; i < index; i++) {
            sums.get(i - shift)
                    .add(numbers[index] + numbers[i]);
        }
    }
}
