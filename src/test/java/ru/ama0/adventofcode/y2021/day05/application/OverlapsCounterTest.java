package ru.ama0.adventofcode.y2021.day05.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day05.infrastructure.LineRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class OverlapsCounterTest {

    private OverlapsCounter overlapsCounter;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new LineRepositoryImpl();
        repository.init("/2021/input05test.txt");

        overlapsCounter = new OverlapsCounter(repository);
    }

    @Test
    void execute_onlyVerticalAndHorizontal_success() {
        var count = overlapsCounter.execute(false);
        assertThat(count).isEqualTo(5);
    }

    @Test
    void execute_includeDiagonals_success() {
        var count = overlapsCounter.execute(true);
        assertThat(count).isEqualTo(12);
    }
}
