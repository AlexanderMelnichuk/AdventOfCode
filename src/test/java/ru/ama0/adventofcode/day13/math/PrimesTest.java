package ru.ama0.adventofcode.day13.math;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimesTest {

    public static final int MAX_VAL = 10000;

    @Test
    void primesInit() {
        Primes.setMaxVal(MAX_VAL);
        val primes = Primes.getInstance();
        Primes.setMaxVal(MAX_VAL / 2);
        val primes2 = Primes.getInstance();
        val primes3 = Primes.getInstance();

        // First call initializes the max value
        assertEquals(MAX_VAL + 1, primes.getDivisors().length);
        // Subsequent calls don't affect the max value
        assertEquals(MAX_VAL + 1, primes2.getDivisors().length);
        assertEquals(MAX_VAL + 1, primes3.getDivisors().length);
    }
}