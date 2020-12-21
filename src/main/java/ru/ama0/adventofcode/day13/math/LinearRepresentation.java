package ru.ama0.adventofcode.day13.math;

import lombok.Getter;
import lombok.ToString;

/**
 * Нахождение для заданных a, b линейного представления a * x + b * y = 1
 * методом цепных дробей.
 */
@Getter
@ToString
public class LinearRepresentation {
    private final long a;
    private final long b;

    private long x;
    private long y;

    public static LinearRepresentation of(long a, long b) {
        LinearRepresentation linearRepresentation = new LinearRepresentation(a, b);
        linearRepresentation.calculate();
        return linearRepresentation;
    }

    private LinearRepresentation(long a, long b) {
        if ((a == 0) || (b == 0)) {
            throw new IllegalArgumentException("a and b must not be null");
        }
        this.a = a;
        this.b = b;
    }

    public void calculate() {
        long a = (this.a < 0) ? -this.a : this.a;
        long b = (this.b < 0) ? -this.b : this.b;

        long q = a / b;
        long r = a - q * b;
        a = b;
        b = r;

        long u2 = 0;
        long u1 = 1;
        long u = 1;

        long v2 = 1;
        long v1 = -q;
        long v = q;

        if (b == 0) { // Если сразу поделили без остатка
            x = (this.a < 0) ? -u : u;
            y = (this.b < 0) ? -v - 1 : v + 1;
            return;
        }

        while (a % b != 0) {
            q = a / b;
            r = a - q * b;
            a = b; b = r;

            u = -q * u1 + u2;
            v = -q * v1 + v2;

            u2 = u1; u1 = u;
            v2 = v1; v1 = v;
        }

        x = (this.a < 0) ? -u : u;
        y = (this.b < 0) ? -v : v;
    }

}
