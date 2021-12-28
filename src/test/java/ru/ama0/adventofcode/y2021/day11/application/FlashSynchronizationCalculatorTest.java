package ru.ama0.adventofcode.y2021.day11.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day11.infrastructure.OctopusRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FlashSynchronizationCalculatorTest {

    private FlashSynchronizationCalculator calculator;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new OctopusRepositoryImpl();
        repository.init("/2021/input11test.txt");
        calculator = new FlashSynchronizationCalculator(repository);
    }

    @Test
    void execute() {
        var step = calculator.execute();

        assertThat(step).isEqualTo(195);
    }
}
