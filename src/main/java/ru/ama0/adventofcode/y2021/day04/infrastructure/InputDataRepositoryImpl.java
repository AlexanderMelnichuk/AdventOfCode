package ru.ama0.adventofcode.y2021.day04.infrastructure;


import lombok.Getter;
import ru.ama0.adventofcode.util.Io;
import ru.ama0.adventofcode.y2021.day04.application.interfaces.InputDataRepository;
import ru.ama0.adventofcode.y2021.day04.domain.Board;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class InputDataRepositoryImpl implements InputDataRepository {

    private static final int BOARD_SIZE = 5;
    private static final String INPUT_FILE_NAME = "/2021/input04.txt";

    private List<Integer> numbers;
    private Collection<Board> boards;

    @Override
    public void init() throws IOException {
        var lines = Io.readLines(INPUT_FILE_NAME);

        numbers = Arrays.stream(lines.get(0).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        boards = new ArrayList<>();

        int lineIndex = 0;
        int boardRowIndex = 0;
        int[][] boardMatrix = new int[BOARD_SIZE][BOARD_SIZE];
        String line;

        // Skip first empty lines
        do {
            line = lines.get(lineIndex);
            lineIndex++;
        } while (line.isBlank() && lines.size() <= lineIndex);

        // Read board data
        while (lineIndex < lines.size()) {
            line = lines.get(lineIndex);
            lineIndex++;

            if (line.isBlank()) {
                if (boardRowIndex != 0) {
                    // Check previous board matrix
                    if (boardRowIndex != BOARD_SIZE) {
                        throw new IllegalArgumentException(
                                MessageFormat.format("Wrong number of lines in a board: {0}", boardRowIndex));
                    }
                    // Store previous board
                    boards.add(new Board(boardMatrix));
                }
                // Prepare new board
                boardRowIndex = 0;
                boardMatrix = new int[BOARD_SIZE][BOARD_SIZE];
            } else {
                // Fill one row of the board
                int[] row = Arrays.stream(line.split(" "))
                        .filter(Predicate.not(String::isEmpty))
                        .map(Integer::parseInt)
                        .mapToInt(i -> i)
                        .toArray();
                boardMatrix[boardRowIndex] = row;

                boardRowIndex++;
            }
        }

    }
}
