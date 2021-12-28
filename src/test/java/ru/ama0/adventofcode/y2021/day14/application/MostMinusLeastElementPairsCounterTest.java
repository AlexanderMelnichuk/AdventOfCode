package ru.ama0.adventofcode.y2021.day14.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day14.infrastructure.PolymerDataRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MostMinusLeastElementPairsCounterTest {

    private PolymerDataRepositoryImpl repository;

    private MostMinusLeastElementPairsCounter counter;

    @BeforeEach
    void setUp() throws IOException {
        repository = new PolymerDataRepositoryImpl();
        repository.init("/2021/input14test.txt");
        counter = new MostMinusLeastElementPairsCounter(repository);
    }

    @Test
    void execute_10_valid() {
        var result = counter.execute(10);

        assertThat(result).isEqualTo(1588);
    }
}
