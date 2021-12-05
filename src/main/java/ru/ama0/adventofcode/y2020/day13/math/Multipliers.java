package ru.ama0.adventofcode.y2020.day13.math;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class Multipliers {

    public static Collection<Integer> get(int x) {
        Primes primes = Primes.getInstance();
        if (primes.getDivisors()[x] == 0) {
            return Collections.singleton(x);
        }
        Map<Integer, Integer> divisors = new HashMap<>();
        int divisor;
        while ((divisor = primes.getDivisors()[x]) != 0) {
            divisors.put(divisor, divisors.getOrDefault(divisor, 1) * divisor);
            x /= divisor;
        }
        return divisors.values();
    }
}
