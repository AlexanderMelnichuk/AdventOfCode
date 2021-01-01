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
        int nextNumber = 0;
        while (counter < n) {
            if (spoken.containsKey(lastNumber)) {
                nextNumber = counter - spoken.get(lastNumber);
            } else {
                nextNumber = 0;
            }
            spoken.put(lastNumber, counter);
            counter++;
            lastNumber = nextNumber;
        }
        return nextNumber;
    }

}
