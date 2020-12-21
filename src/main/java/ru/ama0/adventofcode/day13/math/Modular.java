package ru.ama0.adventofcode.day13.math;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Solver of modular equations a * x ≡ b (mod m)
 *
 * By http://math.csu.ru/new_files/students/lectures/teor_chisel/mitina_resh_zadach.pdf
 */
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of = {"a", "b", "m"})
public class Modular {
    private final long a;
    private final long b;
    private final long m;

    private final long[] x;

    public static Modular of(long a, long b, long m) {
        long gcd = Gcd.of(a, m);
        if (b % gcd != 0) {
            // No solutions
            return new Modular(a, b, m, new long[0]);
        }

        LinearRepresentation linearRepresentation = LinearRepresentation.of(a, m);
        long[] x = new long[(int)gcd];
        x[0] = linearRepresentation.getX() * (b / gcd) % (m / gcd);
        if (x[0] < 0) {
            x[0] += m / gcd;
        }

        for (int i = 1; i < gcd; i++) {
            x[i] = x[0] + m / gcd * i;
        }
        return new Modular(a, b, m, x);
    }

}
