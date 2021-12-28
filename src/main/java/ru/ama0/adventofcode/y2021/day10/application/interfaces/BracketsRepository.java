package ru.ama0.adventofcode.y2021.day10.application.interfaces;

import ru.ama0.adventofcode.y2021.day10.domain.BracketsChunk;

import java.util.List;

public interface BracketsRepository {

    List<BracketsChunk> getAll();

}
