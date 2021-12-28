package ru.ama0.adventofcode.y2021.day12.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CaveRepositoryImplTest {

    private CaveRepositoryImpl caveRepository;

    @BeforeEach
    void setUp() throws IOException {
        caveRepository = new CaveRepositoryImpl();
        caveRepository.init("/2021/input12test.txt");
    }

    @Test
    void getAll_valid_valid() {
        var caves = caveRepository.getAll();

        assertThat(caves).hasSize(6);
        var caveA = caves.get("A");
        var caveB = caves.get("b");
        assertThat(caveA).isNotNull();
        assertThat(caveB).isNotNull();
        var caveStart = caves.get("start");
        assertThat(caveStart.getConnections())
                .containsExactlyInAnyOrder(caveA, caveB);
    }

}
