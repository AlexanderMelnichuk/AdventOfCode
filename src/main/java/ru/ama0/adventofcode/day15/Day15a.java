package ru.ama0.adventofcode.day15;

import java.util.HashMap;
import java.util.Map;

public class Day15a {
    public static void main(String[] args) {
        String input = "0,3,6";
        Map<Integer, Integer> spoken = new HashMap<>();
        Map<Integer, Integer> previousSpoken = new HashMap<>();
        // Initialize
        String[] inputNumbers = input.split(",");
        int lastNumber;
        for (int counter = 1; counter < inputNumbers.length; counter++) {
            lastNumber = Integer.parseInt(inputNumbers[counter - 1]);
            print(counter, lastNumber);
            spoken.put(lastNumber, counter);
        }
        lastNumber = Integer.parseInt(inputNumbers[inputNumbers.length - 1]);
        print(inputNumbers.length, lastNumber);
        // Loop
        int counter = inputNumbers.length + 1;
        int nextNumber;
        while (counter < 10) {
            if (!spoken.containsKey(lastNumber)) {
                nextNumber = 0;
                if (spoken.containsKey(nextNumber)) {
                    previousSpoken.put(nextNumber, spoken.get(nextNumber));
                }
                spoken.put(nextNumber, counter);
            } else {
                nextNumber = spoken.get(lastNumber) - previousSpoken.get(lastNumber);
                if (spoken.containsKey(nextNumber)) {
                    previousSpoken.put(nextNumber, spoken.get(nextNumber));
                }
                spoken.put(nextNumber, counter);
            }
            print(counter, nextNumber);
            lastNumber = nextNumber;
            counter++;
        }

    }

    private static void print(int counter, int lastNumber) {
        System.out.printf("%d : %d%n", counter, lastNumber);
    }
}
