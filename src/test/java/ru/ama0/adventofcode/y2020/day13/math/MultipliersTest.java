package ru.ama0.adventofcode.y2020.day13.math;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultipliersTest {
    @Test
    void name() {
        val multipliers = Multipliers.get(24);

        assertThat(multipliers).containsExactlyInAnyOrder(8, 3);
    }
}
