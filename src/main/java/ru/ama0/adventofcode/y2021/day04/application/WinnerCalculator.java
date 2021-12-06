package ru.ama0.adventofcode.y2021.day04.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day04.application.interfaces.InputDataRepository;

import java.io.IOException;

@RequiredArgsConstructor
public class WinnerCalculator {

    private final InputDataRepository repository;

    public int execute() throws IOException {
        repository.init();
        for (var number : repository.getNumbers()) {
            for (var board : repository.getBoards()) {
                board.draw(number);
                if (board.isWinner()){
                    var sum = board.getNotDrawnNumbers().stream().reduce(Integer::sum).orElse(0);
                    return sum * number;
                }
            }
        }
        throw new IllegalStateException("No board has won");
    }

}
