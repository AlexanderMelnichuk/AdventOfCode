package ru.ama0.adventofcode.y2020.day13.math;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;
import java.math.BigInteger;

/**
 * Вычислитель НОД
 */
@UtilityClass
public class Gcd {
    public static long of(long a, long b) {
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b; // One of them is zero, but we don't know which one.
    }

    public static BigInteger of(@Nonnull BigInteger a, @Nonnull BigInteger b) {
        while ((a.compareTo(BigInteger.ZERO) != 0) && (b.compareTo(BigInteger.ZERO) != 0)) {
            if (a.compareTo(b) > 0) {
                a = a.mod(b);
            } else {
                b = b.mod(a);
            }
        }
        return a.compareTo(BigInteger.ZERO) == 0 ? b : a;
    }
}
