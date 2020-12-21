package ru.ama0.adventofcode.day15;

import java.util.HashMap;
import java.util.Map;

public class ElvenCount {
    public int nthNumber(String input, int n) {
        Map<Integer, Integer> spoken = new HashMap<>();
        // Initialize
        String[] inputNumbers = input.split(",");
        int lastNumber;
        for (int counter = 1; counter < inputNumbers.length; counter++) {
            lastNumber = Integer.parseInt(inputNumbers[counter - 1]);
            spoken.put(lastNumber, counter);
        }
        lastNumber = Integer.parseInt(inputNumbers[inputNumbers.length - 1]);

        // Count
        int counter = inputNumbers.length;
        int lastCounter = 0;
        int nextNumber = 0;
        boolean existed;
        while (counter < n) {
            existed = spoken.containsKey(lastNumber);
            if (!existed) {
                spoken.put(lastNumber, counter);
                nextNumber = 0;
            } else {
                lastCounter = spoken.get(lastNumber);
                nextNumber = counter - lastCounter;
                spoken.put(lastNumber, counter);
            }
            counter++;
            lastNumber = nextNumber;
        }
        return nextNumber;
    }

}
