package ru.ama0.adventofcode.y2021.day22.infrastructure;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ama0.adventofcode.y2021.day22.domain.Cuboid;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CuboidRepositoryImplTest {

    private CuboidRepositoryImpl repository;

    @BeforeEach
    void setUp() throws IOException {
        repository = new CuboidRepositoryImpl();
        repository.init("/2021/input22test1.txt");
    }

    @Test
    void getCuboids() {
        List<Cuboid> cuboids = repository.getCuboids();
        assertThat(cuboids)
                .hasSize(22)
                .contains(new Cuboid(true, -20, 33, -21, 23, -26, 28), Index.atIndex(1));
    }
}
