package ru.ama0.adventofcode.y2021.day04.application;

import lombok.RequiredArgsConstructor;
import ru.ama0.adventofcode.y2021.day04.application.interfaces.InputDataRepository;

import java.io.IOException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LoserCalculator {

    private final InputDataRepository repository;

    public int execute() throws IOException {
        repository.init();

        var boards = repository.getBoards();
        var numbers = repository.getNumbers();

        // Play boards until there is only one left.
        int numberIndex = 0;
        while (numberIndex < numbers.size()) {
            var number = numbers.get(numberIndex);
            boards.forEach(board -> board.draw(number));
            boards = boards.stream()
                    .filter(board -> !board.isWinner())
                    .collect(Collectors.toList());
            if (boards.size() == 1) {
                break;
            }
            numberIndex++;
        }

        // Play the last board.
        var board = boards.iterator().next();
        int number;
        do {
            number = numbers.get(++numberIndex);
            board.draw(number);
        } while (!board.isWinner());

        return board.getNotDrawnNumbers().stream().reduce(Integer::sum).orElse(0) * number;
    }

}
