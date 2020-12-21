package ru.ama0.adventofcode.day13;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.day13.math.Modular;

import static org.junit.jupiter.api.Assertions.*;

class ModularTest {

    @Test
    void modularSolve() {
        val modular = Modular.of(1287, 963, 516);

        assertArrayEquals(new long[] {109, 281, 453}, modular.getX());
    }
}