package ru.ama0.adventofcode.y2021.day04.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(new int[][] {
                {22, 13, 17, 11, 0},
                {8, 2, 23, 4, 24},
                {21, 9, 14, 16, 7},
                {6, 10, 3, 18, 5},
                {1, 12, 20, 15, 19}});
    }

    @Test
    void drawToWin() {
        int[] numbers = {11, 4, 16, 18, 15};
        Arrays.stream(numbers).forEach(board::draw);

        assertThat(board.isWinner()).isTrue();
    }

    @Test
    void drawToLose() {
        int[] numbers = {11, 4, 16, 18, 20, 10, 21, 19, 14, 2, 22};
        Arrays.stream(numbers).forEach(board::draw);

        assertThat(board.isWinner()).isFalse();
    }

}
