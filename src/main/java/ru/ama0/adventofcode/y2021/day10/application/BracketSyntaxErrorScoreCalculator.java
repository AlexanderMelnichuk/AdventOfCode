package ru.ama0.adventofcode.y2021.day10.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day10.application.interfaces.BracketsRepository;
import ru.ama0.adventofcode.y2021.day10.domain.BracketsChunk;

@RequiredArgsConstructor
public class BracketSyntaxErrorScoreCalculator {

    private final BracketsRepository repository;

    public long execute() {
        var chunks = repository.getAll();

        return chunks.stream()
                .map(BracketsChunk::calculateSyntaxErrorScore)
                .reduce(Long::sum)
                .orElse(0L);
    }


}
