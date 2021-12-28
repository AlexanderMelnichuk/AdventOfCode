package ru.ama0.adventofcode.y2021.day07.infrastructure;

import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

class CrabPositionsRepositoryImplTest {

    private SomeRepositoryImpl repository;

    @BeforeEach
    void setUp() throws IOException {
        repository = new SomeRepositoryImpl();
        repository.init("/2021/input07test.txt");
    }

}
