package ru.ama0.adventofcode.y2021.day10.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Stack;

@RequiredArgsConstructor
@EqualsAndHashCode
public class BracketsChunk {

    private final String brackets;

    /**
     * @return error score or 0 if chunk is valid
     */
    public long calculateSyntaxErrorScore() {
        var stack = new Stack<Character>();
        for (int pos = 0; pos < brackets.length(); pos++) {
            var bracket = brackets.charAt(pos);
            var expected = Constants.BRACKET_PAIRS.get(bracket);
            if (expected == null) {
                stack.push(bracket);
            } else if (!expected.equals(stack.pop())) {
                return Constants.ERROR_SCORE.get(bracket);
            }
        }
        return 0L;
    }

    /**
     * @return completion score or 0 if chunk is invalid
     */
    public long calculateCompletionScore() {
        var stack = new Stack<Character>();
        for (int pos = 0; pos < brackets.length(); pos++) {
            var bracket = brackets.charAt(pos);
            var expected = Constants.BRACKET_PAIRS.get(bracket);
            if (expected == null) {
                stack.push(bracket);
            } else if (expected.equals(stack.pop())) {
                return 0L; // returning 0 for errors
            }
        }

        var completionScore = 0L;
        while (!stack.isEmpty()) {
            var bracket = stack.pop();
            var scorePoints = Constants.COMPLETION_SCORE.get(bracket);
            completionScore = completionScore * 5 + scorePoints;
        }
        return completionScore;
    }

    @Override
    public String toString() {
        return brackets;
    }
}
