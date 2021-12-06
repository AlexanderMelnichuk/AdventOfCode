package ru.ama0.adventofcode.y2021.day05.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {

    private Field field;

    @Test
    void toString_customParameters_success() {
        field = new Field(5, 3);
        var points = field.getPoints();
        points[2][1] = 2;
        points[3][2] = 18;
        points[0][2] = 30;
        points[0][0] = 24;
        var expectedFieldString = "Field:\n" +
                " 0  0 \n" +
                " 2  0 \n" +
                " 0 18 \n" +
                " 0  0 \n";

        var fieldString = field.toString(1, 4, 1, 2);

        assertThat(fieldString).isEqualTo(expectedFieldString);
    }

}
