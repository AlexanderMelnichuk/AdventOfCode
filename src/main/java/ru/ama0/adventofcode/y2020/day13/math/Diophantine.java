package ru.ama0.adventofcode.y2020.day13.math;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Function;

/**
 * Solver for diophantine equations a1 * x + a2 * y = z
 * Решатель диофантовых уравнений вида a1 * x + a2 * y = z
 *
 * Result: first solution (x0, y0) and functions (fx, fy) for generation of other solutions (x, y)
 * Результат: первое решение (x0, y0) и функции (fx, fy) для генерации пар других решений (x, y)
 */
@Getter
@ToString(exclude = {"fx", "fy"})
@RequiredArgsConstructor
public class Diophantine {
    private final long a1;
    private final long a2;
    private final long z;

    private final long x0;
    private final long y0;

    private final Function<Long, Long> fx;
    private final Function<Long, Long> fy;

    public static Diophantine solve(long a1, long a2, long z) {
        LinearRepresentation linearRepresentation = LinearRepresentation.of(a1, a2);
        return new Diophantine(a1, a2, z,
                linearRepresentation.getX(),
                linearRepresentation.getY(),
                t -> linearRepresentation.getX() * z + a2 * t,
                t -> linearRepresentation.getY() * z - a1 * t);
    }
}
