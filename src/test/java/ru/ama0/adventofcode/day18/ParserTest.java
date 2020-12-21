package ru.ama0.adventofcode.day18;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ama0.adventofcode.day18.myparser.Parser;
import ru.ama0.adventofcode.day18.myparser.nodes.Node;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    final Parser parser = new Parser();

    @ParameterizedTest
    @MethodSource("getExpressions")
    void parse(String expression, Long expectedResult) {
        Node ast = parser.parse(expression);
        ast.calc();

        assertThat(ast.getResult()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> getExpressions() {
        return Stream.of(
                Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437),
                Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 12240),
                Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632)
        );
    }

}