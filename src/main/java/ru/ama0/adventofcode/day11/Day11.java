package ru.ama0.adventofcode.day11;

import ru.ama0.adventofcode.day11.strategy.AdjacentStrategy;
import ru.ama0.adventofcode.day11.strategy.StateStrategy;
import ru.ama0.adventofcode.day11.strategy.VisibilityStrategy;
import ru.ama0.adventofcode.util.Io;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static ru.ama0.adventofcode.day11.Constants.OCCUPIED;

public class Day11 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Io.readLines("/day11.txt");
        int columnsCount = lines.get(0).length();
        int rowsCount = lines.size();


        char[][] initialState = new char[rowsCount][columnsCount];
        for (int i = 0; i < lines.size(); i++) {
            initialState[i] = lines.get(i).toCharArray();
        }

        print(initialState);
        char[][] firstSimulationResult = simulate(initialState, new AdjacentStrategy());
        System.out.println(countOccupiedSeats(firstSimulationResult));

        char[][] secondSimulationResult = simulate(initialState, new VisibilityStrategy());
        System.out.println(countOccupiedSeats(secondSimulationResult));
    }

    private static char[][] simulate(@Nonnull char[][] initialState, StateStrategy strategy) {
        int rowsCount = initialState.length;
        int columnsCount = initialState[0].length;
        char[][] currentState;
        char[][] nextState = initialState;
        do {
            currentState = nextState;
            nextState = new char[rowsCount][columnsCount];
            for (int row = 0; row < rowsCount; row++) {
                for (int col = 0; col < columnsCount; col++) {
                    nextState[row][col] = strategy.getNextState(currentState, row, col);
                }
            }

            System.out.println();
            print(nextState);
        } while (!Arrays.deepEquals(currentState, nextState));
        return nextState;
    }

    private static void print(char[][] initialState) {
        Arrays.stream(initialState)
                .forEach(System.out::println);
    }

    private static long countOccupiedSeats(char[][] nextState) {
        return Arrays.stream(nextState)
                .flatMap((char[] line) -> new String(line).chars().mapToObj(c -> (char) c))
                .filter(c -> c == OCCUPIED)
                .count();
    }

}
