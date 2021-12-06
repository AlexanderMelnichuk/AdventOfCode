package ru.ama0.adventofcode.y2021.day03.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day03.application.interfaces.InputDataRepository;
import ru.ama0.adventofcode.y2021.day03.infrastructure.InputDataRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class RatingsCalculatorTest {

    private final InputDataRepository repository = new InputDataRepositoryImpl("/2021/input03test.txt");

    private RatingsCalculator ratingsCalculator;

    @BeforeEach
    void setUp() throws IOException {
        repository.init();
        ratingsCalculator = new RatingsCalculator(repository);
    }

    @Test
    void co2ScrubberRating_correct_correct() {
        var co2ScrubberRating = ratingsCalculator.calculateCo2ScrubberRating();
        assertThat(co2ScrubberRating).isEqualTo(10);
    }

    @Test
    void oxygenGeneratorRating_correct_correct() {
        var oxygenGeneratorRating = ratingsCalculator.calculateOxygenGeneratorRating();
        assertThat(oxygenGeneratorRating).isEqualTo(23);
    }




}
