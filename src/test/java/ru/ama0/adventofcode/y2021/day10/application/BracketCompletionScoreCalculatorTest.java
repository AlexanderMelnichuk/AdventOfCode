package ru.ama0.adventofcode.y2021.day10.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day10.infrastructure.BracketsRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class BracketCompletionScoreCalculatorTest {

    private BracketsRepositoryImpl bracketsRepository;

    private BracketCompletionScoreCalculator interactor;

    @BeforeEach
    void setUp() throws IOException {
        bracketsRepository = new BracketsRepositoryImpl();
        bracketsRepository.init("/2021/input10test.txt");

        interactor = new BracketCompletionScoreCalculator(bracketsRepository);
    }

    @Test
    void calculateCompletionScore_valid_valid() {
        var completionScore = interactor.execute();

        assertThat(completionScore).isEqualTo(288957L);
    }
}
