package ru.ama0.adventofcode.y2021.day03.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day03.application.interfaces.InputDataRepository;

import java.util.Arrays;
import java.util.BitSet;

@RequiredArgsConstructor
public class PowerConsumptionCalculator {

    private final InputDataRepository repository;

    public int execute() {
        var numbers = repository.retrieveNumbers();
        var digitCount = repository.getDigitCount();

        var bitCounts = new int[digitCount];
        Arrays.fill(bitCounts, 0);

        int mask;
        for (var number : numbers) {
            for (int digitNumber = 0; digitNumber < digitCount; digitNumber++) {
                mask = 1 << digitNumber;
                if ((number & mask) != 0) {
                    bitCounts[digitNumber]++;
                }
            }
        }
        var gammaRate = new BitSet(digitCount);
        var thresholdCount = numbers.size() / 2;
        for (int digitNumber = 0; digitNumber < digitCount; digitNumber++) {
            if (bitCounts[digitNumber] > thresholdCount) {
                gammaRate.set(digitNumber);
            }
        }
        var epsilonRate = (BitSet) gammaRate.clone();
        epsilonRate.flip(0, digitCount);

        return (int) gammaRate.toLongArray()[0] * (int) epsilonRate.toLongArray()[0];
    }
}
