package ru.ama0.adventofcode.y2021.day10.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day10.domain.BracketsChunk;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class BracketsRepositoryImplTest {

    private BracketsRepositoryImpl repository;

    @BeforeEach
    void setUp() throws IOException {
        repository = new BracketsRepositoryImpl();
        repository.init("/2021/input10test.txt");
    }

    @Test
    void getAll() {
        assertThat(repository.getAll())
                .containsExactly(
                        new BracketsChunk("[({(<(())[]>[[{[]{<()<>>"),
                        new BracketsChunk("[(()[<>])]({[<{<<[]>>("),
                        new BracketsChunk("{([(<{}[<>[]}>{[]{[(<()>"),
                        new BracketsChunk("(((({<>}<{<{<>}{[]{[]{}"),
                        new BracketsChunk("[[<[([]))<([[{}[[()]]]"),
                        new BracketsChunk("[{[{({}]{}}([{[{{{}}([]"),
                        new BracketsChunk("{<[[]]>}<{[{[{[]{()[[[]"),
                        new BracketsChunk("[<(<(<(<{}))><([]([]()"),
                        new BracketsChunk("<{([([[(<>()){}]>(<<{{"),
                        new BracketsChunk("<{([{{}}[<[[[<>{}]]]>[]]"));
    }
}
