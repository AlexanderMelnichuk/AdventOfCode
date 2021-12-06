package ru.ama0.adventofcode.y2021.day04.application.interfaces;

import ru.ama0.adventofcode.y2021.day04.domain.Board;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface InputDataRepository {

    void init() throws IOException;

    List<Integer> getNumbers();

    Collection<Board> getBoards();

}
