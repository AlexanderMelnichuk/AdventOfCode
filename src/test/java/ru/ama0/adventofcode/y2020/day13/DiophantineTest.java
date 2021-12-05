package ru.ama0.adventofcode.y2020.day13;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2020.day13.math.Diophantine;

import static org.junit.jupiter.api.Assertions.*;

class DiophantineTest {

    @Test
    void testDiophantine() {
        long a1 = -7;
        long a2 = 13;
        long z = 1;

        val dio = Diophantine.solve(a1, a2, z);

        long x0 = dio.getFx().apply(0L);
        long y0 = dio.getFy().apply(0L);
        long x1 = dio.getFx().apply(1L);
        long y1 = dio.getFy().apply(1L);
        assertEquals(a1 * x0 + a2 * y0, z);
        assertEquals(a1 * x1 + a2 * y1, z);
    }

}
