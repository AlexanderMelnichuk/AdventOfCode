package ru.ama0.adventofcode.y2021.day12.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day12.infrastructure.CaveRepositoryImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CavePathsCounterTest {

    private CaveRepositoryImpl caveRepository;
    private CavePathsCounter cavePathsCounter;

    @BeforeEach
    void setUp() throws IOException {
        caveRepository = new CaveRepositoryImpl();
        caveRepository.init("/2021/input12test.txt");
        cavePathsCounter = new CavePathsCounter(caveRepository);
    }

    @Test
    void execute_maxCount1() {
        var pathCount = cavePathsCounter.execute((byte) 1);

        assertThat(pathCount).hasSize(10);
    }

    @Test
    void execute_maxCount2() {
        var pathCount = cavePathsCounter.execute((byte) 2);

        assertThat(pathCount).hasSize(36);
    }

}
