package ru.ama0.adventofcode.y2021.day04.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ama0.adventofcode.y2021.sharedkernel.Point;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @ParameterizedTest
    @MethodSource("getIllegalPointArguments")
    void constructor_wrongParams_IllegalArgumentException(int row, int column) {
        assertThatThrownBy(() -> new Point(row, column))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void constructor_valid_valid() {
        var point = new Point(0, 4);

        assertThat(point.getRow()).isZero();
        assertThat(point.getColumn()).isEqualTo(4);
    }

    private static Stream<Arguments> getIllegalPointArguments() {
        return Stream.of(
                Arguments.of(-1, 2),
                Arguments.of(2, -1),
                Arguments.of(5, 2),
                Arguments.of(2, 5)
        );
    }

}
