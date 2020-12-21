package ru.ama0.adventofcode.day13.math;

import lombok.Getter;
import lombok.Setter;

import java.util.BitSet;

@Getter
public class Primes {
    @Setter
    private static volatile int maxVal = 2000;

    private final BitSet positions = new BitSet();
    private final int[] divisors; // Наименьший простой делитель числа.

    private Primes(int maxVal) {
        divisors = new int[maxVal + 1];
        for (int i = 2; i < maxVal; i++) {
            if (divisors[i] == 0) {
                divisors[i] = i;
                positions.set(i);
            }
            for (int p = 2; p <= divisors[i] && p * i <= maxVal && p > -1; p = positions.nextSetBit(p + 1)) {
                divisors[p * i] = p;
            }
        }
    }

    private static class PrimesHolder {
        private static final Primes PRIMES_HOLDER = new Primes(maxVal);
    }

    public static Primes getInstance() {
        return PrimesHolder.PRIMES_HOLDER;
    }
}
