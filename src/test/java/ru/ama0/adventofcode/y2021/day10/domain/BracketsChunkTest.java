package ru.ama0.adventofcode.y2021.day10.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BracketsChunkTest {

    private static Stream<Arguments> getExpectedCompletionScores() {
        return Stream.of(
                Arguments.of("[({(<(())[]>[[{[]{<()<>>", 288957),
                Arguments.of("[(()[<>])]({[<{<<[]>>(", 5566),
                Arguments.of("(((({<>}<{<{<>}{[]{[]{}", 1480781),
                Arguments.of("{<[[]]>}<{[{[{[]{()[[[]", 995444),
                Arguments.of("<{([{{}}[<[[[<>{}]]]>[]]", 294)
        );
    }

    @ParameterizedTest
    @MethodSource("getExpectedCompletionScores")
    void calculateCompletionScore_valid_valid(String brackets, long expectedCompletionScore) {
        var chunk = new BracketsChunk(brackets);

        var completionScore = chunk.calculateCompletionScore();

        assertThat(completionScore).isEqualTo(expectedCompletionScore);
    }


}
