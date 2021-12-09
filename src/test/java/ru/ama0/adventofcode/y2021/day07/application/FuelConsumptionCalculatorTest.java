package ru.ama0.adventofcode.y2021.day07.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ama0.adventofcode.y2021.day07.infrastructure.SomeRepositoryImpl;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FuelConsumptionCalculatorTest {

    private FuelConsumptionCalculator interactor;

    @BeforeEach
    void setUp() throws IOException {
        var repository = new SomeRepositoryImpl();
        repository.init("/2021/input07test.txt");

        interactor = new FuelConsumptionCalculator(repository);
    }

    @Test
    void execute_linear_valid() {
        var result = interactor.execute(FuelConsumptionType.LINEAR);

        assertThat(result).isEqualTo(37);
    }



    @ParameterizedTest
    @MethodSource("getProgressiveConsumptionParameters")
    void progressiveConsumption(int x, int y, long c) {
        assertThat(interactor.progressiveConsumption(x, y)).isEqualTo(c);
    }

    private static Stream<Arguments> getProgressiveConsumptionParameters() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(1, 2, 1),
                Arguments.of(1, 3, 3),
                Arguments.of(0, 3, 6),
                Arguments.of(4, 1, 6),
                Arguments.of(2, 6, 10)
        );
    }

}
