package ru.ama0.adventofcode.y2020.day13;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2020.day13.math.Modular;
import ru.ama0.adventofcode.y2020.day13.math.ModularSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModularSystemTest {
    @Test
    void modularSystem() {
        val ms = ModularSystem.of(Modular.of(13, 7, 24), Modular.of(8, 5, 75));

        assertEquals(235, ms.getX().longValue());
    }

    @Test
    void aocTest1() {
        val ms = ModularSystem.of(
                Modular.of(67, -1, 7),
                Modular.of(67, -2, 59),
                Modular.of(67, -3, 61));

        assertEquals(754018 / 67, ms.getX().longValue());
    }

    @Test
    void aocTest2() {
        val ms = ModularSystem.of(
                Modular.of(7, -1, 13),
                Modular.of(7, -4, 59),
                Modular.of(7, -6, 31),
                Modular.of(7, -7, 19));

        assertEquals(1068781 / 7, ms.getX().longValue());
    }

    @Test
    void aocTest3() {
        val ms = ModularSystem.of(
                Modular.of(1789, -1, 37),
                Modular.of(1789, -2, 47),
                Modular.of(1789, -3, 1889));

        assertEquals(1202161486 / 1789, ms.getX().longValue());
    }
}
