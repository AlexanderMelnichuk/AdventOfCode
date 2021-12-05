package ru.ama0.adventofcode.y2020.day14;

import lombok.Getter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Getter
public class Processor2 {
    private long maskSet = 0;
    Set<Integer> xPositions;

    private final Map<Long, Long> memory = new HashMap<>();

    public void readMask(String mask) {
        maskSet = Long.parseLong(mask.replace('X', '0'), 2);
        xPositions = new TreeSet<>();

        for (int i = 0; i < 36; i++) {
            char currentChar = mask.charAt(i);
            if (currentChar == 'X') {
                xPositions.add(35 - i);
            }
        }
    }

    public void setValue(long address, long value) {
        long baseAddress = address | maskSet;
        int countTo = 1 << xPositions.size();
        for (int counter = 0; counter < countTo; counter++) {
            long currentAddress = baseAddress;
            long addressMask;
            int counterPos = 0;
            for (int addressPos : xPositions) {
                int bit = (counter >> counterPos) & 1;
                addressMask = 1L << addressPos;
                if (bit == 1) {
                    currentAddress |= addressMask;
                } else {
                    currentAddress &= ~(addressMask);
                }
                counterPos++;
            }
            memory.put(currentAddress, value);
        }

    }

    public BigInteger getSum() {
        return memory.values().stream().map(BigInteger::valueOf).reduce(BigInteger::add).orElse(BigInteger.ZERO);
    }
}
