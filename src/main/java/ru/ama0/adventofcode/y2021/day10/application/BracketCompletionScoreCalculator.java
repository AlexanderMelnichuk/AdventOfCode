package ru.ama0.adventofcode.y2021.day10.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day10.application.interfaces.BracketsRepository;
import ru.ama0.adventofcode.y2021.day10.domain.BracketsChunk;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BracketCompletionScoreCalculator {

    private final BracketsRepository repository;

    public long execute() {
        var completionScores = repository.getAll()
                .stream()
                .map(BracketsChunk::calculateCompletionScore)
                .filter(score -> score != 0)
                .sorted(Long::compare)
                .collect(Collectors.toList());

        if (completionScores.size() % 2 == 0) {
            throw new IllegalStateException("Completion scores count is even. It should be odd.");
        }

        return completionScores.get(completionScores.size() / 2);
    }

}
