package ru.ama0.adventofcode.y2020.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElvenCountTest {
    private final ElvenCount elvenCount = new ElvenCount();

    @Test
    void test2020() {
        int result = elvenCount.nthNumber("2,3,1", 2020);

        assertEquals(78, result);
    }
}
