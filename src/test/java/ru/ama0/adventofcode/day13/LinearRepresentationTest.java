package ru.ama0.adventofcode.day13;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.day13.math.LinearRepresentation;

import static org.assertj.core.api.Assertions.assertThat;

class LinearRepresentationTest {

    @Test
    void lr () {
        val lr = LinearRepresentation.of(15, 37);

        assertThat(lr.getX()).isEqualTo(5);
        assertThat(lr.getY()).isEqualTo(-2);
        assertThat(lr.getA() * lr.getX() + lr.getB() * lr.getY()).isEqualTo(1);
    }

    @Test
    void lrNegative() {
        val lr = LinearRepresentation.of(-15, 37);

        assertThat(lr.getX()).isEqualTo(-5);
        assertThat(lr.getY()).isEqualTo(-2);
        assertThat(lr.getA() * lr.getX() + lr.getB() * lr.getY()).isEqualTo(1);
    }

    // TODO complete test
    @Test
    void lr2() {
        val lr = LinearRepresentation.of(-7, 13);
        val lr2 = LinearRepresentation.of(-7, 59);
        val lr3 = LinearRepresentation.of(-13, 59);

        System.out.println(lr);
        System.out.println(lr2);
        System.out.println(lr3);
    }
}