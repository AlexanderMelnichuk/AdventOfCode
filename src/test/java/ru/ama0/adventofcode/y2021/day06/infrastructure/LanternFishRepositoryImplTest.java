package ru.ama0.adventofcode.y2021.day06.infrastructure;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

class LanternFishRepositoryImplTest {

    private LanternFishRepositoryImpl repository;


    @BeforeEach
    void setUp() throws IOException {
        repository = new LanternFishRepositoryImpl();
        repository.init("/2021/input06test.txt");
    }

    @Test
    void init_ok() {
        var counts = repository.retrieveCounts();

        assertThat(counts).containsExactly(0L, 1L, 1L, 2L, 1L, 0L, 0L, 0L, 0L);
    }

    @Test
    void retrieveCounts_twice_differentCopies() {
        var copy1 = repository.retrieveCounts();
        copy1[0] = copy1[0] + 1;
        var copy2 = repository.retrieveCounts();

        assertThat(copy2).doesNotContain(copy1[0], atIndex(0));
    }
}
